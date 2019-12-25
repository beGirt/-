package org.lsf.view;

import org.lsf.Controller.ExamController;
import org.lsf.model.PageMessage;
import org.lsf.model.Question;
import org.lsf.service.StudentService;
import org.lsf.service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExamFrame extends BaseFrame {

    private ExamController examController = new ExamController();
    private StudentService studentService = new StudentServiceImpl();
    private String account;

    /*用于控制时间,以秒为单位*/
    private int time = 60;

    private String[] answers;       /*答案数组下标从0开始*/
    private int score;

    public ExamFrame() {
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
        this.init();
    }

    public ExamFrame(String title) {
        super(title);
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();

        /*构建初始化页面中的数据*/
        this.init();
    }


    public ExamFrame(String title, String account){
        this(title);
        this.account = account;
    }

    private TimeController timeController = new TimeController();

    /*添加三个 JPanel 面板进行布局的分割*/
    private JPanel mainPanel = new JPanel();        /*负责问题的展示*/
    private JPanel messagePanel = new JPanel();     /*负责右侧信息的展示*/
    private JPanel buttonPanel = new JPanel();      /*负责下侧按钮的展示*/

    /*添加各种组件*/
    /*
    * mainPanel部分
    * */
    private JTextArea examArea = new JTextArea();   /*考试文本域*/
    private JScrollPane examScroll_Pane = new JScrollPane(examArea);   /*滚动条*/

    /*
    * messagePanel部分
    * */
    private JLabel pictureLabel = new JLabel();         /*显示图片*/

    private JLabel currentNumLabel = new JLabel("当前题号：");     /*当前题号*/
    private JTextField currentNumField = new JTextField();

    private JLabel totalCountLabel = new JLabel("总题数：");         /*总题数*/
    private JTextField totalCountField = new JTextField();

    private JLabel finishedLabel = new JLabel("已答题数：");         /*已答题数*/
    private JTextField finishedField = new JTextField();

    private JLabel unfinishedLabel = new JLabel("未答题数：");       /*未答题数*/
    private JTextField unfinishedField = new JTextField();

    private JLabel timeLabel = new JLabel("剩余答题时间：");       /*提示剩余时间*/
    private JLabel realTimeLabel = new JLabel("00:00:00");

    /*
    * buttonPanel部分
    * */
    private JButton aButton = new JButton("A");
    private JButton bButton = new JButton("B");
    private JButton cButton = new JButton("C");
    private JButton dButton = new JButton("D");

    private JButton preButton = new JButton("上一题");
    private JButton nextButton = new JButton("下一题");
    private JButton submitButton = new JButton("提交");


    @Override
    protected void setFontAndSoOn() {
        /*
        * 设置Panel布局管理为自定义
        * */
        mainPanel.setLayout(null);
        messagePanel.setLayout(null);
        buttonPanel.setLayout(null);

        /*设置面板的布局*/
        messagePanel.setBounds(680,10,300,550);
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        buttonPanel.setBounds(16,470,650,90);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        /*
        * */
        mainPanel.setBackground(Color.WHITE);
/*
        mainPanel.setBounds(16,10,650,450);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.red));
*/

        /*
        * 文本域 滚动条相关*/
        examScroll_Pane.setBounds(16,10,650,450);
        examArea.setFont(new Font("黑体",Font.BOLD,25));
        examArea.setEnabled(false);         /*文本域不可编辑*/
        examScroll_Pane.setBackground(Color.WHITE);
        examArea.setBackground(Color.WHITE);
        examScroll_Pane.setForeground(Color.black);
//        examScroll_Pane.setForeground(Color.blue);

        /*
        * message区域
        * */
        /*
        * 图片布局*/
        pictureLabel.setBounds(10,10,280,230);
        pictureLabel.setBorder(BorderFactory.createLineBorder(Color.black));

        /*
        * */
        currentNumLabel.setBounds(40,270,120,30);
        currentNumLabel.setFont(new Font("黑体",Font.BOLD,20));
        currentNumField.setBounds(170,270,100,30);
        currentNumField.setFont(new Font("黑体",Font.BOLD,20));
        currentNumField.setHorizontalAlignment(JTextField.CENTER);
        currentNumField.setEnabled(false);

        /*
        * */
        totalCountLabel.setBounds(40,310,120,30);
        totalCountLabel.setFont(new Font("黑体",Font.BOLD,20));
        totalCountField.setBounds(170,310,100,30);
        totalCountField.setFont(new Font("黑体",Font.BOLD,20));
        totalCountField.setHorizontalAlignment(JTextField.CENTER);
        totalCountField.setEnabled(false);

        /*
        * */
        finishedLabel.setBounds(40,350,120,30);
        finishedLabel.setFont(new Font("黑体",Font.BOLD,20));
        finishedField.setBounds(170,350,100,30);
        finishedField.setFont(new Font("黑体",Font.BOLD,20));
        finishedField.setHorizontalAlignment(JTextField.CENTER);
        finishedField.setEnabled(false);

        unfinishedLabel.setBounds(40,390,120,30);
        unfinishedLabel.setFont(new Font("黑体",Font.BOLD,20));
        unfinishedField.setBounds(170,390,100,30);
        unfinishedField.setFont(new Font("黑体",Font.BOLD,20));
        unfinishedField.setHorizontalAlignment(JTextField.CENTER);            /*设置字体居中*/
        unfinishedField.setEnabled(false);
        timeLabel.setBounds(90,460,150,30);
        timeLabel.setFont(new Font("黑体",Font.BOLD,20));
        realTimeLabel.setBounds(108,490,150,30);
        realTimeLabel.setFont(new Font("黑体",Font.BOLD,20));
        realTimeLabel.setForeground(Color.blue);
        /*
        * */
        aButton.setBounds(40,10,120,30);
        bButton.setBounds(190,10,120,30);
        cButton.setBounds(340,10,120,30);
        dButton.setBounds(490,10,120,30);

        preButton.setBounds(40,50,100,30);
        nextButton.setBounds(510,50,100,30);
        submitButton.setBounds(276,50,100,30);
        submitButton.setForeground(Color.red);

    }

    @Override
    protected void addElement() {


        /*
        * messagePanel的添加
        * */
        messagePanel.add(pictureLabel);
        messagePanel.add(currentNumLabel);
        messagePanel.add(currentNumField);
        messagePanel.add(totalCountLabel);
        messagePanel.add(totalCountField);
        messagePanel.add(finishedLabel);
        messagePanel.add(finishedField);
        messagePanel.add(unfinishedLabel);
        messagePanel.add(unfinishedField);
        messagePanel.add(timeLabel);
        messagePanel.add(realTimeLabel);
        /*
        * buttonPanel的添加
        * */
        buttonPanel.add(aButton);
        buttonPanel.add(bButton);
        buttonPanel.add(cButton);
        buttonPanel.add(dButton);
        buttonPanel.add(preButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(submitButton);
        /*
         * mainPanel的添加
         * */
        mainPanel.add(buttonPanel);
        mainPanel.add(examScroll_Pane);
        mainPanel.add(messagePanel);

        this.add(mainPanel);

    }

    @Override
    protected void addListener() {
        ActionListener pageButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jButton = (JButton) e.getSource();

                int i;

                if (jButton.getText().equals("上一题")){
                    i = Integer.parseInt(currentNumField.getText()) - 1;
                } else if (jButton.getText().equals("下一题")){
                    i = Integer.parseInt(currentNumField.getText()) + 1;
                } else {
                    i = 1;
                }

                PageMessage pageMessage = examController.toPage(i);
                ExamFrame.this.showPageMsg( pageMessage, i );
                showChoice();
            }
        };
        ActionListener optionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExamFrame.this.clear_OP_Button();
                JButton jButton = (JButton) e.getSource();      /*可获取到调用事件的源对象*/
                jButton.setBackground(Color.yellow);
                int num = Integer.parseInt(currentNumField.getText());
                answers[num-1] = jButton.getText();
            }
        };
        nextButton.addActionListener(pageButton);
        preButton.addActionListener(pageButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(ExamFrame.this,"确认提交?");
                if (response == 0){
                    int score = ExamFrame.this.checkAnswer();

                    /*
                    * 存储学生成绩到数据库*/
                    studentService.UpdateStuScore(account,score);
                    //                        Thread.sleep(200);
                    // 发出中断线程信号
                    timeController.interrupt();


                    /*判断是否及格*/
                    if (score >= answers.length * 10 * 0.6){
                        JOptionPane.showMessageDialog(ExamFrame.this,"你及格了");
                    }

                    /*显示提示信息*/
                    JOptionPane.showMessageDialog(ExamFrame.this,account+"提交成功,成绩为:"+score);


                    ExamFrame.this.setVisible(false);
                    System.exit(0);
                }
            }
        });
        aButton.addActionListener(optionListener);
        bButton.addActionListener(optionListener);
        cButton.addActionListener(optionListener);
        dButton.addActionListener(optionListener);

    }

    @Override
    protected void setFrameSelf() {
        /*设置布局*/
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        /*设置点击关闭退出程序*/
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*设置窗体大小不可拖拽*/
        this.setResizable(false);
        /*设置窗体显示状态*/
        this.setVisible(true);

        /*计时器启动*/
        timeController.start();
//        timeController.run();

    }

    /*设计一个内部类,用于控制时间的变化*/
    private class TimeController extends Thread{
        @Override
        public void run() {
            int hour = time/60;
            int minute = time%60;
            int second = 0;
            String time_string = ExamFrame.this.showTime(hour,minute,second);

            while (!this.isInterrupted()){
                /*展示时间*/
                realTimeLabel.setText(time_string);
//                System.out.println(time_string);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    this.interrupt();
                }


                /*更改时间*/
                time_string = ExamFrame.this.changeTime(hour,minute,second);

                /*剩下三十秒时显示红色*/
                if (hour == 0 && minute == 0 && second < 30){
                    realTimeLabel.setForeground(Color.red);
                }

                if (time_string == null){/*倒计时结束*/

                    JOptionPane.showMessageDialog(ExamFrame.this,"时间用完了,请交卷");
                    int score = ExamFrame.this.checkAnswer();
                    /*
                     * 存储学生成绩到数据库*/
                    studentService.UpdateStuScore(account,score);

                    /*显示提示信息*/
                    JOptionPane.showMessageDialog(ExamFrame.this,account+"提交成功,成绩为:"+score);
                    ExamFrame.this.setVisible(false);
                    System.exit(0);

                    break;
                }

                int a[] = ExamFrame.this.parseTime(time_string);
                hour = a[0];
                minute = a[1];
                second = a[2];


                if(Thread.currentThread().isInterrupted()) {
//                    System.out.println("The thread is interrupted!");
                    break;
                }

            }
        }
    }

    /**
     * 初始化页面*/
    protected void init(){
        int size = examController.getQuestions().size();        /*问题总数*/
        answers = new String[size];         /*设置答案存储的String数组*/


        currentNumField.setText( String.valueOf(1) );
        totalCountField.setText( String.valueOf(size) );
        finishedField.setText( String.valueOf(0) );
        unfinishedField.setText( String.valueOf(size) );


        PageMessage pageMessage = examController.toPage(1);
        ExamFrame.this.showPageMsg(pageMessage,1);

        /*设置初始时间*/
        realTimeLabel.setText(String.valueOf(time));

    }

    /**
    * 展示分页信息
     */
    public void showPageMsg(PageMessage pageMessage,int i){

        int count = 0;

        for (String s : answers){
            if (s!=null){
                count++;
            }
        }
        finishedField.setText(String.valueOf(count));
        int unfinishedCount = Integer.parseInt(totalCountField.getText()) - count;
        unfinishedField.setText(String.valueOf(unfinishedCount));

        if (pageMessage.getCode() == 100){
            emptyAll();     /*清空数据*/

            finishedField.setText(String.valueOf(count));
            unfinishedField.setText(String.valueOf(unfinishedCount));

            Question question = (Question)pageMessage.getExtend().get("Question");
            examArea.append(i + "." + question.getQuesStem());
            examArea.append("\n\nA:" + question.getQuesA());
            examArea.append("\n\nB:" + question.getQuesB());
            examArea.append("\n\nC:" + question.getQuesC());
            examArea.append("\n\nD:" + question.getQuesD());
            currentNumField.setText(String.valueOf(i));
            /*如果有图片 则展示图片*/
            if (question.getPhoto() != null) {

                byte[] b = question.getPhoto();         /*从对象中获取 二进制数组 表示的图片*/
                ImageIcon imageIcon = new ImageIcon(b); /*调用参数为byte[] 的构造方法*/

                /*设置图片的布局格式*/
                imageIcon.setImage( imageIcon.getImage().getScaledInstance(280,230,Image.SCALE_DEFAULT) );

                /*添加imageIcon到Label组件上*/
                pictureLabel.setIcon(imageIcon);
            }


        } else if (pageMessage.getCode() == 300){
            JOptionPane.showMessageDialog(ExamFrame.this,"没有下一题了");
        } else {
            JOptionPane.showMessageDialog(ExamFrame.this,"没有上一题了");
        }

        /*实现图片的展示*/

    }

    /**
     * 清空页面数据 */
    public void emptyAll(){
        examArea.setText("");
        currentNumField.setText("");
        finishedField.setText("");
        unfinishedField.setText("");
        pictureLabel.setIcon(null);
        clear_OP_Button();
    }

    /**
     * 清理 选项按钮 上的属性
     */
    public void clear_OP_Button(){
        aButton.setBackground(null);
        bButton.setBackground(null);
        cButton.setBackground(null);
        dButton.setBackground(null);
    }

    /**
     * 计算成绩*/
    public int checkAnswer(){
        List<Question> list = examController.getQuestions();

        int count = 0;


        this.score = 0;
        while (count < answers.length){
            String correct = list.get(count).getQuesCorrect();

            try {
                if (answers[count].equals(correct)){
                    this.score += 10;
                }
            } catch (NullPointerException e){
                this.score += 0;
            }


            count++;
        }

        return this.score;
    }

    /**
    * 显示当前题目选择过的答案*/
    public void showChoice(){
        String answer = answers[Integer.parseInt(currentNumField.getText()) - 1];
        try {
            switch (answer) {
                case "A":
                    aButton.setBackground(Color.yellow);
                    break;
                case "B":
                    bButton.setBackground(Color.yellow);
                    break;
                case "C":
                    cButton.setBackground(Color.yellow);
                    break;
                case "D":
                    dButton.setBackground(Color.yellow);
                    break;
                default:
                    break;
            }
        } catch (NullPointerException e){

        }
    }

    public String changeTime(Integer hour,Integer minute,Integer second){
        if (second > 0){
            second--;
        } else {
            if (minute > 0){
                minute--;
                second = 59;
            } else {
                if (hour > 0){
                    hour--;
                    minute = 59;
                    second = 59;
                } else {
                    return null;
                }
            }
        }
        return showTime(hour,minute,second);
    }

    /*转化为XX:XX:XX的格式*/
    public String showTime(int hour,int minute,int second){      /*time 是以分钟为单位的*/
        /*转换为 小时:分钟:秒*/
        /*拼串*/
        StringBuilder result = new StringBuilder();
        if (hour >= 0 && hour < 10){
            result.append("0");
        }
        result.append(hour);
        result.append(":");

        if (minute >= 0 && minute < 10){
            result.append("0");
        }
        result.append(minute);
        result.append(":");

        if (second >= 0 && second < 10){
            result.append("0");
        }
        result.append(second);
        return result.toString();
    }

    /*解析time字符串*/
    public int[] parseTime(String time){
        String[] s = time.split(":");
        int hour = Integer.parseInt(s[0]);
        int minute = Integer.parseInt(s[1]);
        int second = Integer.parseInt(s[2]);
        int[] a = {hour,minute,second};
        return a;

    }


    public static void main(String[] args) {
        ExamFrame examFrame = new ExamFrame("考试页面");
    }

}
