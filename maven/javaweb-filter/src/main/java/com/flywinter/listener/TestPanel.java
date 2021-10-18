package com.flywinter.listener;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/18 18:21
 * Description:
 */
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("实习快乐");//新建一个窗体
        Panel panel = new Panel(null);//面板
        frame.setLayout(null);//设置窗体布局

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(0,0,255));//设置背景颜色


        frame.setBounds(50,50,300,300);
        frame.setBackground(new Color(0,255,0));//设置背景颜色

        frame.add(panel);
        frame.setVisible(true);

        //监听事件，监听关闭事件
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("打开");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭中");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("关闭了");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("激活");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("未激活");
            }
        });

    }
}
