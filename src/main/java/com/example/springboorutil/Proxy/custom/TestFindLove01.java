package com.example.springboorutil.Proxy.custom;

public class TestFindLove01 {

    public static void main(String[] args) {
        try{
            PersonTest obj = (PersonTest) new GPMeipo().getInstance(new XiaoXingxingTest());
            obj.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
