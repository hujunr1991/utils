package com.example.springboorutil.base;

import org.springframework.beans.factory.BeanFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CopeTest {
    public static void main(String[] args) {
//        int[] a = new int[3];
//        a[0] = 0;
//        a[1] = 1;
//        a[2] = 2;
//        int[] b = Arrays.copyOf(a, 10);
//        System.out.println(Arrays.toString(b));
//        System.out.println("b.length is :"+b.length);


        int[] a = new int[10];
        a[0] = 5;
        a[1] = 6;
        a[2] = 7;
        a[3] = 8;
        /**
         * 从指定源数组中复制一个数组，复制从指定的位置开百始，到目标数组的指定位置结束
         * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
         * 代码解释:
         * 　　Object src : 原数组
         *    int srcPos : 从元数据的起始位置开始
         * 　　Object dest : 目标数组
         * 　　int destPos : 目标数组的开始起始位置
         * 　　int length  : 要copy的数组的长度
         */
        System.arraycopy(a, 1, a, 5, 4);
        System.out.println(Arrays.toString(a));
//        a[2]=99;
        System.out.println(Arrays.toString(a));

        int[] array = {1, 2, 3, 4, 5};
        int[] targetArr = new int[array.length];
        System.arraycopy(array,0,targetArr,0,array.length);
        System.out.println(Arrays.toString(targetArr));



    }
}
