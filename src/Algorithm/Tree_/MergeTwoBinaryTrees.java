package Algorithm.Tree_;

import DataStructure.BinaryTree_;

/**
 * 合并两颗二叉树
 */
public class MergeTwoBinaryTrees {
    public BinaryTree_.Node merge(BinaryTree_.Node t1, BinaryTree_.Node t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        // 先合并根节点
        if (t1.val.getClass().toString().equals("class java.lang.Integer") &&
                t2.val.getClass().toString().equals("class java.lang.Integer")) {
            t1.val = (int) t1.val + (int) t2.val;
        }else if (t1.val.getClass().toString().equals("class java.lang.String") &&
                t2.val.getClass().toString().equals("class java.lang.String")){
            t1.val = t1.val + (String) t2.val;
        }
        // 再递归合并左右子树
        t1.leftNode = merge(t1.leftNode, t2.leftNode);
        t1.rightNode = merge(t1.rightNode, t2.rightNode);
        return t1;
    }
    public void test(){
        BinaryTree_ tree1 = new BinaryTree_("1","2","2",3,3,null,3);
        System.out.print("合并前:");
        tree1.show();
        BinaryTree_ tree2 = new BinaryTree_("1","2","2",3,3,3,3);
        tree2.show();
        BinaryTree_ tree3 = new BinaryTree_();
        tree3.root = merge(tree1.root,tree2.root);
        System.out.print("合并后:");
        tree3.show();
    }
}
