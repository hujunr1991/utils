package com.example.springboorutil.Proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class TestFindLove {
    public static void main(String[] args) {
//        new XiaoXingxingTest().findLove();
        try{
            Person obj = (Person) new Meipo().getInstance(new XiaoXingxing());
            obj.findLove();

            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("$Proxy.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
