package com.learn.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPSenderDemo01 {
    public static void main(String[] args) throws Exception {
        // 创建一个socket连接，8888端口
        DatagramSocket socket = new DatagramSocket(8888);

        // 准备数据 控制台读取
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 控制台获取数据
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            // 同样创建一个UDP包，包中包含了ip端口等信息
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
            // 发送
            socket.send(packet);
            if (data.equals("bye")) {
                break;
            }
        }
        socket.close();
    }
}
