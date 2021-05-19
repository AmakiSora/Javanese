package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树
 */
public class BinaryTree_ {
    public Node root;
    public BinaryTree_(){
        this.root = new Node();
    }
    public BinaryTree_(Object o){
        this.root = new Node(o);
    }
    public static class Node{
        Object val;
        public Node leftNode;
        public Node rightNode;
        public Node(){
            this.val = null;
            this.leftNode = null;
            this.rightNode = null;
        }
        public Node(Object o){
            this.val = o;
            this.leftNode = null;
            this.rightNode = null;
        }
        public void addLeft(Object o){//在此节点,增添左子节点
            this.leftNode = new Node(o);
        }
        public void addRight(Object o){//在此节点,增添右子节点
            this.rightNode = new Node(o);
        }
//        public Node(Node node,Object o){
//            this.val = o;
//            this.leftNode = node;
//        }
//        public Node(Object o,Node node){
//            this.val = o;
//            this.rightNode = node;
//        }

    }
    public void setRootData(Object o){
        this.root.val = o;
    }
    public void addLeft(Object o,Node parent){//增添左子节点,指定节点
        parent.leftNode = new Node(o);
    }
    public void addRight(Object o,Node parent){//增添右子节点,指定节点
        parent.rightNode = new Node(o);
    }
    public void preorder(){ preorder(root); }
    public void preorder(Node node){//前序遍历(递归)
        if (node!=null) {
            System.out.print(node.val + " ");
            preorder(node.leftNode);
            preorder(node.rightNode);
        }
    }
    public void inorder(){ inorder(root); }
    public void inorder(Node node){//中序遍历(递归)
        if (node!=null) {
            inorder(node.leftNode);
            System.out.print(node.val + " ");
            inorder(node.rightNode);
        }
    }
    public void postorder(){ postorder(root); }
    public void postorder(Node node){//后序遍历(递归)
        if (node!=null) {
            postorder(node.leftNode);
            postorder(node.rightNode);
            System.out.print(node.val + " ");
        }
    }
    public void levelTraversal(){ levelTraversal(root); }
    public void levelTraversal(Node node){//层次遍历
        Queue<Node> qn = new LinkedList<>();
        qn.add(node);
        while (!qn.isEmpty()){
            Node n = qn.poll();
            if (n!=null){
                System.out.print(n.val + " ");
                qn.add(n.leftNode);
                qn.add(n.rightNode);
            }
        }
    }
    public void show(){ //展示树的形状
        if (root.val == null) System.out.println("树不存在");
        else show(root);
    }
    public void show(Node node){
        Queue<Object> qn = new LinkedList<>();
        qn.add(node);
        int i = 0;
        int n = 1;
        while (!qn.isEmpty()){
            Object o = qn.poll();
            if (i==(Math.pow(2,n)-1)){
                qn.add("换行");
                n++;
            }else i++;
            if (i==1) System.out.println();
            if (o=="换行") {
                System.out.println();
            } else if (o=="x") {
                System.out.print("x ");
                qn.add("y");
                qn.add("y");
            } else if (o=="y") {
                System.out.print("x ");
            }
            else {
                Node a = (Node) o;
                System.out.print(a.val + " ");
                if (a.leftNode == null) qn.add("x");
                else qn.add(a.leftNode);
                if (a.rightNode == null) qn.add("x");
                else qn.add(a.rightNode);
            }
        }
    }
    public void maxDepth(){
        int m = maxDepth(root);
        if (m == 0) System.out.println("树不存在！");
        else System.out.println("树的高度为:" + m);
    }
    public int maxDepth(Node root) {//树的层数(高度)
        if (root == null) return 0;
        return Math.max(maxDepth(root.leftNode), maxDepth(root.rightNode)) + 1;
    }
    public void createTestTree(){//创建出一个用于测试的树;
        root.val = 1;
        root.addLeft(2);
        root.addRight(3);
        root.leftNode.addLeft(4);
        root.leftNode.addRight(5);
        root.rightNode.addLeft(6);
        root.rightNode.addRight(7);
        root.leftNode.leftNode.addLeft(8);
        root.leftNode.leftNode.addRight(9);
        root.leftNode.rightNode.addLeft(0);
        root.leftNode.rightNode.addRight(1);
        root.rightNode.leftNode.addLeft(2);
        root.rightNode.leftNode.addRight(3);
        root.rightNode.rightNode.addLeft(4);
        root.rightNode.rightNode.addRight(5);
    }
    public void test(){
        createTestTree();
        System.out.print("前序遍历：");
        preorder();
        System.out.println();
        System.out.print("中序遍历：");
        inorder();
        System.out.println();
        System.out.print("后序遍历：");
        postorder();
        System.out.println();
        System.out.print("层次遍历：");
        levelTraversal();
        System.out.println();
        System.out.print("树图：");
        show();
        maxDepth();
    }

}
