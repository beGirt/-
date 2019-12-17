package org.lsf.dao.impl;

import org.lsf.dao.QuestionDao;
import org.lsf.model.Question;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class QuestionDaoImpl implements QuestionDao {

    /*
     * 设置变量
     * JDBC driver name
     * database URL
     */
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:7766/DB_Examination";

    /*
     * 设置用户信息变量
     * USER and PASS
     */
    static final String USER = "root";
    static final String PASS = "LSFlsf123";

    public Connection conn = null;
    public PreparedStatement pstmt = null;
    public Statement stmt = null;

    public Connection connectionToDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = getConnection(DB_URL,USER,PASS);
        return conn;
    }

    @Override
    public List<Question> queryById(int id) {
        return null;
    }

    public List<Question> queryAllQues(){
        try {
            conn = connectionToDB();
            String sql = "select * from tbl_Question";
            stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet resultSet = stmt.getResultSet();
            List<Question> list = new ArrayList<>();
            while (resultSet.next()){
                String ques_id = resultSet.getString("ques_id");
                String ques_stem = resultSet.getString("ques_stem");
                String ques_A = resultSet.getString("ques_A");
                String ques_B = resultSet.getString("ques_B");
                String ques_C = resultSet.getString("ques_C");
                String ques_D = resultSet.getString("ques_D");
                String ques_Correct =resultSet.getString("ques_Correct");
                Question question = new Question(Integer.parseInt(ques_id),ques_stem,ques_A,ques_B,ques_C,ques_D,ques_Correct);


                /*获取题目中的图片信息 ， 没有则设置为null*/
                try {
                    InputStream inputStream = resultSet.getBlob("Picture").getBinaryStream();
                    byte[] b = new byte[1024];
                    int a;

                    while ( (a = inputStream.read(b)) != -1  ){
                    }
                    for (int i = 0;i < 100;i++){
                        System.out.println(b[i]);
                    }
                    question.setPhoto(b);
                } catch (NullPointerException e){
                    question.setPhoto(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                list.add(question);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }

    @Override
    public void updatePicture() {
        try {
            File file = new File("D:\\我的文件_01\\图片\\linux_logo.jpg");
            FileInputStream fi = new FileInputStream(file);


            conn = connectionToDB();
            String sql = "UPDATE tbl_Question SET picture = ? WHERE ques_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,fi);
            pstmt.setObject(2,4);
            /*执行*/
            int f = pstmt.executeUpdate();

            if (f > 0){
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Question> queryByNum(int number) {

        return null;
    }

    public static void main(String[] args) {
        /*QuestionDao questionDao = new QuestionDaoImpl();
        List<Question> list = questionDao.queryAllQues();
        for (Question question:list){
            System.out.println(question);
        }*/
        QuestionDao questionDao = new QuestionDaoImpl();
//        questionDao.updatePicture();
        questionDao.queryAllQues();
    }
}
