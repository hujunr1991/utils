package com.example.springboorutil.StringCode;

import java.lang.reflect.Field;

public class TestString {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        /*
        compareTo()的返回值是整型，它是先比较对应字符的大小（ASCII码顺序），

如果第一个字符和参数的第一个字符不等，结束比较，返回他们之间的差值。

如果第一个字符和参数的第一个字符相等，则以第二个字符和参数的第二个字符作比较，

以此类推，直至比较的字符或被比较的字符有一方全比较完，这时就比较字符的长度。
————————————————
版权声明：本文为CSDN博主「_Debug_debug」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/u010931123/article/details/83019819
         */
        System.out.println("qwe".compareTo("asd"));  //q是113   a是97   。113-97=16
        System.out.println("201801".compareTo("201802"));//前五位相同 ， 1是49,2是50,49-50=-1

        String str = "https://blog.csdn.net/u010931123/article/details/83019819";

        Class<?> clz = String.class;
        Field value = clz.getDeclaredField("value");
        Field[] declaredFields = clz.getDeclaredFields();
        value.setAccessible(true);
        char[] arr = (char[])value.get(str);
        arr[0] = 'a';


    }
}
