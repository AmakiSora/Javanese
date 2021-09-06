package java_.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 减一计数器CountDownLatch
 * 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行。
 */
public class CountDownLatch_ {
    public void test() throws InterruptedException {
        int sum = 5;
        CountDownLatch countDownLatch = new CountDownLatch(sum);//设定初始值
        for (int i = 0; i < sum; i++) {
            new Thread(()->{
                System.out.println("线程"+Thread.currentThread().getName()+"执行完成");
                countDownLatch.countDown();//减一
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待
//        countDownLatch.await(10, TimeUnit.SECONDS);//等待一段时间，如果未到0则继续执行
        System.out.println("5个子线程都执行完成,主线程继续执行");
    }
}
