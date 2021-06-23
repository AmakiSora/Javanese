package algorithm.tree_;

import datastructure.BinaryTree_;

/**
 * 判断是否为二叉搜索树
 */
public class IsValidBinarySearchTree {
    public boolean isValidBST(BinaryTree_.Node node) {
        if (node == null) return true;
        return isValidBST(node,0,100);
    }
    public boolean isValidBST(BinaryTree_.Node root,int min,int max) {
        if (root == null) return true;
        if ((int)root.val <= min || (int)root.val >= max)
            return false;
        return  isValidBST(root.leftNode,min,(int)root.val) &&
                isValidBST(root.rightNode,(int)root.val,max);
    }
    public void test(){
        BinaryTree_ tree = new BinaryTree_(5,4,6,null,null,3,7);
        tree.show();
        if (isValidBST(tree.root)) System.out.println("是二叉搜索树");
        else System.out.println("不是二叉搜索树");
    }
}
