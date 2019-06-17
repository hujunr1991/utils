/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.springboorutil.myannotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * description
 *
 * @author hujun [hu.jun@unisinsight.com]
 * @date 2019/05/13 11:43
 * @since 1.0
 */
public class User {

    @MyAnno(name = "zhang")
    private String name;

    @MyAnno(name = "zhang@example.com")
    private String email;


    @MyAnno(name = "sayHelloWorld")
    public String sayHello() {
        return "";
    }

    public static void main(String[] args) {
        Method[] methods = User.class.getMethods();
//Field[] fields = User.class.getFields();
        Field[] fields = User.class.getDeclaredFields();
/*
    getFields：只能访问public属性及继承到的public属性
    getDeclaredFields：只能访问到本类的属性，不能访问继承到的属性

    getMethods：只能访问public方法及继承到的public方法
    getDeclaredMethods：只能访问到本类的方法，不能访问继承到的方法

    getConstructors：只能访问public构造函数及继承到的public构造函数
    getDeclaredConstructors：只能访问到本类的构造函数，不能访问继承到的构造函数
*/

        for (Field field : fields) {
            MyAnno annotation = field.getAnnotation(MyAnno.class);
            if (annotation != null) {
                System.out.println("property=" + annotation.name());
            }
        }
        for (Method method : methods) {
            MyAnno annotation = method.getAnnotation(MyAnno.class);
            if (annotation != null) {
                System.out.println("sayHello=" + annotation.name());
            }
        }
    }
}
