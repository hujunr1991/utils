package com.example.springboorutil.jianzhiOffer.two;

public class replace051802 {
    public static void main(String[] args) {
        String str = "we are happy";
        System.out.println(replacePercent(str));
        char[] chars = str.toCharArray();
        System.out.println(replaceBlank(chars));
    }

    private static String replaceBlank(char[] chars) {
        //先统计需要的总体长度，便利一遍有多少个空格
        int i = 0;
        int blankNum = 0;
        int originalLength = 0;
        while (i < chars.length) {
            if (chars[i] == ' ') {
                blankNum++;
            }
            originalLength++;
            i++;
        }
        int newLength = originalLength + 2*blankNum-1;

        int oldLength = originalLength -1;

        while (oldLength >= 0 && newLength > oldLength) {
            if (chars[newLength] == ' ') {
                chars[newLength--] = '0';
                chars[newLength--] = '2';
                chars[newLength--] = '%';
            } else {
                chars[newLength--] = chars[oldLength];
            }
            oldLength --;
        }
        return String.valueOf(chars);

    }

    private static String replacePercent(String str) {

        //效率太差
        return str.replace(" ", "%20");
    }
}
