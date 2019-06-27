package com.example.springboorutil.DataStructures.BST;

public class BSTtest<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    private Node root;
    private int size;
    public BSTtest(){
        root = null;
        size = 0;
    }
    public int getSzie(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
//        if (root == null){
//            root = new Node(e);
//            size++;
//        } else {
//            addLoop(root, e);
//        }
        root = addniubi(root,e);
    }

    private void addLoop(Node node, E e) {
        //如果和下一元素相当则停止
        if (e.equals(node.e)) {
            return;
            //判断与其孩子的大小,小于判断左孩子，大于判断右孩子
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            addLoop(node.left, e);
        } else {
            addLoop(node.right, e);
        }
    }

    //优化成递归形式---
    public Node addniubi(Node node, E e) {
        if (node == null) {
            node = new Node(e);
            size++;
            return node;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = addniubi(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addniubi(node.right, e);
        }
        return node;
    }

    //查找
    public boolean contains(E e) {
        return containsLoop(root, e);
    }

    private boolean containsLoop(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) == 0 ) {
            return true;
        } else if (e.compareTo(root.e) < 0) {
            return containsLoop(root.left,e);
        } else {
            return containsLoop(root.right, e);
        }
    }

    public void preOrder() {
        preOrderLoop(root);
    }

    private void preOrderLoop(Node root) {
        if (root == null)
            return;
        System.out.println(root.e);
        preOrderLoop(root.left);
        preOrderLoop(root.right);
    }

    public void inOrder() {
        inOrderLoop(root);
    }

    private void inOrderLoop(Node root) {
        if (root == null)
            return;
        inOrderLoop(root.left);
        System.out.println(root.e);
        inOrderLoop(root.right);
    }

    public void postOrder() {
        postOrderLoop(root);
    }

    private void postOrderLoop(Node root) {
        if (root == null)
            return;
        postOrderLoop(root.left);
        postOrderLoop(root.right);
        System.out.println(root.e);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {

        BSTtest<Integer> bst = new BSTtest<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();

        System.out.println(bst);
    }
}
