package com.learn.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    // 定义蛇的一些信息
    int length;
    // 蛇的xy坐标
    int[] snakeX = new int[600];
    int[] snakeY = new int[600];
    // 方向
    String direction;

    boolean isStart = false;

    // 100ms监听一次当前窗口
    Timer timer = new Timer(100, this);//定时器

    //1. 定义食物
    int food_x, food_y;
    Random random = new Random();

    // 死亡判断
    boolean isFail = false;

    // 积分系统
    int score;

    public GamePanel() {
        init();
        // 获取键盘的监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    // 初始化游戏数据
    public void init() {
        length = 3;
        // 蛇头定位
        // 这个snakeXY会记录走过的路径，然后根据长度画出来
        snakeX[0] = 100;
        snakeY[0] = 100;
        // 第1个身体坐标，因为图片大小是25*25的
        snakeX[1] = 75;
        snakeY[1] = 100;
        // 第2个身体坐标
        snakeX[2] = 50;
        snakeY[2] = 100;

        direction = "R";

        timer.start();//动起来

        food_x = 25 + 25 * random.nextInt(34);
        food_y = 75 + 25 * random.nextInt(24);

        score = 0;

    }


    // 画板功能：画界面，所有的画面都是在这里画的，repaint也会调用该函数
    // Graphics就是一个画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.WHITE); //设置背景颜色

        // 绘制头部广告栏 25 11 是提前算好的
        Data.header.paintIcon(this, g, 25, 11);

        // 绘制游戏区域
        //这里没有什么硬性的限制，所以后续绘图是要注意在这个坐标内
        g.fillRect(25, 75, 850, 600);

        // 先画蛇头
        if (direction.equals("R")) {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("L")) {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("U")) {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("D")) {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        // 再画蛇身，蛇的身体长度通过length控制
        for (int i = 1; i < length; ++i) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        // 积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度" + length, 750, 35);
        g.drawString("分数" + (length * 10 - 30), 750, 50);

        // 画食物
        Data.food.paintIcon(this, g, food_x, food_y);

        // 提示游戏是否开始
        if (!isStart) {
            // 写文字,设置画笔颜色
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 300, 300);
        }

        // 失败提醒
        if (isFail) {
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("游戏失败！按下空格开始游戏", 200, 300);
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        // 获取按下的案件
        int keyCode = e.getKeyCode();
        // 空格键，启动或者暂停
        if (keyCode == KeyEvent.VK_SPACE) {
            if (isFail) {
                // 失败状态按空格，那就重新初始化
                isFail = false;
                init();
            } else {
                isStart = !isStart;
            }
            repaint();//刷新界面
        }

        // 键盘控制走向
        if (keyCode == KeyEvent.VK_LEFT) {
            direction = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            direction = "R";
        } else if (keyCode == KeyEvent.VK_UP) {
            direction = "U";
        } else if (keyCode == KeyEvent.VK_DOWN) {
            direction = "D";
        }
    }

    // 定时器，监听时间流动,执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        // 如果游戏开始状态，并且没有结束，此时才监听按键操作
        if (isStart && !isFail) {
            // 这里是计算小蛇运动过程的部分,就是小蛇向前走
            for (int i = length - 1; i > 0; --i) {
                // 身体向前移动，把后边一节身体给前边
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            // 通过控制方向让头部移动
            if (direction.equals("R")) {
                // 这里应该可以直接取模850
                snakeX[0] = snakeX[0] + 25;
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (direction.equals("L")) {
                // 这里应该可以直接取模850
                snakeX[0] = snakeX[0] - 25;
                // 边界判断
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (direction.equals("U")) {
                // 这里应该可以直接取模850
                snakeY[0] = snakeY[0] - 25;
                // 边界判断
                if (snakeY[0] < 75) {
                    snakeY[0] = 650;
                }
            } else if (direction.equals("D")) {
                // 这里应该可以直接取模850
                snakeY[0] = (snakeY[0] + 25);
                if (snakeY[0] > 650) {
                    snakeY[0] = 75;
                }
            }

            // 吃到了食物
            if (snakeX[0] == food_x && snakeY[0] == food_y) {
                length++;
                // 重新生成食物
                food_x = 25 + 25 * random.nextInt(34);
                food_y = 75 + 25 * random.nextInt(24);
            }

            // 身体和头重合了
            for (int i = 1; i < length; ++i) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isFail = true;
                }
            }

            // 根据新的数据，重新画蛇的信息
            repaint();
        }
        timer.start();
    }


    // 监听键盘的输入
    @Override
    public void keyTyped(KeyEvent e) {
        // 键盘按下弹起

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 释放某个键

    }


}
