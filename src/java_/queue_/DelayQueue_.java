package java_.queue_;

import java.util.concurrent.*;

/**
 * 延迟队列
 * DelayedQuene的优先级队列使用的排序方式是队列元素的compareTo方法
 * 优先级队列存放顺序是从小到大的,所以队列元素的compareTo方法影响了队列的出队顺序
 * 若compareTo方法定义不当,会造成延时高的元素在队头,延时低的元素无法出队
 */
public class DelayQueue_ {
    public void test() {
        DelayQueue<DIYDelayed> queue = new DelayQueue<>();
        takeThreads(queue);

    }

    /**
     * 自定义延迟方法
     */
    static class DIYDelayed implements Delayed {

        //getDelay定义了剩余到期时间
        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        //compareTo方法定义了元素排序规则
        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }

    //消费线程池
    private void takeThreads(DelayQueue<DIYDelayed> queue) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        try {
            int num = 100;
            for (int i = 0; i < num; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "等待执行工作");

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();//关闭线程池
        }
    }

    //生成元素线程
    private void putThread(DelayQueue<DIYDelayed> queue) {
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(3000);//3秒生成一次
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
