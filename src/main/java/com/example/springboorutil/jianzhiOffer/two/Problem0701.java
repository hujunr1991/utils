package com.example.springboorutil.jianzhiOffer.two;

import java.util.LinkedList;
import java.util.Queue;

public class Problem0701<T> {

    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public int sSize() {
        return queue1.size()+queue2.size();
    }

    /**
     * 两个队列实现一个栈：
     * 原理是出栈的时候遍历到最后一个元素，将队列1的元素除最后一个全部压入队列2，往返利用
     * 思路：先将数据存到第一个队列里面，然后数据出队一直出队到地二个队列里面，
     * 直到第一个队列里面剩余一个数据，这个时候出队 即可达到先进后出的特性
     */

    //压栈
    public void push(T t) {
        //哪个队列不为空则往对应的里面压入数据
//        if (!queue1.isEmpty()) {
//             queue1.add(t);
//        }
//        if (!queue2.isEmpty()) {
//             queue2.add(t);
//        }
        queue1.add(t);


    }


    //出栈
    public T pop() {
//        if (!queue1.isEmpty() && queue2.isEmpty()) {
//            while (queue1.size() >1) {
//                queue2.add(queue1.poll());
//            }
//            return queue1.poll();
//        }
//        if (queue1.isEmpty() && !queue2.isEmpty()) {
//            while (queue2.size() >1) {
//                queue1.add(queue2.poll());
//            }
//            return queue2.poll();
//        }
//
//        return null;
        if (sSize() != 0) {
            if (!queue1.isEmpty()) {
                putN_1ToAnthor();
                return queue1.poll();
            } else {
                putN_1ToAnthor();
                return queue2.poll();
            }
        } else {
            System.out.println("栈已经为空啦，不能出栈");
            return null;
        }

    }

    /**
     * 我疑惑的是当出栈一次后，第二次在出栈的时候又要进行转移,此时程序还是进行了转移的
     * 在添加元素的时候也是接在后面的
     */
    private void putN_1ToAnthor() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
        }
    }

    public static void main(String[] args) {
        Problem0701<Integer> p = new Problem0701<>();
        p.push(1);
        p.push(2);
        p.push(3);
        Integer pop = p.pop();
        System.out.println(pop);
        p.push(4);
        p.push(5);
        Integer t = p.pop();
        System.out.println(t);
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
    }
}
