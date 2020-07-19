package com.example.springboorutil.jianzhiOffer.two.execise50;

public class Programme42 {
    public static void main(String[] args) {

        String result="";

        for (int i = 100; i < 1000;i++) {

            if (809*i==800*i+9*i+1) {

                result=i+" ";

            }

        }

        if (result.equals("")) {

            System.out.println("没有合适的数");

        }else {

            System.out.println("合适的数有："+result);

        }

    }
}
