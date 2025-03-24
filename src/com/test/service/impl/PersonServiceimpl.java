package com.test.service.impl;
import com.test.bean.Class;
import com.test.bean.Person;
import com.test.bean.beddata;
import com.test.dao.PersonDao;
import com.test.dao.impl.PersonDaoimpl;

import com.test.service.PersonService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.test.DB.db.getConnection;

public class PersonServiceimpl implements PersonService {
    @Override
    public List<beddata> queryAll() throws SQLException {
        PersonDao dao = new PersonDaoimpl();
        return dao.queryAll();
    }

    @Override
    public boolean selectOneRoot(String Id, String password) {
        PersonDao dao = new PersonDaoimpl();
        //首先判断当前表中是否有同名，如果有，注册失败，没有的话，完成用户添加操作，注册成功
        try {
            if (dao.selectOneRoot(Id, password)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<beddata> data(String studentId) throws SQLException {
        PersonDao dao = new PersonDaoimpl();
        return dao.data(studentId);
    }

    @Override
    public List<Class> classData(String studentId) throws SQLException {
        PersonDao dao = new PersonDaoimpl();
        System.out.println("成功追到service");
        return dao.classData(studentId);
    }

    @Override
    public List<Person> AllPerson() throws SQLException {
        return List.of();
    }

    @Override
    public boolean selectOne(String studentId, String password) {
        PersonDao dao = new PersonDaoimpl();
        //首先判断当前表中是否有同名，如果有，注册失败，没有的话，完成用户添加操作，注册成功
        try {
            if (dao.selectOne(studentId, password)) {
                // System.out.println(dao.selectOne(studentId, password));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addBedData(String studentId, String building, String room, String bed, String name)
            throws SQLException {
        String sql = "INSERT INTO beddata (student_id, building, room, bed, name) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            pstmt.setString(2, building);
            pstmt.setString(3, room);
            pstmt.setString(4, bed);
            pstmt.setString(5, name);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public List<beddata> updateGetId(String id) throws SQLException {
        PersonDao dao = new PersonDaoimpl();
        return dao.updateGetId(id);
    }


    @Override
    public boolean update(String originalId, String studentId, String building,
                          String room, String bed, String name) throws SQLException { // 修改点4
        PersonDao dao = new PersonDaoimpl();
        return dao.update(originalId, studentId, building, room, bed, name);
    }
}
