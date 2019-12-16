package org.lsf.view;

import org.lsf.Controller.ExamController;
import org.lsf.model.PageMessage;
import org.lsf.model.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExamFrame extends BaseFrame {

//    private QuestionService questionService = new QuestionServiceImpl();
    private ExamController examController = new ExamController();

    private String[] answers;
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
        mainPanel.setBackground(Color.LIGHT_GRAY);
/*
        mainPanel.setBounds(16,10,650,450);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.red));
*/

        /*
        * 文本域 滚动条相关*/
        examScroll_Pane.setBounds(16,10,650,450);
        examArea.setFont(new Font("黑体",Font.BOLD,25));
        examArea.setEnabled(false);         /*文本域不可编辑*/


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
//        ExamController examController = new ExamController();



        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = Integer.parseInt(currentNumField.getText()) + 1;

                PageMessage pageMessage = examController.toPage(i);
                ExamFrame.this.showPageMsg(pageMessage,i);
            }
        });

        preButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = Integer.parseInt(currentNumField.getText()) - 1;
                PageMessage pageMessage = examController.toPage(i);
                ExamFrame.this.showPageMsg( pageMessage, i );
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(ExamFrame.this,"确认提交?");
                if (response == 0){
                    int score = ExamFrame.this.checkAnswer();

                    /*存储学生成绩到数据库*/

                    JOptionPane.showMessageDialog(ExamFrame.this,"提交成功,成绩为:"+score);
                    ExamFrame.this.setVisible(false);
                }
            }
        });
//        aButton.addActionListener();

//        submitButton.addActionListener();

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

        aButton.addActionListener(optionListener);
        bButton.addActionListener(optionListener);
        cButton.addActionListener(optionListener);
        dButton.addActionListener(optionListener);


    }
    protected void init(){
        int size = examController.getQuestions().size();        /*问题总数*/
        answers = new String[size];         /*设置答案存储的String数组*/


        currentNumField.setText( String.valueOf(1) );
        totalCountField.setText( String.valueOf(size) );
        finishedField.setText( String.valueOf(0) );
        unfinishedField.setText( String.valueOf(size) );


        PageMessage pageMessage = examController.toPage(1);
        ExamFrame.this.showPageMsg(pageMessage,1);

    }


    /*展示分页信息*/
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


/*
            finishedField.setText(String.valueOf(i));

            unfinishedField.setText( String.valueOf( Integer.parseInt(totalCountField.getText()) - i ) );*/
        } else if (pageMessage.getCode() == 300){
            int response = JOptionPane.showConfirmDialog(ExamFrame.this,"已经没有题了,是否提交");
            if (response == 0){
                JOptionPane.showMessageDialog(ExamFrame.this,"提交成功");
            }
        } else {
            JOptionPane.showMessageDialog(ExamFrame.this,"没有上一题");
        }



    }

    /* 清空页面数据 */
    public void emptyAll(){
        examArea.setText("");
        currentNumField.setText("");
        finishedField.setText("");
        unfinishedField.setText("");
        clear_OP_Button();
    }

    public void clear_OP_Button(){
        aButton.setBackground(null);
        bButton.setBackground(null);
        cButton.setBackground(null);
        dButton.setBackground(null);
    }

    /*计算成绩*/
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
    }

/*    public void toPage(List<Question> questions,int i){

        if (i>=questions.size()){
            int response = JOptionPane.showConfirmDialog(ExamFrame.this,"已经没有题了,是否提交");
            if (response == 0){
                JOptionPane.showMessageDialog(ExamFrame.this,"提交成功");
            }
            return;
        }

        if (i < 0){
            JOptionPane.showMessageDialog(ExamFrame.this,"没有上一题");
            return;
        }

        this.emptyAll();

        Question question = questions.get(i);
        examArea.append(i + 1 + "." + question.getQuesStem());
        examArea.append("\n\nA:" + question.getQuesA());
        examArea.append("\n\nB:" + question.getQuesB());
        examArea.append("\n\nC:" + question.getQuesC());
        examArea.append("\n\nD:" + question.getQuesD());

        currentNumField.setText(String.valueOf(i+1));

        finishedField.setText(String.valueOf(i));

        unfinishedField.setText(String.valueOf(questions.size() - i));
    }*/



    public static void main(String[] args) {
        ExamFrame examFrame = new ExamFrame("考试页面");
    }
}