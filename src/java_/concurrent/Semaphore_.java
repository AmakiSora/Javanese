package java_.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号灯Semaphore
 * 停车场停车，10辆车，5个停车位
 */
public class Semaphore_ {
    public static int ParkingSpace = 5;//停车位数量
    public static int CarsNum = 10;//车的数量
    public void test(){
        Semaphore semaphore = new Semaphore(ParkingSpace);//设置许可数量
        for (int i = 0; i < CarsNum; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//获取许可
                    System.out.println(Thread.currentThread().getName()+"号车抢到了车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));//随机停车时间
                    System.out.println(Thread.currentThread().getName()+"号车离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();//释放停车位
                }
            },String.valueOf(i)).start();
        }
    }
}
