package com.example.springboorutil.jianzhiOffer.two;

public class Problem9_92 {

    //fibonacci数组的改进，和爬楼梯是一个意思
    public long fibonacci(int n ) {
        //存储最后的结果
        long result = 0;
        //存储第一次结果
        long preOne = 0;
        //存储第二次结果
        long preTwo = 0;
        if (n == 0) {
            return preOne;
        }
        if (n == 1) {
            return preTwo;
        }
        for (int i =2; i<=n;i++) {
            result = preOne + preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return result;
    }


}
