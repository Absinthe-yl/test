package com.test.dao;


import com.test.bean.Person;
import com.test.bean.beddata;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public interface PersonDao {

    public List<Person> queryAll() throws SQLException;
    //public int save(Person person) throws SQLException;
    boolean selectOne(String studentId, String password)throws SQLException;
    public List<beddata> data(String studentId) throws SQLException;
}
