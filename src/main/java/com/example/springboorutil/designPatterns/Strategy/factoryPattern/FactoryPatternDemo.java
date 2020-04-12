package com.example.springboorutil.designPatterns.Strategy.factoryPattern;

import org.junit.Test;

public class FactoryPatternDemo {


    @Test
    public void test(){
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape = shapeFactory.getShape("rectangle");

        shape.draw();

        Shape t= shapeFactory.getShape("square");

        t.draw();

    }
}
