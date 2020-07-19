package com.example.springboorutil.designPatterns.Strategy.strategyPattern.Apply;



import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class DemoTest {

    public static void main(String[] args) {
        Map request = new HashMap<String, String>();
        request.put("type", "SUB");
        request.put("data", "[100,20,30]");
        doOperation(request);
    }

    private static void doOperation(Map<String, String> request) {
        String type = request.get("type");
        String data = request.get("data");
        JSONArray objects = JSONArray.parseArray(data);
        OperType operType = OperType.valueOf(type);
        SuperInterface option = operType.getOption();
        Object o = option.doOperation(objects);
        System.out.println("add is :" + o);


    }
}
