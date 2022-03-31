package java_.queue_;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * 阻塞式同步队列
 * SynchronousQueue是无界的，是一种无缓冲的等待队列
 * 特性：某次添加元素后必须等待其他线程取走后才能继续添加,可以认为是一个缓存值为 1 的阻塞队列，
 * isEmpty()方法永远返回是true，
 * remainingCapacity()方法永远返回是0
 * remove()和removeAll()方法永远返回是false
 * iterator()方法永远返回空
 * peek()方法永远返回null
 * 该队列支持公平和非公平模式,默认非公平模式
 */
public class SynchronousQueue_ {
    public void test() {
        //公平模式(非公平其他线程容易饿死)
        SynchronousQueue<Integer> queue = new SynchronousQueue<>(true);
        generateElements(queue);

    }

    private void generateElements(SynchronousQueue<Integer> queue) {
        //生成元素线程数
        int threadNum = 3;
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        int random = new Random().nextInt(10);
                        //put() 往queue放进去一个element以后就一直wait直到有其他thread进来把这个element取走
                        queue.put(random);
                        System.out.println("线程:" + Thread.currentThread().getName() + " 生成了元素 " + random);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
        new Thread(() -> {
            try {
                while (true) {
                    //3秒消费一次
                    Thread.sleep(3000);
                    Integer poll = queue.take();
                    System.out.println("消费线程获取到元素: " + poll);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
