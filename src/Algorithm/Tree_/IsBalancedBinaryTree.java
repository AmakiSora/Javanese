package Algorithm.Tree_;

import DataStructure.BinaryTree_;

/**
 * 判断是否为平衡二叉树
 * 平衡树左右子树高度差都小于等于 1
 */
public class IsBalancedBinaryTree {
    private boolean result = true;
    public boolean isBalanced(BinaryTree_.Node root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(BinaryTree_.Node node) {
        if (node == null) return 0;
        int l = maxDepth(node.leftNode);
        int r = maxDepth(node.rightNode);
        if (Math.abs(l - r) > 1) result = false;
        return 1 + Math.max(l, r);
    }
    public void test(){
        BinaryTree_ tree = new BinaryTree_();
        tree.createTestTree();
        tree.show();
        if (isBalanced(tree.root)) System.out.println("是平衡二叉树");
        else System.out.println("此树不平");
    }
}
