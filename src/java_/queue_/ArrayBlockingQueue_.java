package java_.queue_;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞式数组队列
 * 有界队列,有界也就意味着,它不能够存储无限多数量的对象,所以在创建时,必须要给它指定一个队列的大小
 * 阻塞队列是通过重入锁 ReenterLock 和 Condition 条件队列实现的
 * ArrayBlockingQueue有且只有一个ReenterLock
 * 支持公平锁和非公平锁
 * 注:每一个线程在获取锁的时候可能都会排队等待
 * 如果在等待时间上,先获取锁的线程的请求一定先被满足,那么这个锁就是公平的
 * 反之,这个锁就是不公平的.公平的获取锁,也就是当前等待时间最长的线程先获取锁
 */
public class ArrayBlockingQueue_ {
    public void test() throws InterruptedException {
        //默认非公平阻塞队列
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        //创建公平阻塞队列
        BlockingQueue<Integer> fairQueue = new ArrayBlockingQueue(2,true);
        generateElements(queue);
        consumerElements(queue);
        System.out.println("----------------");
        queue.clear();
        //poll 可以增加超时时间,超过时间将返回null
        Integer poll = queue.poll(5, TimeUnit.SECONDS);
        System.out.println("获取的元素为: " + poll);
        for (int i = 0; i < 10; i++) {
            //remainingCapacity 获取剩余容量
            System.out.println("队列剩余容量: " + queue.remainingCapacity());
            //offer 可以增加超时时间,超过时间将返回false,并丢弃对象
            boolean offer = queue.offer(i, 3, TimeUnit.SECONDS);
            if (offer) {
                System.out.println("添加元素 " + i + " 成功!");
            } else {
                System.out.println("添加元素 " + i + " 失败,原因:超时");
            }
        }


    }

    //生成元素
    private void generateElements(BlockingQueue<Integer> queue) {
        new Thread(() -> {
            try {
                //慢速生成
                System.out.println("生成元素线程:开始慢速生成!");
                for (int i = 0; i < 5; i++) {
                    System.out.println("生成元素线程:开始生成!");
                    //put方法,如果队列不满则放入队列中
                    queue.put(new Random().nextInt(100));
                    System.out.println("生成元素线程:生成完毕!");
                    System.out.println("生成元素线程:休眠!");
                    Thread.sleep(5000);
                }
                //快速生成
                System.out.println("生成元素线程:开始快速生成!");
                for (int i = 0; i < 10; i++) {
                    System.out.println("生成元素线程:开始生成!");
                    System.out.println("生成元素线程:阻塞啦~!");
                    //put方法,如果队列已满,则阻塞,直到队列有空位
                    queue.put(new Random().nextInt(100));
                    System.out.println("生成元素线程:生成完毕!");
                    System.out.println("生成元素线程:休眠!");
                }
                System.out.println("已经结束啦!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void consumerElements(BlockingQueue<Integer> queue) throws InterruptedException {
        //快速消费
        System.out.println("获取元素线程:开始快速消费!");
        for (int i = 0; i < 5; i++) {
            System.out.println("获取元素线程:开始取得元素!");
            System.out.println("获取元素线程:阻塞啦~!");
            //take方法,如果队列里没有元素,则阻塞,直到有元素可以获取
            Integer take = queue.take();
            System.out.println("获取元素线程:取得元素 " + take);
        }
        //慢速消费
        System.out.println("获取元素线程:开始慢速消费!");
        for (int i = 0; i < 5; i++) {
            System.out.println("获取元素线程:开始取得元素!");
            //take方法,如果队列里有元素,则取出
            Integer take = queue.take();
            System.out.println("获取元素线程:取得元素 " + take);
            Thread.sleep(5000);
        }
    }
}
