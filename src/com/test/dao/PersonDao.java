package com.test.dao;


import com.test.bean.Person;
import java.sql.SQLException;
import java.util.List;

public interface PersonDao {

    public List<Person> queryAll() throws SQLException;
    //public int save(Person person) throws SQLException;

    boolean selectOne(String studentId, String password)throws SQLException;

}
