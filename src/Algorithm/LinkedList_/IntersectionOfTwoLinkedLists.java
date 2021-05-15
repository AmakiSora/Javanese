package Algorithm.LinkedList_;

import DataStructure.LinkedList_;

/**
 * 找出两个链表的交点
 */
public class IntersectionOfTwoLinkedLists {
    public LinkedList_.Node getIntersectionNode(LinkedList_.Node headA,LinkedList_.Node headB) {//获取链表的交点
        LinkedList_.Node l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
    public void test(){
        LinkedList_ l1 = new LinkedList_("a1","a2","c1","c2","c3");
        LinkedList_ l2 = new LinkedList_("b1","b2","b3");
        l2.setNode(l1.getNode(2),2);
        System.out.print("l1为：");
        l1.show();
        System.out.print("l2为：");
        l2.show();
        if (getIntersectionNode(l1.getHead(), l2.getHead()) != null){
            System.out.println("交点为："+getIntersectionNode(l1.getHead(), l2.getHead()).str);//不存在交点会报错
        }else {
            System.out.println("无交点");
        }
    }
}
