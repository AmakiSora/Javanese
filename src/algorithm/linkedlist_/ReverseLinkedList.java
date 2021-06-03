package algorithm.linkedlist_;

import datastructure.LinkedList_;

/**
 * 反转链表
 */
public class ReverseLinkedList {
    //递归法
    public LinkedList_.Node recursion(LinkedList_.Node head){
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList_.Node  next = head.next;
        LinkedList_.Node  newHead = recursion(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    //头插法
    public LinkedList_.Node headInsertion(LinkedList_.Node head) {
        LinkedList_.Node newHead = new LinkedList_.Node("-1");
        while (head != null) {
            LinkedList_.Node next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
    public void test(){//测试
        LinkedList_ l1 = new LinkedList_(1,2,3,4,5);
        System.out.println("----------------------------------------");
        l1.show();
        System.out.println("递归反转");
        LinkedList_.Node reNode1 = recursion(l1.getHead());
        LinkedList_ l2 = new LinkedList_(reNode1);
        l2.show();
        System.out.println("----------------------------------------");
        LinkedList_ l3 = new LinkedList_(1,2,3,4,5);
        l3.show();
        System.out.println("头插法");
        LinkedList_.Node reNode2 = headInsertion(l3.getHead());
        LinkedList_ l4 = new LinkedList_(reNode2);
        l4.show();
        System.out.println("----------------------------------------");

    }
}
