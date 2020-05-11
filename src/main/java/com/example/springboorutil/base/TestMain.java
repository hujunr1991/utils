package com.example.springboorutil.base;

public class TestMain {

    private static long get12TO27(String str) {
        long sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum = sum +(long) (str.charAt(i) -'a' + 1)* (long)Math.pow(26, str.length()- i -1);
        }
      return sum;
    }

    public static void main(String[] args) {
        String a = "bb";
        Long to27 = get12TO27(a);
        System.out.println(to27);

        Double d = 100.0;
        d.intValue();



    }
}
