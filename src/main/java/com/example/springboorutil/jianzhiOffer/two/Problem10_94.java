package com.example.springboorutil.jianzhiOffer.two;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Problem10_94 {
    //10进制与27进制的转换

    public static void main(String[] args) {


//        System.out.println("请输入字符：");
//        Scanner scanner = new Scanner(System.in);
//
//        String str = scanner.nextLine();
//
//        int i= hexToOther(str);
//        System.out.println(i);
//        System.out.println("==========");
        //10进制转27进制
        System.out.println("请输入数字：");
        Scanner scanner1 = new Scanner(System.in);
        int a = scanner1.nextInt();
        System.out.println("输入需要转换的进制：");
        int b = scanner1.nextInt();
//        String string = OtherToTen(anInt);
        String s = TenToOther(b, a);
        System.out.println("数字转10进制:" + s);
    }

    private static String OtherToTen(int anInt) {
      String s= "";
      int yushu;
      int shang = anInt;
      while (shang >0) {
          yushu = shang % 26;
          shang = shang / 26;
          s = (char)(yushu - 1+'A') + s;
      }
      return s;
    }

    private static int hexToOther(String str) {

        char[] chars = str.toUpperCase().toCharArray();
        int num = 0;
        for (int i= 0 ; i < chars.length; i++) {
            int a = chars[i] - 'A' + 1;
            num = num *26 + a;
        }
        return num;
    }

    //通用写法, 10进制转其他进制

    private static String TenToOther(int hex, int n) {
        String s = "";
        int yushu;
        int shang = n;
        while (shang >0) {
            yushu = shang % hex;
            shang = shang / hex;

            if (yushu > 9) {
                s = ('A' + yushu - 10) + s;
            } else {
                s = yushu + s;
            }
        }

        return s;
    }


}
