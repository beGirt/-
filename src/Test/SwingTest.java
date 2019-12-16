package Test;

import javax.swing.*;

public class SwingTest {
    public static void main(String[] args) {

        Integer i;
        /*
        * 布局管理
        * Frame 最大的窗体 管理方式  边界式 : BorderLayout
        * JMenuBar 菜单条 上面 frame.setJMenuBar(bar);
        * Panel 面板 可以有多个 管理方式: 流式 居中   FlowLayout
        * 组件
        *
        * */


        /*创建一个窗体*/
        JFrame frame = new JFrame("这是我的第一个窗体");
        /*创建一个面板*/
        JPanel jPanel = new JPanel();
        /*创建一个按钮*/
        JButton jButton = new JButton("百度一下");
        /*创建一个文本框*/
        JTextField jTextField = new JTextField(20);
        /*创建一个标签*/
        JLabel jLabel = new JLabel("请输入");

        /*创建复选框*/
        JCheckBox box1 = new JCheckBox("读书");
        JCheckBox box2 = new JCheckBox("唱歌");
        JCheckBox box3 = new JCheckBox("跳舞");


        /*创建单选框*/
        JRadioButton r1 = new JRadioButton("男");
        JRadioButton r2 = new JRadioButton("女");
        ButtonGroup group = new ButtonGroup();      /*加入组*/
        group.add(r1);
        group.add(r2);


        /*创建文本域*/
        JTextArea jTextArea = new JTextArea(5,20);
        /*滚动条*/
        JScrollPane pane = new JScrollPane(jTextArea);


        /*菜单条*/
        /*菜单*/
        /*菜单项*/
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("FILE");
        JMenuItem newItem = new JMenuItem("New");
        menu.add(newItem);
        bar.add(menu);


        /*布局管理*/



        frame.setLocation(500,100);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);  //设置大小不可变

        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jButton);
        jPanel.add(box1);
        jPanel.add(box2);
        jPanel.add(box3);

        jPanel.add(r1);
        jPanel.add(r2);

        jPanel.add(pane);


//        jPanel.add(bar);

        /*菜单条 放在上面*/
        frame.setJMenuBar(bar);

        frame.add(jPanel);


    }
}
