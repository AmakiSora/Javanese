package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的使用
 * 一池多线程:newFixedThreadPool
 * 一池一线程:newSingleThreadExecutor
 * 可扩容线程池:newCachedThreadPool
 */
public class ThreadPool {
    private void newFixedThreadPool_(){//一池多线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        work(threadPool1,10);
    }
    private void newSingleThreadExecutor_(){//一池一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        work(threadPool2,10);
    }

    private void newCachedThreadPool_(){//可扩容线程池
        ExecutorService threadPool3 = Executors.newCachedThreadPool();
        work(threadPool3,20);
    }
    private void work(ExecutorService threadPool,int num){
        try{
            for (int i = 0; i < num; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"执行工作");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();//关闭线程池
        }
    }
    public void test(){
        try {
            newFixedThreadPool_();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("----------------------");

            newSingleThreadExecutor_();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("----------------------");

            newCachedThreadPool_();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
