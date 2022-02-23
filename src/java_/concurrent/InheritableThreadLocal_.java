package java_.concurrent;

/**
 * 可继承的本地线程变量(InheritableThreadLocal_)
 * 可以使子线程访问父线程的本地线程变量
 */
public class InheritableThreadLocal_ {
    static void print_(String str) {
        //输出当前线程中本地变量的值
        System.out.println(str + ":" + localStr.get());
        //清除当前线程中的本地变量
        localStr.remove();
    }
    //创建ThreadLocal，子线程获取不到
//    static ThreadLocal<String> localStr = new ThreadLocal<>();
    //创建InheritableThreadLocal，子线程可以获取
    static ThreadLocal<String> localStr = new InheritableThreadLocal<>();

    public void test(){
        localStr.set("233");
        Thread t1 = new Thread(()->{
            print_("线程1");
            System.out.println("线程1移除->"+localStr.get());
        });

        Thread t2 = new Thread(()->{
            print_("线程2");
            System.out.println("线程2移除->"+localStr.get());
        });

        t1.start();
        t2.start();
    }
}
