/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.springboorutil.NullPointerException;

/**
 * description
 *
 * @author hujun [hu.jun@unisinsight.com]
 * @date 2019/05/08 11:43
 * @since 1.0
 */
public class Book {
    private String id;
    private String name;

    public Book(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Book() {
        super();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
