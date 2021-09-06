package java_.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * ThreadPoolExecutor参数
 *      int corePoolSize,                  常驻线程数
 *      int maximumPoolSize,               最大线程数
 *      long keepAliveTime,                线程存活时间
 *      TimeUnit unit,                     存活时间单位
 *      BlockingQueue<Runnable> workQueue, 阻塞队列
 *      ThreadFactory threadFactory,       线程工厂
 *      RejectedExecutionHandler handler   拒绝策略
 */
@SuppressWarnings("all")//关闭警告
public class CustomThreadPool {
    public void test(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()//默认策略会抛出异常
        );
        try{
            for (int i = 0; i < 10; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"执行工作");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }
    }
}
