package org.lsf.view;

import org.lsf.service.StudentService;
import org.lsf.service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends BaseFrame{
    StudentService studentService = new StudentServiceImpl();


    private JPanel mainPanel = new JPanel();
    /*标题*/
    private JLabel titleLabel = new JLabel("在 线 考 试 系 统");
    /*账号输入框*/
    private JLabel accountLabel = new JLabel("账号");
    private JTextField accountField = new JTextField();
    /*密码输入框*/
    private JLabel passwordLabel = new JLabel("密码");
    private JPasswordField passwordField = new JPasswordField();
    /*登录和退出按钮*/
    private JButton loginButton = new JButton("登录");
    private JButton exitButton = new JButton("退出");


    public LoginFrame(){
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    public LoginFrame(String title){
        super(title);
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    @Override
    protected void setFontAndSoOn() {
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



    }

    @Override
    protected void addElement() {
        mainPanel.add(titleLabel);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(exitButton);

        this.add(mainPanel);
    }

    @Override
    protected void addListener() {
        /*
        * 绑定登录按钮的单击事件
        * */
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                * 获取用户输入的账号和密码
                * */
                String account = accountField.getText();
                char[] tmp = passwordField.getPassword();
                String password = new String(tmp);

                /*
                * 业务逻辑,
                * 如果登录成功,跳转到考试页面
                * 如果登录失败,弹出警告框
                * */
                String result = studentService.Login(account,password);
                if (result.equals("登录成功")){
//                    JOptionPane.showMessageDialog(LoginFrame.this,"即将进入考试,请做好准备!!!");
                    /*实现跳转*/
                    int response = JOptionPane.showConfirmDialog(LoginFrame.this,"确定进入考试?");
                    if (response == 0) {
                        LoginFrame.this.setVisible(false);  /*登录窗口隐藏 反射机制*/
                        new ExamFrame("考试页面",account);
                    } else {
                        accountField.setText("");
                        passwordField.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this,result);
                    accountField.setText("");
                    passwordField.setText("");
                }
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
        LoginFrame loginFrame = new LoginFrame("在线考试系统");
    }
}
