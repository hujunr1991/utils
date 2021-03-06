package com.example.springboorutil.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: Md5SHAEncryptionUtil
 * @Description: 使用Java自带的MessageDigest类
 * <p>
 * 由于MD5 与SHA-1均是从MD4 发展而来，
 * <p>
 * 它们的结构和强度等特性有很多相似之处 SHA-1与MD5 的最大区别在于其摘要比MD5 摘要长 32
 * 比特（1byte=8bit，相当于长4byte，转换16进制后比MD5多8个字符）。
 * <p>
 * 对于强行攻击，：MD5 是2128 数量级的操作，SHA-1 是2160数量级的操作。 对于相同摘要的两个报文的难度：MD5是
 * 264 是数量级的操作，SHA-1 是280 数量级的操作。
 * <p>
 * 因而，SHA-1 对强行攻击的强度更大。 但由于SHA-1 的循环步骤比MD5 多（80:64）且要处理的缓存大（160
 * 比特:128 比特），SHA-1 的运行速度比MD5 慢。
 * @author: Mr.Yang
 * @date: 2017年11月13日 上午12:25:43
 */
public class Md5SHAEncryptionUtil {

    /**
     * @param source   需要加密的字符串
     * @param hashType 加密类型 （MD5 和 SHA）
     * @return
     */
    public static String getHash(String source, String hashType) {
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest md = MessageDigest.getInstance(hashType);
            // 通过使用 update 方法处理数据,使指定的 byte数组更新摘要
            md.update(source.getBytes());
            // 获得密文完成哈希计算,产生128 位的长整数
            byte[] encryptStr = md.digest();
            // 每个字节用 16 进制表示的话，使用两个字符
            char str[] = new char[16 * 2];
            // 表示转换结果中对应的字符位置
            int k = 0;
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对每一个字节,转换成 16 进制字符的转换
                byte byte0 = encryptStr[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>>
                // 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            // 换后的结果转换为字符串
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param source   需要加密的字符串
     * @param hashType 加密类型 （MD5 和 SHA）
     * @return
     */
    public static String getHash2(String source, String hashType) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(source.getBytes());
            for (byte b : md5.digest()) {
                // 10进制转16进制，X表示以十六进制形式输出，02表示不足两位前面补0输出
                sb.append(String.format("%02X", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param source   需要加密的字符串
     * @param hashType 加密类型 （MD5 和 SHA）
     * @return
     */
    public static String getHash3(String source, String hashType) {
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(source.getBytes());
            byte[] encryptStr = md5.digest();
            for (int i = 0; i < encryptStr.length; i++) {
                int iRet = encryptStr[i];
                if (iRet < 0) {
                    iRet += 256;
                }
                int iD1 = iRet / 16;
                int iD2 = iRet % 16;
                sb.append(hexDigits[iD1] + "" + hexDigits[iD2]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getHash("小工匠", "MD5"));
        System.out.println(getHash("小工匠", "SHA") + "\n");

        System.out.println(getHash2("小工匠", "MD5"));
        System.out.println(getHash2("小工匠", "SHA") + "\n");

        System.out.println(getHash3("小工匠", "MD5"));
        System.out.println(getHash3("小工匠", "SHA") + "\n");
    }

}
