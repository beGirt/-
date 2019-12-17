package Test.com.lsf;

import java.io.*;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class DB_Test {
    /*
     * 设置变量
     * JDBC driver name
     * database URL
     */
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:7766/TEST";

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

    public void InsertPictureTest(){
        try {
            File file = new File("D:\\我的文件_01\\图片\\头像1.jpg");
            FileInputStream fi = new FileInputStream(file);

            conn = connectionToDB();
            String sql = "UPDATE user SET picture = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,fi);
            pstmt.setObject(2,1);
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

    public void getPictureTest(){
        try {
            conn = connectionToDB();

            String sql = "SELECT * FROM user WHERE id = 1";
            pstmt = conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            Blob blob = null;
            while (resultSet.next()){
                blob = resultSet.getBlob("picture");
            }

            byte b[] = new byte[1014];

            try {
                InputStream inputStream =  blob.getBinaryStream();

                int a = 0;
                while ( (a = inputStream.read(b)) != -1  ){
                }
                for (int i = 0;i < 100;i++) {
                    System.out.print(b[i] + " ");
                }
            } catch (NullPointerException e){
                System.out.println("没有图片");
            }

            if (b.equals(null)){
                System.out.println("没有图片");
            } else {
                System.out.println("读取成功");
            }

            /*

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\我的文件_01\\图片2\\photo1.jpg");
            int a;
            while ((a = inputStream.read(b)) != -1) {
                fileOutputStream.write(b, 0, a);
            }

            */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DB_Test db_test = new DB_Test();
//        db_test.InsertPictureTest();
        db_test.getPictureTest();
    }
}
