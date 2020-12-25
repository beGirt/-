package org.lsf.dao.impl;

import static java.sql.DriverManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lsf.dao.StudentDao;
import org.lsf.model.Student;

public class StudentDaoImpl implements StudentDao {

    /*
     * 设置变量
     * JDBC driver name
     * database URL
     */
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://118.31.15.23:3306/DB_Examination?useUnicode=true&characterEncoding=utf8";

    /*
     * 设置用户信息变量
     * USER and PASS
     */
    static final String USER = "lsf";
    static final String PASS = "LSFlsf123";

    public Connection conn = null;
    public PreparedStatement pstmt = null;

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
    /*
        Student student = studentDao.check("1840611623","LSFlsf123");
        System.out.println(student);
    */
//        studentDao.UpdateScore("1840611623",30);
//    studentDao.addStudent(new Student("xhl", "XHLxhl", "徐海林"));
    }

    public Connection connectionToDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = getConnection(DB_URL, USER, PASS);
        return conn;
    }

    @Override
    public Student check(String account, String password) {
        try {
            conn = connectionToDB();

            String sql = "SELECT * FROM tbl_stu where stu_account=? and stu_password=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();

            Student student = null;

            while (resultSet.next()) {
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
    public void UpdateScore(String account, int score) {
        try {
            conn = connectionToDB();
            String sql = "UPDATE tbl_stu SET stu_score = ? WHERE stu_account = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1, score);
            pstmt.setObject(2, account);

            pstmt.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(Student student) {/*简单存储 账号\密码\姓名*/
        try {
            conn = connectionToDB();
            String sql = "INSERT INTO tbl_stu(stu_account,stu_password,stu_name) VALUES (?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, student.getStuAccount());
            pstmt.setObject(2, student.getStuPassword());
            pstmt.setObject(3, student.getStuName());

            pstmt.execute();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentByAccount(String account) {
        if (this.queryStudentByAccount(account) == null) {
            System.out.println("删除失败,查无此人");
        } else {
            try {
                conn = connectionToDB();
                String sql = "DELETE FROM tbl_stu WHERE stu_account = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setObject(1, account);
                pstmt.execute();
                System.out.println("删除成功");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public int deleteStudentById(int stuId) {
        try {
            conn = connectionToDB();
            String sql = "delete from tbl_stu where stu_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, stuId);
            ps.execute();
            int count = ps.getUpdateCount();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void updateStudentByAccount(Student student, String account) {
        try {
            conn = connectionToDB();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student queryStudentByAccount(String account) {
        Student student = null;
        try {
            conn = connectionToDB();
            String sql = "SELECT * FROM tbl_stu WHERE stu_account = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, account);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                student = this.packResultSet(resultSet);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student queryStudentByName(String name) {
        Student student = null;
        try {
            conn = connectionToDB();
            String sql = "SELECT * FROM tbl_stu WHERE stu_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, name);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                student = this.packResultSet(resultSet);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    /*封装结果集中的数据为Student对象*/
    public Student packResultSet(ResultSet resultSet) throws SQLException {
        int stu_id = resultSet.getInt("stu_id");
        String stu_account = resultSet.getString("stu_account");
        String stu_password = resultSet.getString("stu_password");
        String stu_name = resultSet.getString("stu_name");
        String tmp = resultSet.getString("gender");
        boolean gender = false;
        if (tmp.equals("男")) {
            gender = true;
        }
        String PhoneNumber = resultSet.getString("PhoneNumber");
        int score = resultSet.getInt("stu_score");

        return new Student(stu_id, stu_account, stu_password, stu_name, gender, PhoneNumber, score);

    }


}
