package java_.queue_;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞式链表队列
 * 由链表实现的有界队列阻塞队列，但大小默认值为Integer.MAX_VALUE
 * 所以在使用LinkedBlockingQueue时建议手动传值,为其提供我们所需的大小,避免队列过大造成机器负载或者内存爆满等情况
 * 正常情况下，链接队列的吞吐量要高于基于数组的队列(ArrayBlockingQueue)
 * 内部实现添加和删除操作使用的两个ReenterLock来控制并发执行
 */
public class LinkedBlockingQueue_ {
    public void test() throws InterruptedException {
        BlockingQueue<Integer> linkedQueue = new LinkedBlockingQueue<>(100);
        BlockingQueue<Integer> arrayQueue = new ArrayBlockingQueue<>(100);
        throughputTest(linkedQueue);
        throughputTest(arrayQueue);
        //当调用clear,remove等方法时，两个锁都会上锁
        linkedQueue.clear();
    }

    //吞吐量测试
    private void throughputTest(BlockingQueue<Integer> queue) throws InterruptedException {
        //测试次数
        int forNum = 100000;
        //线程数
        int threadNum = 100;
        List<Thread> threads = new ArrayList<>();
        for (int j = 0; j < threadNum; j++) {
            Thread offerThread = new Thread(() -> {
                for (int i = 0; i < forNum; i++) {
                    try {
                        queue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads.add(offerThread);
            Thread pollThread = new Thread(() -> {
                for (int i = 0; i < forNum; i++) {
                    try {
                        queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads.add(pollThread);
        }
        long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long finish = System.currentTimeMillis();
        System.out.println(queue.getClass().getSimpleName() + "耗时:" + (finish - start));
    }
}
