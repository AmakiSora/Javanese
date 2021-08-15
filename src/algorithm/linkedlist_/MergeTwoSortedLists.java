package algorithm.linkedlist_;

import datastructure.LinkedList_;

/**
 * 合并两个有序链表
 * 例:
 * A:    1 → 2 → 4
 * B:    1 → 3 → 4
 * 合并:  1 → 1 → 2 → 3 → 4 → 4
 */
public class MergeTwoSortedLists {
    //归并法
    public LinkedList_.Node mergingMethod(LinkedList_.Node n1,LinkedList_.Node n2){
        LinkedList_.Node head = new LinkedList_.Node(-1);
        LinkedList_.Node node = head;
        while (n1 != null && n2 != null){
            if ((int) n1.str <= (int) n2.str){
                node.next = n1;
                n1 = n1.next;
            }else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }
        if (n1 == null) node.next = n2;
        if (n2 == null) node.next = n1;
        return head.next;
    }
    //递归法
    public LinkedList_.Node recursion(LinkedList_.Node n1,LinkedList_.Node n2){
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        if ((int) n1.str < (int) n2.str){
            n1.next = recursion(n1.next, n2);
            return n1;
        } else {
            n2.next = recursion(n1, n2.next);
            return n2;
        }
    }
    public void test(){
        LinkedList_ l1 = new LinkedList_(1,2,4);
        l1.show("输入l1: ");
        LinkedList_ l2 = new LinkedList_(1,3,4);
        l2.show("输入l2: ");
        LinkedList_ l3 = new LinkedList_(mergingMethod(l1.getHead(), l2.getHead()));
        l3.show("归并法: ");
        //执行后会破坏两个链表,需重新生成
        l1 = new LinkedList_(1,2,4);
        l2 = new LinkedList_(1,3,4);
        LinkedList_ l4 = new LinkedList_(recursion(l1.getHead(),l2.getHead()));
        l4.show("递归法: ");
    }
}