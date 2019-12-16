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
    public boolean check() {
        return false;
    }

    @Override
    public Student queryByAccount(String account) {
        try {
            conn = connectionToDB();

            String sql = "SELECT * FROM tbl_stu where stu_account=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,account);

            ResultSet resultSet = pstmt.executeQuery();

            Student student = new Student();

            while (resultSet.next()){
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

    public Connection connectionToDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = getConnection(DB_URL,USER,PASS);
        return conn;
    }

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.queryByAccount("1840611623");
        System.out.println(student);
    }

}
