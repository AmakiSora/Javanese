package Algorithm.LinkedList_;

import DataStructure.LinkedList_;

/**
 * 删除链表的倒数第 n 个节点
 */
public class RemoveNthNodeFromEndofList {
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
        if (fast == null) return head.next;
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
        System.out.print("输入：");
        l1.show();
        l1 = new LinkedList_(computingMethod(l1.getHead(), 2));
        System.out.print("计算：");
        l1.show();
        l1 = new LinkedList_(intervalPointer(l1.getHead(), 2));
        System.out.print("间隔：");
        l1.show();
    }
}
