package com.test.dao;


import com.test.bean.Class;
import com.test.bean.beddata;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {

    public List<beddata> queryAll() throws SQLException;
    //public int save(Person person) throws SQLException;
    boolean selectOne(String studentId, String password)throws SQLException;
    boolean selectOneRoot(String studentId, String password)throws SQLException;
    public List<beddata> data(String studentId) throws SQLException;
    public  List<Class> classData(String studentId) throws SQLException;
    public List<beddata> updateGetId(String id) throws SQLException;
    boolean update(String originalId, String studentId, String building,
                   String room, String bed, String name) throws SQLException;
}
