package java_.queue_;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        putThread(queue);
        takeThreads(queue);
    }

    /**
     * 自定义延迟方法
     */
    static class DIYDelayed implements Delayed {

        long time = System.currentTimeMillis();

        public DIYDelayed(long time) {
            this.time = time;
        }

        //getDelay定义了剩余到期时间
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        //compareTo方法定义了元素排序规则
        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(this.time), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
    }

    //消费线程池
    private void takeThreads(DelayQueue<DIYDelayed> queue) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            while (true) {
                threadPool.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "等待执行工作");
                        DIYDelayed take = queue.take();
                        System.out.println(Thread.currentThread().getName() + "执行了 " + take + " 的任务");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
                    long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    long time = now + ThreadLocalRandom.current().nextInt(10) * 1000;
                    System.out.println("生成元素执行时间:" + LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                    queue.put(new DIYDelayed(time));
                    System.out.println("现有任务:" + queue);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
