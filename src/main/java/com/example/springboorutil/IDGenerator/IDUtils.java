package com.example.springboorutil.IDGenerator;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * id生成器
 * <p>
 * 时间戳：yyyyMMddHHmmss 14位
 * </p>
 * <p/>
 * 顺序号: 保证单位时间内(同一秒)唯一. 4位
 * <p>
 *
 * @author hujun [hu.jun@unisinsight.com]
 * @date 2018/9/7 9:02
 * @since 1.0
 */
public final class IDUtils {

    private static final char PADDING_CHAR = '0';

    /**
     * 时间戳
     */
    public static final int TIMESTAMP_LEN = 12;

    /**
     * 顺序号长度
     */
    public static final int SEQUENCE_LEN = 4;

    /**
     * 时间缓存
     */
    private static volatile long lastTimeCache = 0L;

    /**
     * 时间字符串缓存
     */
    private static String lastTimeStrCache = null;

    /**
     * 14位的时间格式
     */
    private static final String TIME_FORMAT = "yyyyMMddHHmmss";

    /**
     * 每秒内生成id最大数
     */
    private static final int COUNT_IN_SECOND = 10000000;

    private static final int FOUR_RANDOM_LENGTH = 1000;

    private static AtomicLong lastTimeWithCount = new AtomicLong(0);

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(TIME_FORMAT);

    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
            'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z',};
    public static final int RADIX = DIGITS.length;

    private IDUtils() {
    }

    /**
     * id生成，唯一,可读性
     * 时间戳(14位) + 顺序号(4位或更多,保证在同一秒内并发请求生成id唯一)
     * 例:
     *
     * @return
     */
    public static String newID() {
        StringBuilder idBuilder = new StringBuilder(18);

        DateTime now = new DateTime();
        //14位 时间戳
        idBuilder.append(getTimeStrCode(now));
        //4 顺序号: 保证单位时间内(同一秒)唯一.
        idBuilder.append(getSequenceNoCode(now));
        return idBuilder.toString();
    }

    /**
     * 不重复ID
     * 同一微秒(milliseconds) 有可能重复
     */
    public static String fastID() {
        StringBuilder idBuilder = new StringBuilder(18);
        DateTime now = new DateTime();
        //14位 时间戳 + 4位 顺序号 不重复
        String base = getTimeStrCode(now);
        idBuilder.append(base).append(get4NoCode());
        return idBuilder.toString();

    }

    /**
     * 获取4位定长随机数字
     */
    public static String get4NoCode() {
        int i = 0;
        while (i < FOUR_RANDOM_LENGTH) {
            i = (new Random()).nextInt(9999);
        }
        return String.valueOf(i);
    }

    /**
     * 获取时间戳对应串 如:201807281649000000
     *
     * @param now
     * @return
     */
    private static String getTimeStrCode(DateTime now) {
        String timeStr;
        if (lastTimeCache == now.getMillis()) {
            timeStr = lastTimeStrCache;
        } else {
            timeStr = now.toString(dateTimeFormatter);
            lastTimeStrCache = timeStr;
            lastTimeCache = now.getMillis();
        }
        return timeStr;
    }

    private static String getSequenceNoCode(DateTime now) {
        long timeWithCount = (now.getMillis() / 1000) * COUNT_IN_SECOND;
        while (true) {
            long last = lastTimeWithCount.get();
            if (timeWithCount > last && lastTimeWithCount.compareAndSet(last, timeWithCount)) {
                break;
            } else {
                if (lastTimeWithCount.compareAndSet(last, last + 1)) {
                    timeWithCount = last + 1;
                    break;
                }
            }
        }
        int seqNo = (int) (timeWithCount % COUNT_IN_SECOND);
        return padding(toString(seqNo), SEQUENCE_LEN, PADDING_CHAR);
    }

    /**
     * 填充字符串
     *
     * @param str     待填充字符串
     * @param len     填充后的位数
     * @param padding 填充字符
     */
    private static String padding(String str, int len, char padding) {
        if (str.length() < len) {
            StringBuilder sb = new StringBuilder(len);
            int toPadLen = len - str.length();
            for (int i = 1; i <= toPadLen; i++) {
                sb.append(padding);
            }
            sb.append(str);
            return sb.toString();
        } else {
            return str;
        }
    }

    private static String toString(long i) {
        char[] buf = new char[65];
        int charPos = 64;
        boolean negative = (i < 0);

        if (!negative) {
            i = -i;
        }

        while (i <= -RADIX) {
            buf[charPos--] = DIGITS[(int) (-(i % RADIX))];
            i = i / RADIX;
        }
        buf[charPos] = DIGITS[(int) (-i)];

        if (negative) {
            buf[--charPos] = '-';
        }
        return new String(buf, charPos, (65 - charPos));
    }


    public static void main(String[] args) {
        String id = IDUtils.newID();
        System.out.println(id);
    }


}
