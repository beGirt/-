import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class TableView extends JTable {
    private ArrayList<Person> list;
    public TableView(){

    }

    public static void main(String[] args) {
        JFrame exercise6_1 = new JFrame("Exercise6_1");
        exercise6_1.setVisible(true);
        exercise6_1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        exercise6_1.setSize(400,400);
        exercise6_1.setLocation(500,300);

//        TableView tableView = new TableView();

        JTable jTable = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();

        /*表头创建*/
        tableModel.addColumn("姓名");
        tableModel.addColumn("职业");
        tableModel.addColumn("Email");

        //Person p1 = new Person("张三","白领","zhangsan@163.com");
       /* Object[] list = new Person[1];
        list[0] = new Person("张三","白领","zhangsan@163.com");
*/

        Object[] list = {"张三","白领","zhangsan@163.com"};
        tableModel.addRow(list);

        JPanel jPanel = new JPanel();

        JScrollPane jScrollPane = new JScrollPane(jTable);

        jPanel.add(jScrollPane);

        exercise6_1.add(jPanel);

    }

}
