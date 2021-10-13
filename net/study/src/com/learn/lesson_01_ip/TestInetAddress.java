package com.learn.lesson_01_ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

// 测试ip
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);

            InetAddress inetAddress3 = InetAddress.getByName("localhost");
            System.out.println(inetAddress3);

            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4);

            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            // 常用方法
            // System.out.println(inetAddress2.getAddress()); //没啥用，不知道干啥的
            System.out.println(inetAddress2.getCanonicalHostName()); //规范名
            System.out.println(inetAddress2.getHostAddress()); //ip
            System.out.println(inetAddress2.getHostName()); //域名

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
