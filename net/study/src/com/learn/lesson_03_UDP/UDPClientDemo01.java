package com.learn.lesson_03_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

// 不需要连接服务器
public class UDPClientDemo01 {
    public static void main(String[] args) throws Exception {
        // 1.建立一个socket
        DatagramSocket socket = new DatagramSocket();

        // 2.建包
        String msg = "hello server";

        // 发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;

        // 包里边包含了所有的信息，ip端口号等
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        // 3.发送包
        socket.send(packet);

        // 4.关闭流
        socket.close();
    }
}
