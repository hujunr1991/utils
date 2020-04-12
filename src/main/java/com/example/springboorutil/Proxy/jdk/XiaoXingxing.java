package com.example.springboorutil.Proxy.jdk;

public class XiaoXingxing implements Person {

    private String sex = "女";

    private String name = "时代";

    @Override
    public void findLove() {
        System.out.println("有钱的");
        System.out.println("帅的");
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public String getName() {
        return name;
    }
}
