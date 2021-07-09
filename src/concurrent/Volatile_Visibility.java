package concurrent;

/**
 * Volatile的内存可见性
 */
public class Volatile_Visibility {
    public static boolean flag = true;//加上volatile关键字解决
    public void test(){
        new Thread(()->{
            System.out.println("A线程开始");
            while (flag){}
            System.out.println("A线程结束");
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println("B线程修改为false");
                flag = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B线程结束");
        }).start();
    }
}
