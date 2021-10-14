package com.learn.lesson_02_TCP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServerDemo02 {
    public static void main(String[] args) throws Exception {
        // 1.创建端口服务
        ServerSocket serverSocket = new ServerSocket(9000);
        // 2.监听客户端连接
        Socket socket = serverSocket.accept(); //阻塞监听，会一直等待客户端，客户端连接完就释放
        // 3.获取输入流
        InputStream is = socket.getInputStream();
        // 4.文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.png"));

        byte[] buffer = new byte[1024];
        int len;
        // 将数据从is中读出存入buffer
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // 通知客户端接收完毕了
        OutputStream os = socket.getOutputStream();
        os.write("recv over".getBytes());


        // 关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
}
