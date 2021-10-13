package com.learn.lesson_02_TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

// 客户端
public class TCPClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;

        try {
            // 1. 知道服务器的地址，端口号
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            // 2.创建一个socket连接
            socket = new Socket(serverIP, port);
            // 3.发送消息IO流
            os = socket.getOutputStream();
            os.write("Java 网络编程初学者".getBytes());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
