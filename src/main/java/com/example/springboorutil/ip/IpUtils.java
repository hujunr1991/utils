package com.example.springboorutil.ip;

import com.example.springboorutil.IDGenerator.IDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * ip工具类
 *
 * @author hujun [hu.jun@unisinsight.com]
 * @date 2019/5/8 19:05
 * @since 1.0
 */
public final class IpUtils {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(IpUtils.class);

    /**
     * 私有构造函数
     */
    private IpUtils() {
    }

    /**
     * 获取Windows本地IP
     *
     * @return ip
     */
    public static String getWindowsLocalIP() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            logger.error("获取Windows本地IP失败: ", e);
        }
        //获取本机ip
        if (addr != null) {
            return addr.getHostAddress();
        }
        return null;
    }

    public static String getLocalIP() {
        if (isWindowsOS()) {
            return getWindowsLocalIP();
        } else {
            return getLinuxLocalIp();
        }
    }

    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }

    private static String getLinuxLocalIp() {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    ip = getIPAddress(intf);
                }
            }
        } catch (SocketException e) {
            logger.error("获取Linux本地IP失败: ", e);
        }
        return ip;
    }

    private static String getIPAddress(NetworkInterface intf) {
        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
            InetAddress inetAddress = enumIpAddr.nextElement();
            if (!inetAddress.isLoopbackAddress()) {
                String ipaddress = inetAddress.getHostAddress();
                if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                    return ipaddress;
                }
            }
        }
        return "";
    }

    /**
     * 静态资源加绝对路径
     *
     * @param relativeUri 绝对路径
     * @return ip
     */
    public static String addAbsoluteIP(String relativeUri) {
        return "http://" + IpUtils.getLocalIP() + relativeUri;
    }


    public static void main(String[] args) {
        String fileName = IDUtils.newID() + ".jpg";
        IpUtils.addAbsoluteIP("/image/" + fileName);
        int i = 0;
    }
}
