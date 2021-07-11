package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable接口
 * 创建多线程的方式之一
 * callable和Runnable的区别是callable可以有返回值，也可以抛出异常的特性
 * 以下是使用例子
 */
public class Runnable_VS_Callable {
    class RunnableThread implements Runnable{
        @Override
        public void run() {//继承Runnable接口必须要实现run方法，无返回值
            System.out.println("Runnable接口创建的线程开启！");
        }
    }
    class CallableThread implements Callable{
        @Override
        public Integer call() {//继承Callable接口必须要实现call方法，有返回值
            System.out.println("Callable接口创建的线程开启！");
            return 666;
        }
    }
    public void test() throws ExecutionException, InterruptedException {

        //Runnable的使用方法1
        new RunnableThread().run();

        //Runnable的使用方法2
        new Thread(new RunnableThread(),"A").start();

        //Callable的使用方法1
        FutureTask<Integer> f1 = new FutureTask<Integer>(new CallableThread());
        new Thread(f1,"B").start();
        System.out.println(f1.get());//获取返回值

        //Callable的使用方法2 lam表达式
        FutureTask<Integer> f2 = new FutureTask<>(()-> 1024);
        new Thread(f2,"C").start();
        System.out.println(f2.get());//获取返回值


    }
}
