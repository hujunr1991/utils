package com.example.springboorutil.jianzhiOffer.two.execise50;

import java.util.Scanner;

public class Programme43 {
    /**
     * 题目：求0—7所能组成的奇数个数。
     *
     * *程序分析：最少也是1位数，最多能组成8位的数字
     *
     *  *       第一位不能为零，最后一位不能是偶数
     *
     *  *       0到7有四个奇数
     *
     *  *       这里用累加求和
     */

    public static void main(String[] args) {
        System.out.println("请输入2-9的数:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = n/2;

        for (int i=2; i<n; i++) {
            sum = sum + (n-1)*Math.pow(n, i-1)/2;
        }

        System.out.println("0到7能组成的奇数个数："+sum);
    }
}
