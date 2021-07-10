package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 *
 * 验证是否是死锁：
 * 1.jps 查看当前java进程
 * 2.jstack 进程号 查看当前进程的情况，最后结果返回 Found 1 deadlock 则有死锁
 */
public class Deadlock {
    static Object A = new Object();
    static Object B = new Object();
    public void test(){
        new Thread(()->{
            synchronized (A){
                System.out.println("持有A锁，获取B锁");
                try { TimeUnit.SECONDS.sleep(1); }
                catch (InterruptedException e) { e.printStackTrace(); }
                synchronized (B){
                    System.out.println("获得B锁");
                }
            }
        },"X").start();

        new Thread(()->{
            synchronized (B){
                System.out.println("持有B锁，获取A锁");
                try { TimeUnit.SECONDS.sleep(1); }
                catch (InterruptedException e) { e.printStackTrace(); }
                synchronized (A){
                    System.out.println("获得A锁");
                }
            }
        },"Y").start();
    }

}
