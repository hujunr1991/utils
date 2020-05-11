package com.example.springboorutil.office.excel.test;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;

    @Excel(name = "姓名", width= 20,height = 30)
    private String name;
    @Excel(name = "年龄",width= 20,height = 30)
    private Integer age;
    @Excel(name = "性别",width = 20,height = 30,replace = {"男_1","女_0"},suffix = "生")
    private Integer sex;
}
