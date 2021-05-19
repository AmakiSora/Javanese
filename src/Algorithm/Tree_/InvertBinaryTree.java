package Algorithm.Tree_;

import DataStructure.BinaryTree_;

/**
 * 翻转二叉树
 */
public class InvertBinaryTree {
    public BinaryTree_.Node invert(BinaryTree_.Node node) {
        if (node == null) return null;
        BinaryTree_.Node left = node.leftNode;  // 后面的操作会改变 left 指针，因此先保存下来
        node.leftNode = invert(node.rightNode);
        node.rightNode = invert(left);
        return node;
    }
    public void test(){
        BinaryTree_ tree = new BinaryTree_();
        tree.createTestTree();
        System.out.print("翻转前:");
        tree.show();
        invert(tree.root);
        System.out.print("翻转后:");
        tree.show();
    }
}
