package algorithm.linkedlist_;

import datastructure.LinkedList_;

/**
 * 判断是否为环形链表
 * 快慢指针:如果链表有环,快的指针最终会和慢的指针相遇
 */
public class IsLoopLinkedList {
    private boolean hasCycle(LinkedList_.Node head) {
        LinkedList_.Node slow = head;
        LinkedList_.Node fast = head;
        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    public void test() {
        LinkedList_ l = new LinkedList_(1, 2, 3, 4, 5, 6, 7);
//        l.setNode(l.getNode(3),6);//形成环(这种方式不行,因为我的实现里有更新链表长度,会造成死循环)
        LinkedList_.Node node = l.getNode(5);
        node.next = l.getNode(2);
//        l.show();//验证
        System.out.println(hasCycle(l.getHead()));


    }
}
