package concurrent;

/**
 * 用户线程和守护线程的区别
 * 以下代码运行结果：
 * 当a为用户线程时，主线程结束了，a线程也不会结束，jvm也不会退出
 * 当a为守护线程时，没有用户线程了，jvm退出
 * 得出结论：
 * 守护线程是依赖于用户线程，用户线程退出了，守护线程也就会退出，典型的守护线程如垃圾回收线程。
 * 用户线程是独立存在的，不会因为其他用户线程退出而退出。
 */
public class UserThread_VS_DaemonThead {
    public void test(){
        Thread a = new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "线程类型为" + Thread.currentThread().isDaemon());
            //isDaemon()返回线程的类型，true为守护线程，false为用户线程
            while (true){}
        },"a");
        a.setDaemon(true);//将a线程类型改为守护线程
        a.start();
        System.out.println(Thread.currentThread().getName() + "结束了");
    }
}
