package com.example.springboorutil.designPatterns.Strategy.factoryPattern;

public class ShapeFactory {

    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }

        if (shape.equals("rectangle")) {
            return new Rectangle();
        }

        if (shape.equals("square")) {
            return new Square();
        }
        return null;
    }
}
