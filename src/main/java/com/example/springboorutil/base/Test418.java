package com.example.springboorutil.base;

import java.util.Scanner;

public class Test418 {

    /**
     * 有一种简易压缩算法：针对由全部小写字母组成的字符串，将其中连续超过两个相同字目的部分压缩成连续个数加该字母，其他部分保持原样不变。
     *
     * 例如，字符串：aaabccccd 经过压缩成为字符串：3ab4cd。请您编写一个unZip函数，根据输入的字符串，判断其是否为合法压缩过的字符串。
     * 若输入合法，则输出解压后的字符串，否则输出：!error 来报告错误。
     *
     * 测试：3ab4cd合法，aa4b合法,caa4b合法,3aa4b不合法,22aa不合法,2a4b不合法,22a合法
     * ————————————————
     * 版权声明：本文为CSDN博主「小松加哲」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/u011614717/article/details/81739532
     * @param args
     */
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String in = sc.nextLine();
            if (null == in || in.trim().equals("")) {
                return;
            }
            System.out.println(unZip(in.toCharArray()));
        }

        /**
         * 解压
         * @param input
         * @return
         */
        private static String unZip(char[] input) {
            if (!checkInput(input, null)) {
                System.out.println("!error");
                return "";
            }

            StringBuilder strUnZip = new StringBuilder();
            int i = 0, len = input.length;

            while (i < len) {
                char c = input[i];
                if (Character.isDigit(c)) {
                    StringBuilder countSb = new StringBuilder();
                    countSb.append(c);

                    char nextC = c;
                    int nextI = i + 1;
                    if (nextI < len && Character.isDigit(input[nextI])) {
                        // 输入字符串长度大于1，截取剩余部分递归用
                        char[] remain = new char[len - nextI];
                        System.arraycopy(input, nextI, remain, 0, (len - nextI));
                        // 下一个也为数字时，要和当前数字组合成一个整数
                        nextC = findCount(remain, countSb);
                    } else if (nextI < len) {
                        nextC = input[nextI];
                    }

                    int count = Integer.parseInt(countSb.toString());
                    for (int s = 0; s < count; s++) {
                        strUnZip.append(nextC);
                    }
                    i = nextI + countSb.length();
                } else {
                    strUnZip.append(c);
                    i ++;
                }
            }
            return strUnZip.toString();
        }

        /**
         * 获取字母前的数字，比如：123a，获取到123，返回a
         * @param input
         * @param countSb
         * @return
         */
        private static char findCount(char[] input, StringBuilder countSb) {
            // 如果剩最后一个，肯定是小写字母
            int len = input.length;
            char c = input[0];
            if (len == 1) {
                return c;
            }

            countSb.append(c);
            char nextC = input[1];
            if (Character.isDigit(nextC)) {
                char[] remain = new char[len - 1];
                System.arraycopy(input, 1, remain, 0, len - 1);
                return findCount(remain, countSb);
            } else {
                return nextC;
            }
        }

        /**
         * 校验合法性，非法返回false
         * @param input
         * @param lastChar
         * @return
         */
        private static boolean checkInput(char[] input, Character lastChar) {
            if (null == input || input.length == 0) {
                return false;
            }

            int len = input.length;
            char c = input[0];

            // 只有一个字符且为小写字母
            if (len == 1 && Character.isLowerCase(c)) {
                return true;
            }

            // 输入字符串长度大于1，截取剩余部分递归用
            char[] remain = new char[len - 1];
            System.arraycopy(input, 1, remain, 0, len - 1);

            char nextC = input[1];
            boolean flag = false;
            // 3ab4cd合法，aa4b合法,caa4b合法,3aa4b不合法,22aa不合法,2a4b不合法,22a合法
            if (Character.isDigit(c)) {

                if (Character.isLowerCase(nextC)) {
                    if (null == lastChar && Integer.parseInt(String.valueOf(c)) > 2) {
                        // 下一个字符如果是小写字母，则该数字要大于2
                        flag = true; // 第一个
                    } else if (lastChar != null && Character.isDigit(lastChar)) {
                        // c是数字，c前面字符也是数字时，合法
                        flag = true;
                    } else if (lastChar != null && Character.isLowerCase(lastChar)) {
                        if (Character.isLowerCase(nextC) && Integer.parseInt(String.valueOf(c)) > 2) {
                            // c前面是小写字母，如果c后面是字母，则c必须大于2
                            flag = true;
                        } else if (Character.isDigit(nextC)) {
                            // 如果c后面是数字时合法
                            flag = true;
                        }
                    }
                } else if (Character.isDigit(nextC)) {
                    flag = true;
                }

            } else if (Character.isLowerCase(c)) {
                // 为小写字母时，后面跟着的相同字母不能超过2个
                if (null == lastChar) {
                    flag = true; // 第一个
                } else if (Character.isLowerCase(lastChar)) {
                    if (lastChar == c && lastChar != nextC) {
                        flag = true;
                    } else if (lastChar != c) {
                        flag = true;
                    }
                } else if (Character.isDigit(lastChar) && c != nextC) {
                    flag = true;
                }
            }

            return flag && checkInput(remain, c);
        }



}
