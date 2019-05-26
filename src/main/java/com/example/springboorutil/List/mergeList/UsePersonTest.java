package com.example.springboorutil.List.mergeList;

import com.example.springboorutil.json.objectMapper.Student;

import java.util.ArrayList;
import java.util.List;

public class UsePersonTest {
    //方法调用
    public static void main(String[] args) {

        List<Person> students = new ArrayList<>();

        students.add(new Person("abc", 12));
        students.add(new Person("bcd", 20));
        students.add(new Person("cde", 17));
        students.add(new Person("def", 25));
        students.add(new Person("efg", 15));
        //这方法需要jdk1.8以上
        students.sort((x, y) -> Integer.compare(y.getAge(), x.getAge()));

        for (Person stu : students) {
            System.out.println(stu);
        }
    }

}
