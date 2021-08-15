package algorithm.linkedlist_;

import datastructure.LinkedList_;

/**
 * 逆序链表加法
 * 给你两个非空的链表,表示两个非负的整数,它们每位数字都是按照逆序的方式存储的,并且每个节点只能存储一位数字
 * 请你将两个数相加，并以相同形式返回一个表示和的链表
 * 你可以假设除了数字0之外，这两个数都不会以0开头
 * 例:
 * A:  2 -> 4 -> 3
 * B:  5 -> 6 -> 4
 * 相加:7 -> 0 -> 8
 * 即342 + 456 = 807
 */
public class ReverseLinkedListAddition {
    private LinkedList_.Node addition(LinkedList_.Node l1,LinkedList_.Node l2){
        LinkedList_.Node root = new LinkedList_.Node(0);
        LinkedList_.Node cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? (int) l1.str : 0;
            int l2Val = l2 != null ? (int) l2.str : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            LinkedList_.Node sumNode = new LinkedList_.Node(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return root.next;
    }
    public void test(){
        LinkedList_ l1 = new LinkedList_(4,3,2,1);
        LinkedList_ l2 = new LinkedList_(9,8,1,7);
        l1.show("l1: ");
        l2.show("l2: ");
        LinkedList_.Node addition = addition(l1.getHead(), l2.getHead());
        new LinkedList_(addition).show("结果:");
    }
}
