package java_.queue_;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞式数组队列
 * 有界队列,有界也就意味着,它不能够存储无限多数量的对象,所以在创建时,必须要给它指定一个队列的大小
 */
public class ArrayBlockingQueue_ {
    public void test() throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        generateElements(queue);
        consumerElements(queue);
        System.out.println("----------------");
        queue.clear();
    }

    //生成元素
    private void generateElements(BlockingQueue<Integer> queue) {
        new Thread(() -> {
            try {
                //慢速生成
                System.out.println("生成元素线程:开始慢速生成!");
                for (int i = 0; i < 10; i++) {
                    System.out.println("生成元素线程:开始生成!");
                    //put方法,如果队列不满则放入队列中
                    queue.put(new Random().nextInt(100));
                    System.out.println("生成元素线程:生成完毕!");
                    System.out.println("生成元素线程:休眠!");
                    Thread.sleep(5000);
                }
                //快速生成
                System.out.println("生成元素线程:开始快速生成!");
                for (int i = 0; i < 20; i++) {
                    System.out.println("生成元素线程:开始生成!");
                    System.out.println("生成元素线程:阻塞啦~!");
                    //put方法,如果队列已满,则阻塞,直到队列有空位
                    queue.put(new Random().nextInt(100));
                    System.out.println("生成元素线程:生成完毕!");
                    System.out.println("生成元素线程:休眠!");
                }
                System.out.println("已经结束啦!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void consumerElements(BlockingQueue<Integer> queue) throws InterruptedException {
        //快速消费
        System.out.println("获取元素线程:开始快速消费!");
        for (int i = 0; i < 10; i++) {
            System.out.println("获取元素线程:开始取得元素!");
            System.out.println("获取元素线程:阻塞啦~!");
            //take方法,如果队列里没有元素,则阻塞,直到有元素可以获取
            Integer take = queue.take();
            System.out.println("获取元素线程:取得元素 " + take);
        }
        //慢速消费
        System.out.println("获取元素线程:开始慢速消费!");
        for (int i = 0; i < 10; i++) {
            System.out.println("获取元素线程:开始取得元素!");
            //take方法,如果队列里有元素,则取出
            Integer take = queue.take();
            System.out.println("获取元素线程:取得元素 " + take);
            Thread.sleep(5000);
        }
    }
}
