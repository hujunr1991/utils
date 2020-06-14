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
//        String a = "bb";
//        Long to27 = get12TO27(a);
//        System.out.println(to27);
//
//        Double d = 100.0;
//        d.intValue();
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());

        //返回 Java虚拟机试图使用的最大内存量。物理内存的1/4（-Xmx）
        long maxMemory = Runtime.getRuntime().maxMemory() ;
        //返回 Java虚拟机中的内存总量(初始值)。物理内存的1/64（-Xms）
        long totalMemory = Runtime.getRuntime().totalMemory() ;
        System.out.println("MAX_MEMORY =" + maxMemory +"(字节)、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("DEFALUT_MEMORY = " + totalMemory + " (字节)、" + (totalMemory / (double)1024 / 1024) + "MB");





    }
}
