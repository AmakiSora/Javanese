package java_.concurrent;

/**
 * 缓存行填充
 * 读取缓存以cache line为基本单位，目前64bytes
 * 位于同一缓存行的两个不同数据，被两个不同CPU锁定，产生互相影响的伪共享问题
 * 伪共享问题：可以通过补位对齐解决（原理同上，缓存行64位，所以数据的前后只要留有占位的变量就可以避免和其他数据同个缓存行）
 *
 * CPU，硬件级别的缓存是一行行读取的，一般是64位
 * 如果4字节的x和4字节的y同时存储在同一个缓存行中
 * 那么当对x做写操作的时候，需要阻塞对y的操作
 * 对y的操作也要阻塞x的操作
 * 所以理论上，如果能够将所需要读取的数据独立在一个缓存行中，或者在同一个缓存行的其他数据只读，则可以提高读写效率
 *
 * 在jdk1.7的LinkedBlockingQueue的实现中有用到此技巧
 */
public class CacheLinePadding {

    private static final long COUNT = 1_0000_0000L;//循环次数

    private static class T1{//正常情况
        public volatile long x = 0L;//真正用到的数据
    }
    private static class T2{//使用了补齐的方式，使得真正有意义的数据被保存在一个缓存行中，不和其他会被写的数据一起
        private volatile long p1,p2,p3,p4,p5,p6,p7;//无用的数据,long类型长度为8字节
        public volatile long x = 0L;//真正用到的数据
        private volatile long p9,p10,p11,p12,p13,p14,p15;//无用的数据,填充到64字节
    }

    public void test() throws InterruptedException {
        long start = System.nanoTime();
        test1();//正常方式
        System.out.println("正常方式花费的时间:"+(System.nanoTime()-start)/100_0000);

        start = System.nanoTime();
        test2();//补齐方式
        System.out.println("补齐方式花费的时间:"+(System.nanoTime()-start)/100_0000);
    }
    public void test1() throws InterruptedException {
        T1[] arr = new T1[2];
        arr[0] = new T1();
        arr[1] = new T1();

        Thread t1 = new Thread(()->{//第一个线程不断修改arr[0]里的x
            for (long i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
        });
        Thread t2 = new Thread(()->{//第二个线程不断修改arr[1]里的x
            for (long i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    public void test2() throws InterruptedException {
        T2[] arr = new T2[2];
        arr[0] = new T2();
        arr[1] = new T2();

        Thread t1 = new Thread(()->{//第一个线程不断修改arr[0]里的x
            for (long i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
        });
        Thread t2 = new Thread(()->{//第二个线程不断修改arr[1]里的x
            for (long i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
