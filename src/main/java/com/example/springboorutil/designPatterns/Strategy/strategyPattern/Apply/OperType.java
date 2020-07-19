package com.example.springboorutil.designPatterns.Strategy.strategyPattern.Apply;

public enum OperType {

    ADD(1,OperationAdd.getInstance()),SUB(2,OperationSub.getInstance());
    private Integer code;
    private SuperInterface option;

    private OperType(Integer code,SuperInterface option){
        this.setCode(code);
        this.setOption(option);
    }
    public SuperInterface getOption() {
        return option;
    }
    public void setOption(SuperInterface option) {
        this.option = option;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}