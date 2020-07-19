package com.example.springboorutil.jianzhiOffer.two.execise50;

public class Programme23 {

    /**
     * 题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多大？
     *
     * 程序分析：利用递归的方法，递归分为回推和递推两个阶段。要想知道第五个人岁数，需知道第四人的岁数，依次类推，推到第一人（10岁），再往回推。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("第五个人的岁数："+GetAge(5,2));
    }

    //递归方法求第五个人的岁数

    private static int GetAge(int num, int ageMore) {

        if (num==1) {//第一个人岁数为10

            return 10;

        }
        //必须时GetAge得到值了才能进行下一步的 + ageMore
        int i = GetAge(num - 1, ageMore) + ageMore;
        System.out.println(i);
        return i;//每上一个人岁数加2

    }
}
