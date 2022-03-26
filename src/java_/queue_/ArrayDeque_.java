package java_.queue_;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 双端队列
 * 底层通过循环数组实现 俩个重要属性 head tail
 * 不能添加null值，不然会报空指针
 * 每次扩容都是2的n次方
 * 可以实现普通队列先进先出排序，也可以实现栈先进后出的排序
 * 特别留意，它里面通过二进制方式判断数组是否已满
 * (tail = (tail + 1) & (elements.length - 1)) == head
 */
public class ArrayDeque_ {
    public void test() {
        Deque<String> deque = new ArrayDeque<>(List.of("1", "2", "3", "4", "5", "6", "7"));

        //push 等效于addFirst
        deque.push("A");

        //addFirst 在头部加入
        deque.addFirst("B");
        System.out.println(deque);

        //addLast 在尾部加入
        deque.addLast("C");
        System.out.println(deque);

        //pop 删除并返回此双端队列的第一个元素,等效于removeFirst
        String pop = deque.pop();
        System.out.println(pop);
        System.out.println(deque);

        //removeFirst 删除并返回此双端队列的第一个元素
        String removeFirst = deque.removeFirst();
        System.out.println(removeFirst);
        System.out.println(deque);

        //removeFirst 删除并返回此双端队列的第一个元素
        String removeLast = deque.removeLast();
        System.out.println(removeLast);
        System.out.println(deque);

        //poll 等效于pollFirst
        String poll = deque.poll();
        System.out.println(poll);
        System.out.println(deque);

        //pollFirst 检索并删除此双端队列表示的队列的头部,如果此双端队列为空,则返回null
        String pollFirst = deque.pollFirst();
        System.out.println(pollFirst);
        System.out.println(deque);

        //pollLast 检索并删除此双端队列表示的队列的尾部,如果此双端队列为空,则返回null
        String pollLast = deque.pollLast();
        System.out.println(pollLast);
        System.out.println(deque);

        //getFirst 检索头部,但不删除(无则抛异常)
        String first = deque.getFirst();
        System.out.println(first);
        System.out.println(deque);

        //getLast 检索尾部,但不删除(无则抛异常)
        String last = deque.getLast();
        System.out.println(last);
        System.out.println(deque);

        //peekFirst 检索头部,但不删除(无则返回null)
        String peekFirst = deque.peekFirst();
        System.out.println(peekFirst);
        System.out.println(deque);

        //peekLast 检索尾部,但不删除(无则返回null)
        String peekLast = deque.peekLast();
        System.out.println(peekLast);
        System.out.println(deque);

        //removeFirstOccurrence 从此双端队列中删除第一次出现的指定元素
        //如果双端队列不包含该元素,则它保持不变,
        //如果此双端队列包含指定元素,则返回 true。
        boolean removeFirstOccurrence = deque.removeFirstOccurrence("4");
        System.out.println(removeFirstOccurrence);
        System.out.println(deque);

        //removeLastOccurrence 从此双端队列中删除最后一次出现的指定元素
        //如果双端队列不包含该元素,则它保持不变
        // 如果此双端队列包含指定元素,则返回 true。
        boolean removeLastOccurrence = deque.removeLastOccurrence("5");
        System.out.println(removeLastOccurrence);
        System.out.println(deque);

    }


}
