import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*实现10 进制  -- > 十六进制 二进制*/
public class TestSwing {

    public static void main(String[] args) {
        JFrame exercise6_1 = new JFrame("Exercise6_1");
        exercise6_1.setVisible(true);
        exercise6_1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        exercise6_1.setSize(400,400);
        exercise6_1.setLocation(500,300);

        JPanel jPanel = new JPanel();
        /*columns 为 占用的*/
        JTextField t1 = new JTextField(10);
        JTextField t2 = new JTextField(10);
        JTextField t3 = new JTextField(10);

        t1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                t2.setText(Integer.toHexString(a));
                t3.setText(Integer.toBinaryString(a));
            }
        });



        JLabel jl1 = new JLabel("十进制");
        JLabel jl2 = new JLabel("十六进制");
        JLabel jl3 = new JLabel("二进制");

        jPanel.add(jl1);
        jPanel.add(t1);
        jPanel.add(jl2);
        jPanel.add(t2);
        jPanel.add(jl3);
        jPanel.add(t3);


        exercise6_1.add(jPanel);

    }
}
