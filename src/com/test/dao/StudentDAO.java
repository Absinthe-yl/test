package com.test.dao;
import com.test.model.Student;
import com.test.util.DBUtil;
import java.sql.*;

public class StudentDAO {
    public Student findStudent(String studentId, String password) {
        String sql = "SELECT * FROM students WHERE student_id = ? AND password = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentId); //设置第1个？的值
            pstmt.setString(2, password); //设置第2个？的值

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getString("student_id"),
                        rs.getString("name"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}