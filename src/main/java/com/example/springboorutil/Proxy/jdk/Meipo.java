package com.example.springboorutil.Proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Meipo implements InvocationHandler {

    private Person target;

    //获取代理人的资料
    public Object getInstance(Person target) throws Exception{
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //筛选结果
        System.out.println("-----");
        method.invoke(this.target, args);

        return null;
    }
}
