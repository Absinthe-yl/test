package com.test.dao.impl;
import com.test.DB.db;
import com.test.bean.Person;
import com.test.bean.beddata;
import com.test.dao.PersonDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAaoimpl implements PersonDao {
    @Override
    public List<beddata> data(String studentId) throws SQLException {
        System.out.println("成功追到DAO,studentId="+studentId);
        Connection conn = db.getConnection();
        String sql = "select * from beddata where student_Id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, studentId);
        ResultSet rs = ps.executeQuery();//执行语句
        List list = new ArrayList<>();
        while (rs.next()) {
            beddata bd = new beddata();
            bd.setBuilding(rs.getString("Building"));
            bd.setRoom(rs.getString("Room"));
            bd.setBed(rs.getString("Bed"));
            System.out.println(bd.getBuilding());
            list.add(bd);
        }
        rs.close();
        ps.close();
        conn.close();
        return list;
    }

    @Override
    public List<Person> queryAll() throws SQLException {
        Connection connection = db.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students");
        List list = new ArrayList();
        while (resultSet.next()) {
            Person p = new Person();
            p.setId(resultSet.getInt(1));
            p.setName(resultSet.getString(2));
            p.setPwd(resultSet.getString(3));
            list.add(p);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return list;
    }

    @Override
    public boolean selectOne(String studentId, String password) throws SQLException {
        //idd=studentId;
        String sql = "SELECT * FROM students WHERE id = ? AND pwd = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId); //设置第1个？的值
            pstmt.setString(2, password); //设置第2个？的值

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
