package java_.queue_;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 优先队列
 * 优先级队列中,数据按关键词有序排列,插入新数据的时候,会自动插入到合适的位置保证队列有序
 * 底层的数据结构是二叉堆
 * 根节点总是大于左右子节点（大顶堆）,或者是小于左右子节点（小顶堆）
 */
public class PriorityQueue_ {
    public void test(){
        //数字排序
        Queue<Integer> intQueue = new PriorityQueue<>();
        int intSize = 20;
        for (int i = 0; i < intSize; i++) {
            intQueue.add(new Random().nextInt(intSize));
        }
        System.out.println(intQueue);

        //有序输出
        for (int i = 0; i < intSize; i++) {
            System.out.println(intQueue.poll());
        }

        //字母排序
        Queue<String> strQueue = new PriorityQueue<>(List.of("ba", "d", "w", "ab", "c", "v", "aa"));
        System.out.println(strQueue);
        int strSize = strQueue.size();

        //有序输出
        for (int i = 0; i < strSize; i++) {
            System.out.println(strQueue.poll());
        }
    }
}
