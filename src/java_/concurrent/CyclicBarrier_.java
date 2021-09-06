package java_.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏CyclicBarrier
 * N个线程相互等待，任何一个线程完成之前，所有的线程都必须等待。
 * 十名运动员各自准备比赛,需要等待所有运动员都准备好以后,裁判才能说开始然后所有运动员一起跑
 */
public class CyclicBarrier_ {
    public static final int RunnerNum = 5;//跑步的人数

    public void test(){
        Thread AllReady = new Thread(()->{
            System.out.println("所有选手准备完毕");
            System.out.println("预备，跑！");//执行完此线程，其他线程才会继续
        });

        CyclicBarrier cyclicBarrier = new CyclicBarrier(RunnerNum,AllReady);

        for (int i = 0; i < RunnerNum; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"号选手装备完毕");
                    cyclicBarrier.await();//等待其他选手准备完毕
                    System.out.println(Thread.currentThread().getName()+"号选手到达了终点");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
