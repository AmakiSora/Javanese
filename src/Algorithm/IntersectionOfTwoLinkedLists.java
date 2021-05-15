package Algorithm;

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
        LinkedList_ l1 = new LinkedList_();
        LinkedList_ l2 = new LinkedList_();
        l1.addLast("a1");
        l1.addLast("a2");
        l1.addLast("c1");
        l1.addLast("c2");
        l1.addLast("c3");
//        l1.show();
        l2.addLast("b1");
        l2.addLast("b2");
        l2.addLast("b3");
        l2.setNode(l1.getNode(2),2);
//        l2.show();
        System.out.println(getIntersectionNode(l1.getHead(), l2.getHead()));
        System.out.println(getIntersectionNode(l1.getHead(), l2.getHead()).str);//不存在交点会报错
    }
}
