package com.example.springboorutil.jianzhiOffer.two;


import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListlLinkedReverse {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node.next = node2;
        node2.next = node3;
        printListRever(node);
        System.out.println("=============");
        printList(node);

    }

    /**
     * 一种方法是利用栈来实现；借助栈结构来实现
     */

    private static void printListRever(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {

            System.out.println(stack.pop().val);
        }
    }

    /**
     * 递归写法
     */
    private static void printList(ListNode node) {

        if (node != null) {
            if (node.next != null) {
                printList(node.next);
            }
        }

        System.out.println(node.val);


    }

}


 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

