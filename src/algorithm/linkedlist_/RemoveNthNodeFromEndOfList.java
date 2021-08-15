package algorithm.linkedlist_;

import datastructure.LinkedList_;

/**
 * 删除链表的倒数第 n 个节点
 * 例:
 * 输入:      1 -> 2 -> 3 -> 4 -> 5
 * 删倒数第二: 1 -> 2 -> 3 -> 5
 */
public class RemoveNthNodeFromEndOfList {
    //计算出位置再删除
    public LinkedList_.Node computingMethod(LinkedList_.Node head,int n){
        LinkedList_.Node node = head;
        LinkedList_.Node newHead = head;
        int count = 0;
        while (node.next!=null){
            count++;
            node = node.next;
        }
        if (n > count) {
            newHead = newHead.next;
            return newHead;
        }
        count = count - n;
        node = newHead;
        for (int i = 0; i < count; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return newHead;
    }
    //两个指针间隔n,后一个指针到达终点，前一个指针为所求
    public LinkedList_.Node intervalPointer(LinkedList_.Node head,int n){
        LinkedList_.Node fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null && head != null) return head.next;
        LinkedList_.Node slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public void test(){
        LinkedList_ l1 = new LinkedList_(1,2,3,4,5);
        l1.show("输入：");
        l1 = new LinkedList_(computingMethod(l1.getHead(), 2));
        l1.show("计算：");
        l1 = new LinkedList_(intervalPointer(l1.getHead(), 2));
        l1.show("间隔：");
    }
}
