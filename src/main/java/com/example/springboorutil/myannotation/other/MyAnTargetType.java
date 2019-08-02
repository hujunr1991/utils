package com.example.springboorutil.myannotation.other;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 定义一个可以注解在Class,interface,enum上的注解
 * @author hujun [hu.junr151@163.com]
 * @date   2019/7/7 12:14
 * @since  1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnTargetType {
    String value() default "我是定义在类接口枚举类上的注解元素value的默认值";
}
