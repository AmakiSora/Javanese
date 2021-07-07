package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁的使用
 */
public class ReentrantLock_ {
    class Ticket{
        private int num = 1000;
        private final ReentrantLock lock = new ReentrantLock();
        public void sale(){
            lock.lock();//上锁
            try {
                if (num > 0){
                    num--;
                    System.out.println("线程"+Thread.currentThread().getName()+"卖出了1张票"+"剩下"+num+"张");
                }
            }finally {
                lock.unlock();//解锁
            }
        }
    }
    public void test(){
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}
