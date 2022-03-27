package java_.queue_;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 链表队列
 * 没有实现的阻塞接口
 * 不是线程安全的
 */
public class LinkedListQueue_ {
    public void test(){
        Queue<String> queue = new LinkedList<>();
        //add 添加元素(失败会抛出异常)
        queue.add("a");
        System.out.println(queue);

        //offer 添加元素(就是调用add)
        queue.offer("b");
        System.out.println(queue);

        //remove 取出元素(失败会抛出异常)
        String r = queue.remove();
        System.out.println(r);
        System.out.println(queue);

        //poll 取出元素
        String p = queue.poll();
        System.out.println(p);
        System.out.println(queue);

        //poll 队列中没有元素时返回null
        String pp = queue.poll();
        System.out.println(pp);
        System.out.println(queue);

        //addAll 将集合元素加入到队列
        List<String> list = List.of("1", "2", "3");
        queue.addAll(list);
        System.out.println(queue);

        //element 检索但不删除此队列的头部,如果此队列为空,则抛出异常
        String element = queue.element();
        System.out.println(element);
        System.out.println(queue);

        //peek 检索但不删除此队列的头部,如果此队列为空,则返回null
        String peek = queue.peek();
        System.out.println(peek);
        System.out.println(queue);

        //clear 清空队列
        queue.clear();
        System.out.println(queue);
    }
}
