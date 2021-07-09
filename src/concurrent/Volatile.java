package concurrent;

/**
 * Volatile的内存可见性
 */
public class Volatile {
    int a = 10;//加上volatile关键字解决
    public void test(){
        new Thread(()->{
            System.out.println("a的值为"+a);
//            if (a != 10){ }
            while (a == 10){
                a = a ;
            }
            System.out.println("A线程结束");
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println("B线程修改a为5");
                a = 5;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B线程结束");
        }).start();
    }
}
