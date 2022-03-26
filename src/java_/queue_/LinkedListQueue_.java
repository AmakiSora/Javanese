package java_.queue_;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 链表队列
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

    }
}
