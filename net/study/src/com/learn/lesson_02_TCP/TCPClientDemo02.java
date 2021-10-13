package com.learn.lesson_02_TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientDemo02 {
    // 这里是为了方便讲解，直接抛出了异常，实际开发千万别这么做
    public static void main(String[] args) throws Exception {
        // 1.创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        // 2.创建一个输出流
        OutputStream os = socket.getOutputStream();
        // 3.读取文件流
        FileInputStream fis = new FileInputStream(new File("test.png"));
        // 4. 写出文件 1024可以修改，习惯与规范的问题
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        // ？？这里不理解了，为啥前边那个没有呢
        // 通知服务器传输结束了
        socket.shutdownOutput(); // 传输完毕

        // 确定服务器接收完毕，才能够断开连接
        InputStream inputStream = socket.getInputStream();
        // byte[]
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = inputStream.read(buffer2)) != -1) {
            baos.write(buffer2, 0, len2);
        }

        System.out.println(baos.toString());

        // 5.关闭资源
        baos.close();
        inputStream.close();
        fis.close();
        os.close();
        socket.close();


    }
}
