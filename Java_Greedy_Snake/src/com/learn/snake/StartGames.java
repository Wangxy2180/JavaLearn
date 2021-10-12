package com.learn.snake;

//awt

import javax.swing.*;

public class StartGames {
    public static void main(String[] args) {
        // 1.绘制静态窗口 JFrame
        JFrame frame = new JFrame("Java_learn 贪吃蛇小游戏");
        // 设置页面大小，左上和宽高
        frame.setBounds(10, 10, 900, 720);
        frame.setResizable(false);//窗口大小不可改变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭事件

        // 2. 面板 JPanel，把自己的JPanel加入到JFrame中
        // 后续所有东西都画在Panel上
        frame.add(new GamePanel());

        frame.setVisible(true);//设置可见性
    }
}