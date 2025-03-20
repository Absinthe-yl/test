package com.test.service;

import com.test.bean.Person;
import com.test.bean.beddata;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public interface PersonService {
    public List<Person> AllPerson() throws SQLException;
    boolean selectOne(String studentId, String password);
    public List<beddata> data(String studentId) throws SQLException;
}
