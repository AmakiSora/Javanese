package algorithm.tree_;

import datastructure.BinaryTree_;

/**
 * 判断二叉树是否对称
 */
public class IsSymmetricTree {
    public boolean isSymmetric(BinaryTree_.Node node) {
        if (node == null) return true;
        return isSymmetric(node.leftNode, node.rightNode);
    }
    private boolean isSymmetric(BinaryTree_.Node n1, BinaryTree_.Node n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        return isSymmetric(n1.leftNode, n2.rightNode) && isSymmetric(n1.rightNode, n2.leftNode);
    }
    public void test(){
        BinaryTree_ tree = new BinaryTree_(1,2,2,3,null,null,3);
        tree.show();
        if (isSymmetric(tree.root)) System.out.println("此树对称");
        else System.out.println("此树不对称");
    }
}
