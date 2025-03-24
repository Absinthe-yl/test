package com.test.dao.impl;
import com.test.bean.Class;
import com.test.bean.beddata;
import com.test.dao.PersonDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.test.DB.db.getConnection;

public class PersonDaoimpl implements PersonDao {
    @Override
    public boolean selectOneRoot(String Id, String password) throws SQLException {
        String sql = "SELECT * FROM root WHERE id = ? AND pwd = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Id); //设置第1个？的值
            pstmt.setString(2, password); //设置第2个？的值
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("成功");
                return true;
            } else {
                System.out.println("失败");
                return false;
            }
        }
    }


    @Override
    public List<beddata> data(String studentId) throws SQLException {
        System.out.println("成功追到DAO,studentId=" + studentId);
        Connection conn = getConnection();
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
    public List<Class> classData(String studentId) throws SQLException {
        Connection conn = getConnection();
        System.out.println("执行语句没问题,studentId=" + studentId);
        String sql = "select * from class where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, studentId);
        ResultSet rs = ps.executeQuery();//执行语句
        List list = new ArrayList<>();
        while (rs.next()) {
            Class cl = new Class();
            cl.setXueyuan(rs.getString("Xueyuan"));
            cl.setBanji(rs.getString("Banji"));
            cl.setFudaoyuan(rs.getString("Fudaoyuan"));
            System.out.println(cl.getXueyuan());
            list.add(cl);
        }
        rs.close();
        ps.close();
        conn.close();
        return list;
    }

    @Override
    public List<beddata> updateGetId(String id) throws SQLException {
        Connection connection = getConnection();
        // 修正表名和字段名
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM beddata WHERE student_id=?");
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        List list = new ArrayList();
        while (resultSet.next()) {
            beddata p = new beddata();
            p.setStudentId(resultSet.getString("student_id"));
            p.setBuilding(resultSet.getString("building"));
            p.setRoom(resultSet.getString("room"));
            p.setBed(resultSet.getString("bed"));
            p.setName(resultSet.getString("name"));
            list.add(p);
        }
        // ...关闭资源...
        resultSet.close();
        statement.close();
        connection.close();
        return list;
    }

    @Override
    public boolean update(String originalId, String studentId, String building,
                          String room, String bed, String name) throws SQLException {
        String sql = "UPDATE beddata SET student_id=?, building=?, room=?, bed=?, name=? "
                + "WHERE student_id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 注意参数顺序！！！
            pstmt.setString(1, studentId);
            pstmt.setString(2, building);
            pstmt.setString(3, room);
            pstmt.setString(4, bed);
            pstmt.setString(5, name);
            pstmt.setString(6, originalId); // WHERE条件放在最后

            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public List<beddata> queryAll() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from beddata");
        List list = new ArrayList();
        System.out.println("执行语句没问题,dao");
        while (resultSet.next()) {
            beddata p = new beddata();
            p.setStudentId(resultSet.getString("student_id"));
            p.setBuilding(resultSet.getString("building"));
            p.setRoom(resultSet.getString("room"));
            p.setBed(resultSet.getString("bed"));
            p.setName(resultSet.getString("name"));
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
        try (Connection conn = getConnection();
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

