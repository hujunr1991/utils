package com.example.springboorutil.base;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setAge(10);
        user1.setName("臧三");
        userList.add(user1);
        User user2 = new User();
        user2.setAge(20);
        userList.add(user2);
        User user3 = new User();
        user3.setAge(25);
        userList.add(user3);
        Field field = getField(User.class, "name");
        System.out.println(field);


//        int ageSum = userList.stream().collect(Collectors.summingInt(User::getAge));
//        System.out.println("年龄总和 ：" + ageSum);
////下面一位网友提供了一种更加简洁的方式，非常感谢
//        int ageSumTwo = userList.stream().mapToInt(User::getAge).sum();
//        System.out.println("年龄总和2： " + ageSumTwo);

//        float a = 3.2f;
//        BigDecimal   b  =   new  BigDecimal(a);
//        float v = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
//        float num=(float)(Math.round(a*100)/100);
//        System.out.println(v);

        ///////计算小数点的位数：
//        System.out.println("1/8="+1/(float)8);
//
//        float TT = Math.round(1/(float)8);   //返回的是int型。
//        System.out.println("四舍五入小数："+TT);
//        System.out.println("四舍五入小数2："+Math.round(2.1546));
//        float a = 0.1f;
//        DecimalFormat df = new DecimalFormat("0.00");
//        String format = df.format(a);
//        Float aFloat = Float.valueOf(format);
//        System.out.println(aFloat);

//        BigDecimal b = new BigDecimal(T);
//        T = b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
//        System.out.println("保留2位小数："+T);

//        String[] examples = {
//                "441030517@QQ..com",
//                "1119941779@qq,com",
//                "5579001QQ@.COM",
//                "1107531656@q?q?.com",
//                "1495456580@qq@139.com",
//        };
//        String max = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
//        Pattern pattern = Pattern.compile(max);
//        for (String example : examples) {
//            Matcher matcher = pattern.matcher(example);
//            if (!matcher.matches()) {
//                System.out.println("不满足校验" + example);
//            }
//        }
//



    }


    /**
     * <p>功能描述:根据字段名获取字段属性实例</p>
     *
     * @param clazz     字节对象实例<br>
     * @param fieldName 字段属性名称<br>
     *                  {@link java.lang.reflect.Field}属性对象实例<br>
     * @since 2020/6/28 9:48<br>
     */
    public static Field getField(Class<?> clazz, String fieldName) {
        Field result = null;
        // 合法校验
        if (null != clazz && StringUtils.isNotEmpty(fieldName)) {
            // 循环查找
            while (clazz != Object.class) {
                try {
                    result = clazz.getDeclaredField(fieldName);
                    result.setAccessible(true);
                    break;
                } catch (NoSuchFieldException ex) {
                    clazz = clazz.getSuperclass();
                }
            }
        }
        return result;
    }
}

@Data
class User {
    private Integer age;
    private String name;
}
