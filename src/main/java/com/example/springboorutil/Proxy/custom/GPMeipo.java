package com.example.springboorutil.Proxy.custom;

import java.lang.reflect.Method;

public class GPMeipo implements GPInvocationHandler {


    private PersonTest target;

    public Object getInstance(PersonTest target) throws Exception{
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("新的GP是:"+clazz);
        return GPPorxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("过滤-----");
        method.invoke(this.target, args);
        return null;
    }
}
