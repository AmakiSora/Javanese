package java_.queue_;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * 链式传递队列
 * LinkedTransferQueue是SynchronousQueue和LinkedBlockingQueue的合体
 * 性能比LinkedBlockingQueue更高(没有锁操作),比SynchronousQueue能存储更多的元素
 * 可以阻塞,也可以不阻塞
 */
public class LinkedTransferQueue_ {
    public void test() throws InterruptedException {
        TransferQueue<Integer> queue = new LinkedTransferQueue<>();
        feature(queue);
        //判断有无等待消费线程
        System.out.println(queue.hasWaitingConsumer());
        //获取等待线程数
        System.out.println(queue.getWaitingConsumerCount());
    }

    private void feature(TransferQueue<Integer> queue) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(2000);
                    //tryTransfer如果可能,立即将元素传输给等待的消费者
                    //更准确地说,如果存在消费者已经在等待接收它(在take或定时poll)
                    //则立即传输指定的元素,否则返回false而不使元素入队。
                    boolean b = queue.tryTransfer(1);
                    //transfer将元素传输给消费者,并在必要时等待
                    //更准确地说,如果存在已经等待接收的消费者(在take或定时poll)
                    //则立即传输指定的元素，否则等待直到消费者接收到该元素
                    //queue.transfer(1);
                    if (b) {
                        System.out.println("传递元素成功！");
                    } else {
                        System.out.println("传递元素失败,不加入队列！");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("---------------------");
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                    System.out.println("获取到元素：" + queue.poll(1, TimeUnit.SECONDS));
                    System.out.println("队列内元素：" + queue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("---------------------");
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
