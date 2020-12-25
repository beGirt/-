package org.lsf.view;

import org.lsf.service.StudentService;
import org.lsf.service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteStuFrame extends BaseFrame {

    StudentService studentService = new StudentServiceImpl();

    private JPanel mainPanel = new JPanel();

    private JLabel idLabel = new JLabel("ID:");
    private JTextField idField = new JTextField();

    private JButton deleteButton = new JButton("删除");

    public deleteStuFrame(String title) {
        super(title);
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    public deleteStuFrame() {
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    @Override
    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);

        idLabel.setBounds(94, 74, 90, 30);
        idLabel.setFont(new Font("黑体", Font.BOLD, 24));
        idField.setBounds(204, 74, 260, 30);
        idField.setFont(new Font("黑体", Font.BOLD, 24));
        deleteButton.setBounds(240, 214, 90, 30);
    }

    @Override
    protected void addElement() {
        mainPanel.add(idLabel);
        mainPanel.add(idField);
        mainPanel.add(deleteButton);
        this.add(mainPanel);
    }

    @Override
    protected void addListener() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int id = Integer.parseInt(idField.getText());
                int i = studentService.deleteById(id);
                if (i > 0) {
                    JOptionPane.showMessageDialog(deleteStuFrame.this, "删除成功");
                } else {
                    JOptionPane.showMessageDialog(deleteStuFrame.this, "删除失败");
                }
            }
        });
    }

    @Override
    protected void setFrameSelf() {
        /*设置窗体大小*/
//        this.setBounds(750,250,500,340);
        this.setSize(500, 340);
        this.setLocationRelativeTo(null);
        /*设置点击关闭退出程序*/
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        /*设置窗体大小不可拖拽*/
        this.setResizable(false);
        /*设置窗体显示状态*/
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new deleteStuFrame("删除页面");
    }
}
