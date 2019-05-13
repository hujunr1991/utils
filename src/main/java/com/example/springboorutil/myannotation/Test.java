/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.springboorutil.myannotation;

/**
 * description
 *
 * @author hujun [hu.jun@unisinsight.com]
 * @date 2019/05/13 11:30
 * @since 1.0
 */
@MyAnnotation
public class Test {
    @MyAnnotation(name = "qqq", age = 22)
    public static void getNameAndAge(){

    }

    public static void main(String[] args) {
        Class<Test> test = Test.class;
        boolean annotationPresent = test.isAnnotationPresent(MyAnnotation.class);
        if (annotationPresent) {
            MyAnnotation annotation = test.getAnnotation(MyAnnotation.class);
            System.out.println("name=" + annotation.name() + "\tage = " + annotation.age());
        }
    }
}
