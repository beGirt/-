package org.lsf.view;

import org.lsf.model.Student;
import org.lsf.service.StudentService;
import org.lsf.service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerFrame extends BaseFrame {

    public ManagerFrame(String title){
        super(title);
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    StudentService studentService = new StudentServiceImpl();


    private JPanel mainPanel = new JPanel();

    private JLabel accountLabel = new JLabel("账号:");
    private JLabel passwordLabel = new JLabel("密码:");
    private JLabel nameLabel = new JLabel("名字:");

    private JTextField accountField = new JTextField();
    private JTextField passwordField = new JTextField();
    private JTextField nameField = new JTextField();

    private JButton insertButton = new JButton("插入");


    public ManagerFrame(){
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }


    @Override
    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);

        nameLabel.setBounds(94,74,90,30);
        nameLabel.setFont(new Font("黑体",Font.BOLD,24));
        nameField.setBounds(204,74,260,30);
        nameField.setFont(new Font("黑体",Font.BOLD,24));
        accountLabel.setBounds(94,124,90,30);
        accountLabel.setFont(new Font("黑体",Font.BOLD,24));
        accountField.setBounds(204,124,260,30);
        accountField.setFont(new Font("黑体",Font.BOLD,24));
        passwordLabel.setBounds(94,174,90,30);
        passwordLabel.setFont(new Font("黑体",Font.BOLD,24));
        passwordField.setBounds(204,174,260,30);
        passwordField.setFont(new Font("黑体",Font.BOLD,24));

        insertButton.setBounds(240,214,90,30);
    }

    @Override
    protected void addElement() {
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(insertButton);
        this.add(mainPanel);
    }

    @Override
    protected void addListener() {
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String account = accountField.getText();
                String password = passwordField.getText();

                /*正则表达式进行格式校验*/
                boolean b1 = name.matches("[\\u2E80-\\u9FFF]{2,5}");
                boolean b2 = account.matches("[0-9]{10}");
                boolean b3 = password.matches("[a-zA-Z0-9_-]{6,18}");
                if (!b1){
                    JOptionPane.showMessageDialog(ManagerFrame.this,"姓名格式不正确,需要 2-5 个中文字符");
                    return;
                }
                if (!b2){
                    JOptionPane.showMessageDialog(ManagerFrame.this,"账号格式不正确,需要10位数字");
                    return;
                }
                if (!b3){
                    JOptionPane.showMessageDialog(ManagerFrame.this,"密码格式不正确");
                    return;
                }

//                System.exit(-1);

                Student student = new Student(account,password,name);
                if (studentService.insertStudent(student) == true){
                    JOptionPane.showMessageDialog(ManagerFrame.this,"插入成功");
                    emptyAll();
                } else {
                    JOptionPane.showMessageDialog(ManagerFrame.this,"插入失败!!!该账号已存在");
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

    public void emptyAll(){
        accountField.setText("");
        passwordField.setText("");
        nameField.setText("");
    }

    public static void main(String[] args) {
        ManagerFrame managerFrame = new ManagerFrame("添加学生信息界面");
    }
}
