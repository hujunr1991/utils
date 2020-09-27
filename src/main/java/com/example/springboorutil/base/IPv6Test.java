/*
 * www.cetc.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.springboorutil.base;

/**
 * description
 *
 * @author hujun [hujunr151@163.com]
 * @date 2020/09/15 11:26
 * @since 1.0
 */
import org.junit.Test;

public class IPv6Test {
    public static final String ipv4Regex = "(^((22[0-3]丨2[0-1][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})){3})$)";
    public static final String ipv6Regex = "(^(([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}{1}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}{1}|((22[0-3]丨2[0-1][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(:[0-9A-Fa-f]{1,4}{1,2}|:((22[0-3]丨2[0-1][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(:[0-9A-Fa-f]{1,4}{1,3}|:((22[0-3]丨2[0-1][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){3}(:[0-9A-Fa-f]{1,4}{1,4}|:((22[0-3]丨2[0-1][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){2}(:[0-9A-Fa-f]{1,4}{1,5}|:((22[0-3]丨2[0-1][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){1}(:[0-9A-Fa-f]{1,4}{1,6}|:((22[0-3]丨2[0-1][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})){3})|:))|(:(:[0-9A-Fa-f]{1,4}{1,7}|:((22[0-3]丨2[0-1][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|0[1 -9][0-9]|([0-9])]{1,2})){3})|:))$)";
    public static final String httpRegex = "(^((http|https|HTTP|HTTPS)://.{1,245})$)";
    public static final String domainRegex = "(^(([a-zA-Z0-9](([a-zA-Z0-9]|[-]){0-61}[a-zA-Z0-9])?[.])+[a-zA-Z0-9]{2,6}$)";
    public static final String emptyRegex = "(^$)";

    public static final String finalRegex = ipv4Regex + "|" + ipv6Regex + "|" + httpRegex + "|" + domainRegex + "|" + emptyRegex;

    public static void main(String args[]) {
        try {

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    // 第一个字段长度为3的测试用例
    @Test
    public void testIpv4_1() {
        assert ("200.255.255.255".matches(finalRegex));
        assert ("223.255.255.255".matches(finalRegex));
        assert ("224.255.255.255".matches(finalRegex));

        assert ("192.0.0.1".matches(finalRegex));
        assert ("127.0.0.1".matches(finalRegex));
        assert ("100.0.0.1".matches(finalRegex));
        assert ("090.0.0.1".matches(finalRegex));
        assert ("009.0.0.1".matches(finalRegex));

    }

    // 第一个字段长度为1或2的测试用例
    @Test
    public void testIpv4_2() {
        assert ("09.255.255.255".matches(finalRegex));
        assert ("90.255.255.255".matches(finalRegex));
        assert ("00.255.255.255".matches(finalRegex));

        assert (!"-.0.0.1".matches(finalRegex));
        assert ("0.0.0.1".matches(finalRegex));
        assert ("1.0.0.1".matches(finalRegex));
    }

    // 测试后面三个字节
    @Test
    public void testIpv4_3() {
        assert ("200.0.255.255".matches(finalRegex));
        assert ("200.01.255.255".matches(finalRegex));
        assert ("200.10.255.255".matches(finalRegex));
        assert (!"200.256.255.255".matches(finalRegex));
        assert ("200.001.255.255".matches(finalRegex));

        assert ("200.255.0.255".matches(finalRegex));
        assert ("200.255.01.255".matches(finalRegex));
        assert ("200.255.10.255".matches(finalRegex));
        assert (!"200.255.256.255".matches(finalRegex));
        assert ("200.255.001.255".matches(finalRegex));

        assert ("200.255.255.0".matches(finalRegex));
        assert ("200.255.255.01".matches(finalRegex));
        assert ("200.255.255.10".matches(finalRegex));
        assert (!"200.255.255.256".matches(finalRegex));
        assert ("200.255.255.001".matches(finalRegex));

    }

    // 测试异常
    @Test
    public void testIpv4_4() {
        assert (!"200".matches(finalRegex));
        assert (!"200.1".matches(finalRegex));
        assert (!"200.1".matches(finalRegex));
        assert (!"200.1.1".matches(finalRegex));
        assert (!"200.1.1.1.1".matches(finalRegex));
    }

    @Test
    public void testIpv6_1() {
        assert ("1:2:3:4:5:6:7::".matches(finalRegex));
        assert ("1:2:3:4:5:6:7:8".matches(finalRegex));

        assert ("1:2:3:4:5:6::".matches(finalRegex));
        assert ("1:2:3:4:5:6::8".matches(finalRegex));

        assert ("1:2:3:4:5::".matches(finalRegex));
        assert ("1:2:3:4:5::8".matches(finalRegex));

        assert ("1:2:3:4::".matches(finalRegex));
        assert ("1:2:3:4::8".matches(finalRegex));

        assert ("1:2:3::".matches(finalRegex));
        assert ("1:2:3::8".matches(finalRegex));

        assert ("1:2::".matches(finalRegex));
        assert ("1:2::8".matches(finalRegex));

        assert ("1::".matches(finalRegex));
        assert ("1::8".matches(finalRegex));

        assert ("::".matches(finalRegex));
        assert ("::8".matches(finalRegex));
        assert ("::7:8".matches(finalRegex));
        assert ("::6:7:8".matches(finalRegex));
        assert ("::5:6:7:8".matches(finalRegex));
        assert ("::4:5:6:7:8".matches(finalRegex));
        assert ("::3:4:5:6:7:8".matches(finalRegex));
        assert ("::2:3:4:5:6:7:8".matches(finalRegex));

        assert ("::192.168.1.1".matches(finalRegex));

    }

    @Test
    public void testIpv6_2() {
        assert ("A:0f:0F:FFFF:5:6:7:8".matches(finalRegex));
        assert (!"A:0f:0F:FFFF1:5:6:7:8".matches(finalRegex));
        assert (!"G:0f:0F:FFFF:5:6:7:8".matches(finalRegex));
    }

    @Test
    public void testHttp() {
        assert ("https://a.com".matches(finalRegex));
        assert ("https://a.b.c.com".matches(finalRegex));
        assert ("https://a".matches(finalRegex));
        assert ("https://a.comdddd".matches(finalRegex));
        assert (!"https://afadfadfadfadfadfadfadfadfadfffffffffffffffffffffffffffffffffffffffffffffffdfadfadfadfadfadfadfadfaafadfadfadfadfadfadfadfadfadfffffffffffffffffffffffffffffffffffffffffffffffdfadfadfadfadfadfadfadfaafadfadfadfadfadfadfadfadfadfffffffffffffffffffffffffffffffffffffffffffffffdfadfadfadfadfadfadfadfa.comdddd"
                .matches(finalRegex));
    }

    @Test
    public void testDomain() {
        assert ("a.com".matches(finalRegex));
        assert ("a.bdfad-dfadf.c.com".matches(finalRegex));
        assert (!"a.-bdfad-dfadf.c.com".matches(finalRegex));
        assert ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWSYZabcdefghijk.com".matches(finalRegex));
        assert (!"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWSYZabcdefghijk1.com".matches(finalRegex));
    }

    @Test
    public void testEmpty() {
        assert ("".matches(finalRegex));
        assert (!"1".matches(finalRegex));

    }
}
