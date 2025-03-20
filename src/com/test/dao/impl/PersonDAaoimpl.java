package com.test.dao.impl;
import com.test.DB.db;
import com.test.bean.Person;
import com.test.dao.PersonDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAaoimpl implements PersonDao {
    @Override
    public List<Person> queryAll() throws SQLException {
        Connection connection = db.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from person");
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
