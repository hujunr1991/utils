//package com.example.springboorutil.base;
//
//public class test {
//    private static String trans(String input){
//        if (input == null || input.length()==0)
//            return "ERROR";
//        char[] charArry = input.toCharArray();
//        int count=0;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0;i<charArry.length;i++){
//            if(charArry[i]=='#')
//                count++;
//            if (charArry[i]!='#' && charArry[i]!='.' && charArry[i]!='_')
//                return "ERROR";
//            String nothing = "";
//            if (count == charArry.length)
//                return  nothing;
//
//
//            String[] split = input.split("#");
//            for (int j = 0;i<split.length;i++)
//                if(split[i].equals("")||split[i].equals(" ")){
//                    continue;
//                }else {
//                    String back = binarytrans(split[i]);
//                    if(back.equals("ERROR"))
//                        return back;
//                    sb.append(back);
//                }
//            }
//            return sb.toString();
//    }
//
//    private static String binarytrans(String s) {
//
//    }
//
//
//
//}
