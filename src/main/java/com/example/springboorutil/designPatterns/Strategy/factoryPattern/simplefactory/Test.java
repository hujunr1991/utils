package com.example.springboorutil.designPatterns.Strategy.factoryPattern.simplefactory;

public class Test {
    public static void main(String[] args) {

        VideoFactory factory = new VideoFactory();
        Video java = factory.getVideo("java");
        java.product();

        Video videoReflect = factory.getVideoReflect(PythonVideo.class);
        videoReflect.product();

    }
}
