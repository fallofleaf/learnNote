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
        Frame frame = new Frame("ʵϰ����");//�½�һ������
        Panel panel = new Panel(null);//���
        frame.setLayout(null);//���ô��岼��

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(0,0,255));//���ñ�����ɫ


        frame.setBounds(50,50,300,300);
        frame.setBackground(new Color(0,255,0));//���ñ�����ɫ

        frame.add(panel);
        frame.setVisible(true);

        //�����¼��������ر��¼�
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("��");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("�ر���");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("�ر���");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("����");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("δ����");
            }
        });

    }
}
