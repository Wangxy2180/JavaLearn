package com.learn.chat;

public class TalkTeacher {
    public static void main(String[] args) {
        // 从自己的5555端口，发送到localhost:8888
        new Thread(new TalkSend("localhost",8888,5555)).start();
        // 在9999端口接收来自学生的东西
        new Thread(new TalkReceive(9999,"Student")).start();
    }
}
