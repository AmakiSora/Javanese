package algorithm.linkedlist_;

import datastructure.LinkedList_;

/**
 * 判断是否为环形链表
 * 快慢指针:如果链表有环,快的指针最终会和慢的指针相遇
 * 当快慢指针相遇时,让一个新的指针从头开始走,速度与慢指针(只能加一的慢指针)相遇时,即为链表开始循环的节点
 */
public class IsLoopLinkedList {
    private LinkedList_.Node hasCycle(LinkedList_.Node head) {
        LinkedList_.Node slow = head;
        LinkedList_.Node fast = head;
        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                LinkedList_.Node q = head;
                LinkedList_.Node p = slow;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return q;
            }
        }
        return null;
    }
    public void test() {
        LinkedList_ l = new LinkedList_(1, 2, 3, 4, 5, 6, 7);
//        l.setNode(l.getNode(3),6);//形成环(这种方式不行,因为我的实现里有更新链表长度,会造成死循环)
        LinkedList_.Node node = l.getNode(5);
        node.next = l.getNode(2);
//        l.show();//验证
        LinkedList_.Node cycleNode = hasCycle(l.getHead());
        if (cycleNode!=null){
            System.out.println("链表有环,环的入口点为"+cycleNode.str.toString());
        }else {
            System.out.println("链表无环");
        }


    }
}
