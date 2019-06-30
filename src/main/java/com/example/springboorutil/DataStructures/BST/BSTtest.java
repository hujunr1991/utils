package com.example.springboorutil.DataStructures.BST;

import java.util.*;

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

    //非递归的前序遍历--借助栈的结构：先压入右孩子，在压入左孩子
    Stack<Node> stack = new Stack<>();
    public void preOrderNR() {
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            System.out.println(node);
            if (null != node.right)
                stack.push(node.right);
            if (null != node.left)
                stack.push(node.left);
        }
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

//    //非递归的中序遍历----逻辑与前序一致
//    public void inOrderNR(){
//        if (root.right != null) {
//            stack.push(root.right);
//        }
//        stack.push(root);
//        if (root.left != null) {
//            stack.push(root.left);
//        }
//        while (!stack.empty()) {
//            Node node = stack.pop();
//            System.out.println(node);
//            if (null != node.right)
//                stack.push(node.right);
//            if (null != node.left)
//                stack.push(node.left);
//        }
//    }

    //层序遍历--借助队列实现
    public void levelOrder(){
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node node = q.remove();
            System.out.println(node.e);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
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

    //查找最小值
    public E findMin(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        Node node = findMinLoop(root);
        return node.e;
    }

    private Node findMinLoop(Node root) {
        if (root.left == null) {
            return root;
        }
      return findMinLoop(root.left);
    }

    //查找最大值
    public E findMax(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        Node node = findMaxLoop(root);
        return node.e;
    }

    private Node findMaxLoop(Node root) {
        if (root.right == null) {
            return root;
        }
        return findMaxLoop(root.right);
    }

    //删除最小值-- 注意不要删除最小值的右孩子
    public E removeMin(){
        E e = findMin();
        root = removeMinLoop(root);
        return e;
    }

    // 删除掉以node为根的二分搜索树中的最小节点

    private Node removeMinLoop(Node node) {
        if (node.left == null) {
            //右子树不能删，返回
            Node reghtNode = node.right;
            node.right = null;
            size--;
            return reghtNode;
        }
        // 返回删除节点后新的二分搜索树的根
        node.left = removeMinLoop(node.left);
        return node;
    }

    //删除最大值
    public E removeMax(){
        E e = findMax();
        root = removeMaxLoop(root);
        return e;
    }

    private Node removeMaxLoop(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMinLoop(node.right);
        return node;
    }

    //删除任意的元素
    public void remove(E e){
        root = removeLoop(root, e);
    }

    private Node removeLoop(Node node, E e) {

        if( node == null )
            return null;
        if (e.compareTo(node.e) < 0) {
            node.left = removeLoop(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0 ) {
            node.right = removeLoop(node.right, e);
            return node;
        } else {
            // 待删除节点左子树为空的情况，与删除最小值一样
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            //如果代替的这个节点右子树的最小节点为空，则代替的就是改右子树
            Node successor = findMinLoop(node.right);
            successor.right = removeMinLoop(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;

        }
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
//        bst.preOrder();
//        System.out.println();
//        System.out.println(bst);
//        bst.preOrderNR();
//        System.out.println(bst);

//        bst.levelOrder();

//        BST<Integer> bst = new BST<>();
//        Random random = new Random();
//        int n = 1000;
//        // test removeMin
//        for(int i = 0 ; i < n ; i ++)
//            bst.add(random.nextInt(10000));

        ArrayList<Integer> numsTest = new ArrayList<>();
        while(!bst.isEmpty())
            numsTest.add(bst.removeMin());

        System.out.println(numsTest);
        for(int i = 1 ; i < numsTest.size() ; i ++)
            if(numsTest.get(i - 1) >= numsTest.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMin test completed.");


        // test removeMax
//        for(int i = 0 ; i < n ; i ++)
//            bst.add(random.nextInt(10000));
//
//        nums = new ArrayList<>();
//        while(!bst.isEmpty())
//            nums.add(bst.removeMax());
//
//        System.out.println(nums);
//        for(int i = 1 ; i < nums.size() ; i ++)
//            if(nums.get(i - 1) < nums.get(i))
//                throw new IllegalArgumentException("Error!");
//        System.out.println("removeMax test completed.");
    }

}
