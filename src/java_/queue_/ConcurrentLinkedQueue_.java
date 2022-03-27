package java_.queue_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 线程安全的链表队列
 * 基于链接节点的无界线程安全队列
 * 非阻塞
 */
public class ConcurrentLinkedQueue_ {
    public void test() throws InterruptedException {
        //线程安全
        Queue<Integer> queue1 = new ConcurrentLinkedQueue<>();
        //非线程安全
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            queue1.offer(i);
            queue2.offer(i);
        }
        System.out.println("线程安全");
        multiThreadedGet(queue1);
        System.out.println("非线程安全");
        multiThreadedGet(queue2);
    }

    //多线程处理
    private void multiThreadedGet(Queue<Integer> queue) throws InterruptedException {
        System.out.println(queue);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                ArrayList<Integer> integers = new ArrayList<>();
                Integer o = queue.poll();
                while (o != null) {
                    integers.add(o);
                    o = queue.poll();
                }
                System.out.println("线程:" + Thread.currentThread().getName() + " 总数:" + integers.size() + " 输出:" + integers);
            }, String.valueOf(i));
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
