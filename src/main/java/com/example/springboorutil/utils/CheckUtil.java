/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.springboorutil.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * description
 *
 * @author hujun [KF.hujunA@h3c.com]
 * @date 2019/04/01 17:29
 * @since 1.0
 */
public class CheckUtil {
    public CheckUtil() {
    }

    public static boolean isNullOrEmpty(Object pObj) {
        if (pObj == null) {
            return true;
        } else if (pObj instanceof String) {
            return ((String) pObj).length() == 0;
        } else if (pObj instanceof Collection) {
            return ((Collection) pObj).isEmpty();
        } else if (pObj instanceof Map) {
            return ((Map) pObj).size() == 0;
        } else {
            return false;
        }
    }

    public static boolean isNotNullAndNotEmpty(Object pObj) {
        if (pObj == null) {
            return false;
        } else if (pObj instanceof String) {
            return ((String) pObj).length() != 0;
        } else if (pObj instanceof Collection) {
            return !((Collection) pObj).isEmpty();
        } else if (pObj instanceof Map) {
            return ((Map) pObj).size() != 0;
        } else {
            return true;
        }
    }

    public static void checkTest() {
        String name = new String();
//        Assert.isTrue(isNullOrEmpty(name), "name不为空");
        List<String> names = Lists.newArrayList();
//        Assert.isTrue(isNullOrEmpty(names), "names列表不为空");
        Map<String, String> userMap = Maps.newHashMap();
//        Assert.isTrue(isNullOrEmpty(userMap), "useMap不为空");
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }
    public static boolean isAnagram(String s, String t) {
        //  首先判断两个字符串长度是否相等，不相等则直接返回 false
//          若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
//          s 负责在对应位置增加，t 负责在对应位置减少
//          如果哈希表的值都为 0，则二者是字母异位词
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }
}
