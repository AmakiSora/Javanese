package algorithm.tree_;

import datastructure.BinaryTree_;

/**
 * 求二叉树的最长路径
 */
public class DiameterOfBinaryTree {
    private int max = 0;
    public int getDiameter(BinaryTree_.Node node) {
        depth(node);
        return max;
    }
    private int depth(BinaryTree_.Node node) {
        if (node == null) return 0;
        int leftDepth = depth(node.leftNode);
        int rightDepth = depth(node.rightNode);
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    public void test(){
        BinaryTree_ tree = new BinaryTree_(1,2,3,4,5,6,7,8,9,0,0,0,0,0,0);
        tree.show();
        System.out.println("树的直径为："+ getDiameter(tree.root));
    }
}
