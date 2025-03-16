package com.test.util;
import java.sql.*;
//数据库连接
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/school_welcome?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "cjl";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//1.驱动mysql
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);//2.通过DriverManager创建连接
    }
    //Connection connectiom=DriverManager.gerConnection

    public static void close(Connection conn, Statement stmt, ResultSet rs) {  //Statement静态sql
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}