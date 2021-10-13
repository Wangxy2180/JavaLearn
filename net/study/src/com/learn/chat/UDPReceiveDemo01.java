package com.learn.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);

        // 准备接收的包裹
        while (true) {
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);// 阻塞式接收包裹

            // 断开连接
            byte[] data = packet.getData();
            String recvData = new String(data, 0, data.length);
            System.out.println(recvData);
            if (recvData.trim().equals("bye")) {
                break;
            }

        }

        socket.close();

    }
}
