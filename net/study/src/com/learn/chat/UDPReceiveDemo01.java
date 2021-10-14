package com.learn.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        // 创建一个本地的6666端口的socket
        DatagramSocket socket = new DatagramSocket(6666);

        // 准备接收的包裹
        while (true) {
            // 创建接收数据包，并接收数据
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);// 阻塞式接收包裹

            // 将接收到的数据解包并初始化为string类型
            byte[] data = packet.getData();
            String recvData = new String(data, 0, data.length);
            System.out.println(recvData);
            if (recvData.trim().equals("bye")) {
                break;
            }

        }
        // 断开连接
        socket.close();

    }
}
