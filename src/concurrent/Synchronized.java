package concurrent;

/**
 * synchronized关键字的使用
 */
public class Synchronized {
    class Ticket{
        private int num = 1000;
        public synchronized void sale(){//卖票
            if (num > 0){
                num--;
                System.out.println("线程"+Thread.currentThread().getName()+"卖出了1张票"+"剩下"+num+"张");
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
