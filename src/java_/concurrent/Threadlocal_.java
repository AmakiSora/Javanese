package java_.concurrent;

/**
 * 线程本地变量(Threadlocal)
 * 如果你创建了ThreadLocal，那么访问这个变量的每个线程都会有这个变量的一个本地副本
 * 当多个线程操作这个变量时，实际操作的是自己本地内存里面变量，从而避免了线程安全问题
 * 注意Threadlocal不支持继承性，即同一个ThreadLocal变量在父线程中被设置值后，在子线程是获取不到的(如需继承请使用InheritableThreadLocal)
 */
public class Threadlocal_ {
    static void print_(String str) {
        //输出当前线程中本地变量的值
        System.out.println(str + ":" + localStr.get());
        //清除当前线程中的本地变量
//        localStr.remove();
    }
    //创建静态本地线程变量
    static ThreadLocal<String> localStr = new ThreadLocal<>();

    public void test(){
        Thread t1 = new Thread(()->{
            localStr.set("线程1的变量");
            print_("线程1");
            System.out.println("线程1移除->"+localStr.get());
        });

        Thread t2 = new Thread(()->{
            localStr.set("线程2的变量");
            print_("线程2");
            System.out.println("线程2移除->"+localStr.get());
        });

        t1.start();
        t2.start();
    }

}
