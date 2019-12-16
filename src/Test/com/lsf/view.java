package Test.com.lsf;

import javax.swing.*;
import java.awt.*;

public class view {
    public static void main(String[] args) {
        JFrame frame = new JFrame("登录界面");

        JPanel mainPanel = new JPanel();
        /*标题*/
        JLabel titleLabel = new JLabel("在 线 考 试 系 统");
        /*账号输入框*/
        JLabel accountLabel = new JLabel("账 号：");
        JTextField accountField = new JTextField();
        /*密码输入框*/
        JLabel passwordLabel = new JLabel("密 码：");
        JPasswordField passwordField = new JPasswordField();
        /*登录和退出按钮*/
        JButton loginButton = new JButton("登 录");
        JButton exitButton = new JButton("退 出");


        mainPanel.setLayout(null);
        /*
        * 设置组件格式 布局
        * */
        /*标题*/
        titleLabel.setBounds(120,40,340,35);
        titleLabel.setFont(new Font("黑体",Font.BOLD,34));

        /*账号框*/
        accountLabel.setBounds(94,124,90,30);
        accountLabel.setFont(new Font("黑体",Font.BOLD,24));
        accountField.setBounds(204,124,260,30);
        accountField.setFont(new Font("黑体",Font.BOLD,24));
        /*密码框*/
        passwordLabel.setBounds(94,174,90,30);
        passwordLabel.setFont(new Font("黑体",Font.BOLD,24));
        passwordField.setBounds(204,174,260,30);
        passwordField.setFont(new Font("黑体",Font.BOLD,24));

        passwordField.setEchoChar('*');     /*设置密码框显示的样式*/
        /*俩个按钮*/
        loginButton.setBounds(154,232,100,30);
        loginButton.setFont(new Font("黑体",Font.BOLD,22));
        exitButton.setBounds(304,232,100,30);
        exitButton.setFont(new Font("黑体",Font.BOLD,22));




        mainPanel.add(titleLabel);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(exitButton);

        frame.add(mainPanel);
        frame.setBounds(500,250,500,340);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
