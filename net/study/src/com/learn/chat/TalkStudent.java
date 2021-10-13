package com.learn.chat;

public class TalkStudent {
    public static void main(String[] args) {
        // 开启两个线程
        // 从自己的7777端口发送到对方的9999端口
        new Thread(new TalkSend("localhost",9999,7777)).start();
        // 在自己的8888端口接收信息
        new Thread(new TalkReceive(8888,"Teacher")).start();
    }
}
