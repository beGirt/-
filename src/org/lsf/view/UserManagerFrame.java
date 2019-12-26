package org.lsf.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserManagerFrame extends BaseFrame{

    JPanel mainPanel = new JPanel();
    JButton addButton = new JButton("添加学生");
    JButton deleteButton = new JButton("删除学生");
    JButton updateButton = new JButton("修改学生");
    JButton queryButton = new JButton("查询学生");
    public UserManagerFrame(){
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    public UserManagerFrame(String title){
        super(title);
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    @Override
    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);

        addButton.setBounds(94,10,300,50);
        deleteButton.setBounds(94,70,300,50);
        updateButton.setBounds(94,130,300,50);
        queryButton.setBounds(94,190,300,50);

    }

    @Override
    protected void addElement() {

        mainPanel.add(addButton);
        mainPanel.add(deleteButton);
        mainPanel.add(updateButton);
        mainPanel.add(queryButton);
        this.add(mainPanel);
    }

    @Override
    protected void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addStuFrame("添加学生信息界面");
            }
        });
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new queryStuFrame("查询学生信息界面");
            }
        });
    }

    @Override
    protected void setFrameSelf() {
        /*设置窗体大小*/
//        this.setBounds(750,250,500,340);
        this.setSize(500,340);
        this.setLocationRelativeTo(null);
        /*设置点击关闭退出程序*/
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*设置窗体大小不可拖拽*/
        this.setResizable(false);
        /*设置窗体显示状态*/
        this.setVisible(true);
    }

    public static void main(String[] args) {
        UserManagerFrame userManager = new UserManagerFrame("学生管理界面");
    }
}
