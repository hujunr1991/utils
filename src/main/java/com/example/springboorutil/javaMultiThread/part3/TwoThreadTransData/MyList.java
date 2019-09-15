package com.example.springboorutil.javaMultiThread.part3.TwoThreadTransData;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List list = new ArrayList();
    public void add() {
        list.add("aaa");
    }

    public int size() {
        return list.size();
    }
}
