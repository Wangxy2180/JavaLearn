package com.learn.snake;

import javax.swing.*;
import java.net.URL;

// 专门存放外部数据的类
public class Data {
    // 头部的图片 URL 这里的目录是相对于项目目录来说的
    public static URL headerURL = Data.class.getResource("/statics/header.png");
    // 图片,这样就可以把这个图片在程序中用到了
    public static ImageIcon header = new ImageIcon(headerURL);

    // 脑袋
    public static URL upURL = Data.class.getResource("/statics/up.png");
    public static URL downURL = Data.class.getResource("/statics/down.png");
    public static URL leftURL = Data.class.getResource("/statics/left.png");
    public static URL rightURL = Data.class.getResource("/statics/right.png");
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);

    // 身体
    public static URL bodyURL = Data.class.getResource("/statics/body.png");
    public static ImageIcon body = new ImageIcon(bodyURL);
    // 事物
    public static URL foodURL = Data.class.getResource("/statics/food.png");
    public static ImageIcon food = new ImageIcon(foodURL);

}
