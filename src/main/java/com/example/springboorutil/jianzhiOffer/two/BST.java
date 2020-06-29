package com.example.springboorutil.jianzhiOffer.two;

import com.example.springboorutil.DataStructures.StacksAndQueues.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>>  {

    private class Node {
        private E e;
        private Node left, right;
        private Node( E  e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void add(E e) {
        root = add(root, e);
    }

    //添加元素
    private Node add(Node root, E e ) {
        if (root == null) {
            size++;
            return new Node(e);
        }

        if (root.e.compareTo(e) < 0) {
            root.right = add(root.right, e);
        } else if (root.e.compareTo(e) > 0) {
            root.left = add(root.left, e);
        }

        return root;


    }

    private Boolean contain(E e) {
        return containValue(root ,e);
    }

    private Boolean containValue(Node root, E e) {
        if (root == null) {
            return false;
        }

        if (e.compareTo(root.e) == 0) {
            return true;
        } else if (e.compareTo(root.e) < 0) {
            return containValue(root.left, e);
        } else {
            return containValue(root.right, e);
        }

    }

    private void preOrder() {
        preOrderValue(root);
    }

    private void preOrderValue(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrderValue(root.left);
        preOrderValue(root.right);
    }

    private void inOrder() {
        inOrderValue(root);
    }

    private void inOrderValue(Node root) {
        if (root == null) {
            return;
        }
        inOrderValue(root.left);
        System.out.println(root.e);
        inOrderValue(root.right);
    }

    private void postOrder() {
        postOrderValue(root);
    }

    private void postOrderValue(Node root) {
        if (root == null) {
            return;
        }
        postOrderValue(root.left);
        postOrderValue(root.right);
        System.out.println(root.e);
    }

    /*=========以上为递归形式=================*/

     // 二分搜索树的非递归前序遍历---Java实现二叉树的四种遍历
    /*https://www.cnblogs.com/gxclmx/p/7485384.html
23     * 前序遍历，非递归实现
24     * 1，先入栈根节点，输出根节点val值，再先后入栈其右节点、左结点；
25     * 2，出栈左节点，输出其val值，再入栈该左节点的右节点、左节点；直到遍历完该左节点所在子树。
26     * 3，再出栈右节点，输出其val值，再入栈该右节点的右节点、左节点；直到遍历完该右节点所在子树。
27     * */
    private void preOrderNR() {
        if (root == null) {
            return;
        }

        java.util.Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                 stack.push(cur.right);
            }

            if (cur.left != null) {
                 stack.push(cur.left);
            }
        }
    }

    // 二分搜索树的层序遍历
    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);

        }

    }


    /*
   54    * 中序遍历，非递归实现
   55    * 1，首先从根节点出发一路向左，入栈所有的左节点；
   56    * 2，出栈一个节点，输出该节点val值，查询该节点是否存在右节点，
   57    * 若存在则从该右节点出发一路向左入栈该右节点所在子树所有的左节点；
   58    * 3，若不存在右节点，则出栈下一个节点，输出节点val值，同步骤2操作；
   59    * 4，直到节点为null，且栈为空。
   60    * */
    private void inOrderNR() {
        if(root == null)
            return;

        java.util.Stack<Node> stack = new java.util.Stack<>();
        while (root != null || !stack.isEmpty()) {
            //首先从根节点出发一路向左，入栈所有的左节点；
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //此时到最小的左节点的时候，右子树为空，所以root也为空，直接进入搞方法，就到了上一个节点，依次类推
            if (!stack.isEmpty()) {
                Node pop = stack.pop();
                System.out.println(pop.e);
                root = pop.right;
            }
        }
    }


    /**
     * 后序遍历，非递归实现 https://blog.csdn.net/weixin_42130471/article/details/82904161
     * 双栈法,stack2存储最后输出的顺序
     *
     */
    private void postOrderNR() {

        if (root != null) {
            java.util.Stack<Node> stack = new java.util.Stack<>();
            java.util.Stack<Node> stack2 = new java.util.Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node pop = stack.pop();
                stack2.push(pop);

                if (pop.left != null) {
                    stack.push(pop.left);
                }
                if (pop.right != null) {
                    stack.push(pop.right);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().e);
            }

        }


    }

    private void postOrderNR2() {
        if (root == null)
            return;
        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node cur = root;
        //创建一个prev记录已经访问过的节点
        Node pre = null;
        while (true) {
            //首先从根节点出发一路向左，入栈所有的左节点；
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //?
            if (stack.empty()) {
                break;
            }
            //获取栈顶元素
            Node top = stack.peek();
            if (top.right == null || top.right == pre) {
                System.out.println(top.e);
                stack.pop();
                pre = top;
            } else {
                cur = cur.right;
            }
        }

    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {10, 6, 14, 4, 8, 12, 16};
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
//
//        bst.preOrderNR();
//        System.out.println();

//        bst.inOrder();
//        System.out.println();
//
//        bst.inOrderNR();
//        System.out.println();
        bst.postOrder();
        System.out.println();
        bst.postOrderNR();
        System.out.println();
        bst.postOrderNR2();
    }


}
