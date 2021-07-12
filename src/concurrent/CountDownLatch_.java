package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 减一计数器CountDownLatch
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
        System.out.println("5个线程都执行完成");
    }
}
