package com.example.springboorutil.Proxy.cglib;

public class TestGglibProxy {

    public static void main(String[] args) {

        try{
            hujun obj = (hujun)new GPMeipo().getInstance(hujun.class);
            obj.findLove();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
