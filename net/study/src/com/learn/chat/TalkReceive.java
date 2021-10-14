package com.learn.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

// 这里是创造了个类，用来进行UDP包的接收
public class TalkReceive implements Runnable {
    DatagramSocket socket = null;

    private int port;
    private String msgFrom;

    public TalkReceive(int port, String msgFrom) {
        this.port = port;
        this.msgFrom=msgFrom;
        try {
            // 创建一个socket连接
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                // 创建一个UDP包并用该包接收包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);// 阻塞式接收包裹

                byte[] data = packet.getData();
                String recvData = new String(data, 0, data.length);
                System.out.println(msgFrom+":"+recvData);

                // 断开连接
                if (recvData.trim().equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        socket.close();
    }
}
