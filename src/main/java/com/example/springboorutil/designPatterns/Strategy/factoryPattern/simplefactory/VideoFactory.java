package com.example.springboorutil.designPatterns.Strategy.factoryPattern.simplefactory;

public class VideoFactory {

    //通过反射扩展属性,解决开闭原则
    public Video getVideoReflect(Class c) {
        Video video = null;
        try {
            video= (Video)Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return video;
    }

    public Video getVideo(String type) {
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        }

        if ("python".equalsIgnoreCase(type)) {
            return new PythonVideo();
        }

        return null;
    }
}
