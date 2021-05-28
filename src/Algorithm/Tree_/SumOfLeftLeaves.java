package Algorithm.Tree_;

import DataStructure.BinaryTree_;

/**
 * 计算二叉树所有左叶子节点的和
 */
public class SumOfLeftLeaves {//节点的val属性必须为int
    public int sumOfLeftLeaves(BinaryTree_.Node root) {
        if (root == null) return 0;
        if (isLeaf(root.leftNode)) return (int)root.leftNode.val + sumOfLeftLeaves(root.rightNode);
        return sumOfLeftLeaves(root.leftNode) + sumOfLeftLeaves(root.rightNode);
    }
    private boolean isLeaf(BinaryTree_.Node node){//判断是否是左节点
        if (node == null) return false;
        return node.leftNode == null && node.rightNode == null;
    }
    public void test(){
        BinaryTree_ tree = new BinaryTree_(1,2,2,null,3,5,3,null,1,1);
        tree.show();
        System.out.println("左叶子节点的和:"+sumOfLeftLeaves(tree.root));
    }
}
