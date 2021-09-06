package java_.concurrent;

/**
 * 虚假唤醒
 * 当一个条件满足时，很多线程都被唤醒了，但是只有其中部分是有用的唤醒，其它的唤醒都是无用功
 *
 * 解决方案:
 * 把if判断改为while循环判断
 * 因为if只会执行一次，执行完会接着向下执行if（）外边的
 * 而while不会，直到条件满足才会向下执行while（）外边的
 */
public class SpuriousWakeup {
    static class Only01{//理论上a只能等于1或0
        int a = 0;
        public synchronized void increase() throws InterruptedException{
            if (a != 0) this.wait();//改为while则不会出现该问题
            a++;
            System.out.println("线程" + Thread.currentThread().getName() + "加一，a = " + a);
            this.notifyAll();
        }
        public synchronized void decrease()throws InterruptedException{
            if (a != 1) this.wait();//改为while则不会出现该问题
            a--;
            System.out.println("线程" + Thread.currentThread().getName() + "减一，a = " + a);
            this.notifyAll();
        }
    }
    public void test()throws InterruptedException{
        Only01 only01 = new Only01();
        int cyc = 1000;
        new Thread(()->{
            for (int i = 0; i < cyc; i++) {
                try {
                    only01.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < cyc; i++) {
                try {
                    only01.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < cyc; i++) {
                try {
                    only01.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < cyc; i++) {
                try {
                    only01.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
