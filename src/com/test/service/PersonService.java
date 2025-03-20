package com.test.service;

import com.test.bean.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonService {
    public List<Person> AllPerson() throws SQLException;
    boolean selectOne(String studentId, String password);
}
