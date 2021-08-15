package algorithm.linkedlist_;

import datastructure.LinkedList_;

/**
 * 从有序链表中删除重复节点
 * 例:
 * 输入: 1 -> 1 -> 1 -> 2 -> 2 -> 3 -> 4 -> 5 -> 5
 * 输出: 1 -> 2 -> 3 -> 4 -> 5
 */
public class RemoveDuplicatesFromSortedList {
    //循环法
    public LinkedList_.Node circulation(LinkedList_.Node head){
        LinkedList_.Node newHead = head;
        while(head != null && head.next != null){
            if(head.str == head.next.str)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return newHead;

    }
    //递归法
    public LinkedList_.Node recursion(LinkedList_.Node head){
        if(head == null || head.next == null)
            return head;
        head.next = recursion(head.next);
        if (head.next.str == head.str)
            return head.next;
        else
            return head;
    }
    public void test(){
        LinkedList_ l1 = new LinkedList_(1,1,1,2,2,3,4,5,5);
        l1.show("输入： ");
        LinkedList_ l2 = new LinkedList_(circulation(l1.getHead()));
        l2.show("循环： ");
        l1 = new LinkedList_(1,1,1,2,2,3,4,5,5);
        l2 = new LinkedList_(recursion(l1.getHead()));
        l2.show("递归： ");

    }
}
