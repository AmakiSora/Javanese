package Algorithm;

import DataStructure.LinkedList_;

/**
 * 反转链表
 */
public class ReverseLinkedList {
    public LinkedList_.Node recursion(LinkedList_.Node head){//递归法
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList_.Node  next = head.next;
        LinkedList_.Node  newHead = recursion(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    public LinkedList_.Node headInsertion(LinkedList_.Node head) {//头插法
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
        LinkedList_ l1 = new LinkedList_();
        l1.addLast("1");
        l1.addLast("2");
        l1.addLast("3");
        l1.addLast("4");
        l1.addLast("5");
        l1.show();
        System.out.println("递归反转");
        LinkedList_.Node reNode1 = recursion(l1.head);
        System.out.println(reNode1.str);
        while (reNode1.next!=null){
            System.out.println(reNode1.next.str);
            reNode1 = reNode1.next;
        }
        System.out.println("递归完成");
        System.out.println("----------------------------------------");
        LinkedList_ l2 = new LinkedList_();
        l2.addLast("1");
        l2.addLast("2");
        l2.addLast("3");
        l2.addLast("4");
        l2.addLast("5");
        l2.show();
        System.out.println("头插法");
        LinkedList_.Node reNode2 = headInsertion(l2.head);
        System.out.println(reNode2.str);
        while (reNode2.next!=null){
            System.out.println(reNode2.next.str);
            reNode2 = reNode2.next;
        }
        System.out.println("头插完成");

    }
}
