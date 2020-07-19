package com.example.springboorutil;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
    }
}
