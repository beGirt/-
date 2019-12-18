package org.lsf.dao.impl;

import org.lsf.dao.StudentDao;
import org.lsf.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class StudentDaoImpl implements StudentDao {

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



    @Override
    public Student check(String account,String password) {
        try {
            conn = connectionToDB();

            String sql = "SELECT * FROM tbl_stu where stu_account=? and stu_password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,account);
            pstmt.setString(2,password);

            ResultSet resultSet = pstmt.executeQuery();

            Student student = null;

            while (resultSet.next()){
                student = new Student();
                student.setStuAccount(resultSet.getString("stu_account"));
                student.setStuPassword(resultSet.getString("stu_password"));
            }

            return student;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void UpdateScore(String account,int score) {
        try {
            conn = connectionToDB();
            String sql = "UPDATE tbl_stu SET stu_score = ? WHERE stu_account = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1,score);
            pstmt.setObject(2,account);

            pstmt.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection connectionToDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = getConnection(DB_URL,USER,PASS);
        return conn;
    }



    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
    /*
        Student student = studentDao.check("1840611623","LSFlsf123");
        System.out.println(student);
    */
        studentDao.UpdateScore("1840611623",30);
    }

}
