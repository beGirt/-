package org.lsf.view;

import org.lsf.model.Student;
import org.lsf.service.StudentService;
import org.lsf.service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class queryStuFrame extends BaseFrame {

    JPanel mainPanel = new JPanel();
    JPanel panel = new JPanel();

    StudentService studentService = new StudentServiceImpl();


    private JTextArea messageArea = new JTextArea();   /*考试文本域*/
    private JScrollPane messageScroll_Pane = new JScrollPane(messageArea);   /*滚动条*/
    private JTextPane jTextPane = new JTextPane();

    private JLabel nameLabel = new JLabel("姓名:");
    private JTextField nameField = new JTextField();
    private JButton queryButton = new JButton("查询");

    public queryStuFrame(String title){
        super(title);
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    public queryStuFrame() {
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    @Override
    protected void setFontAndSoOn() {

        messageScroll_Pane.setBounds(50,10,600,300);
        messageArea.setEnabled(false);
        messageArea.setFont(new Font("黑体",Font.BOLD,24));

        panel.setBounds(50,400,600,50);
        nameLabel.setBounds(0,0,90,30);
        nameLabel.setFont(new Font("黑体",Font.BOLD,24));

        nameField.setBounds(100,0,200,30);
        nameField.setFont(new Font("黑体",Font.BOLD,24));
        queryButton.setBounds(350,0,90,30);

    }

    @Override
    protected void addElement() {
        mainPanel.setLayout(null);
        panel.setLayout(null);

        mainPanel.add(panel);
        mainPanel.add(messageScroll_Pane);


        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(queryButton);

        this.add(mainPanel);
    }

    @Override
    protected void addListener() {
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                name = name.trim();
                Student student = studentService.queryByName(name);
                if (student != null){
                    messageArea.append("学号：" + student.getStuAccount());
                    messageArea.append("\n姓名：" + student.getStuName());
                    messageArea.append("\n成绩：" + student.getStuScore());
                } else {
                    JOptionPane.showMessageDialog(queryStuFrame.this,"查无此人");
                }
            }
        });
    }

    @Override
    protected void setFrameSelf() {
        /*设置窗体大小*/
//        this.setBounds(750,250,500,340);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        /*设置点击关闭退出程序*/
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        /*设置窗体大小不可拖拽*/
        this.setResizable(false);
        /*设置窗体显示状态*/
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new queryStuFrame("查询学生账号信息");
    }
}
