package com.example.springboorutil.jianzhiOffer.two.execise50;

import java.util.Scanner;

public class Programme6 {

    /**
     * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
     *
     * 程序分析：利用辗除法。
     *
     *  *这里有一个知识点要记住的，最大公约数和最小公倍数的求法
     *
     *  *1、先求最大公约数bigDivisor
     *
     *  *2、就可以很方便获得最小公倍数multiple=input1*input2/bigDIvisor
     *
     *  *这里最重要的就是求最大公约数：求法如下
     *
     *  *(1)用大的数对小的数求余
     *
     *  *(2)把小的数赋值给大的数，把求余获得的结果赋值给小的数，
     *
     *  *(3)循环上一步的操作，直到求余的结果为零
     *
     *  *(4)上一步被求余的数就是我们要的最大公约数，不信的话，你可以动手试试
     */

    public static void main(String[] args) {
        int bigDivisor=0;//定义最大公约数

        int multiple=0;//定义最小公倍数

        System.out.println("请输入两个整数：");

        Scanner scanner = new Scanner(System.in);

        int input1 = scanner.nextInt();//获取第一个数

        int input2 = scanner.nextInt();//获取第二个数

        multiple=input1*input2;//这个值保存，求公约数后，方便求得最小公倍数

        int temp =1;// 交换用的中间数



        if (input2 >input1) {//确保第一个数不小于第二个数

            temp=input1;

            input1=input2;

            input2=temp;

        }

        while (temp != 0) {
            temp=input1%input2;//求余结果

            input1=input2;//大的数已经没用了，用小的数替代

            input2=temp;//把求余的结果赋值给小的数

        }

        bigDivisor=input1;//最后一次求余结果为零时，被求余的数

        multiple=multiple/bigDivisor;

        System.out.println("最大公约数是："+bigDivisor );

        System.out.println("最小公倍数是："+multiple);

        scanner.close();
    }
}
