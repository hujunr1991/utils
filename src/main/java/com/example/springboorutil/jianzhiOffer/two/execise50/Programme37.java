package com.example.springboorutil.jianzhiOffer.two.execise50;

import java.util.LinkedList;
import java.util.Scanner;

public class Programme37 {

    /**
     * 题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
     *
     * 关键问题是怎么移除》？:布尔值确定，如果被选中被赋值为false
     *
     *      * 从第一个人开始判断，如果他在圈内，那么报数，再判断他报的数是否是3，如果是的话移出圈外
     *
     *      * 接着判断下一个人，是否到了最末，如果是的话，从零开始
     *
     *      * 不断循环，直到最后剩下1个人
     */

    public static void main(String[] args) {
        System.out.print("请输入一个整数：");

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        scan.close();
        //利用链表，报数为3的移除，没有的添加到链表尾部，同时在去掉原来的
        int last = game(n ,3);
        System.out.println("最后留下来的是:" + last);
        System.out.println(game2(n , 3));
    }

    private static int game(int n, int rule) {
        LinkedList<Integer> player=new LinkedList<Integer>();
        for(int i=1;i<=n;i++) {
            player.add(i);
        }
        while (player.size() > 1) {
//            player.addLast(player.removeFirst());
//            player.addLast(player.removeFirst());
//            player.removeFirst();
            int count = 1;
            while (count < rule) {
                player.addLast(player.removeFirst());
                count++;
            }
            player.removeFirst();
        }
        return player.getFirst();
    }

    private static int game2(int n, int rule) {
        //定义数组变量标识某人是否还在圈内
        boolean[] isIn = new boolean[n];
        int inCount = n;//定义圈内人数

        int countNum = 0;//定义报数

        int index = 0;//定义索引

        while (inCount >1 ) {
            //判断下一个人是否在圈内
            if(!isIn[index]) {
                //在的话报数
                countNum++;
                //如果这个数等于3
                if (countNum == rule) {
                    //把他定义为出圈
                    isIn[index] = true;
                    //报数清零，下一个好从1开始
                    countNum = 0;
                    //圈内人数减一
                    inCount--;
                }
            }
            //下一人的位置索引值
            index++;
            if(index==n){//当索引到最后之后再从头开始
                index = 0;
            }
        }
        for(int i=0;i<n;i++){
            if(!isIn[i]){//最后只有一个符合条件的
              return i+1;
            }
        }
        return -1;
    }
}
