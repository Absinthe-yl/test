package com.test.service;

import com.test.bean.Class;
import com.test.bean.Person;
import com.test.bean.beddata;

import java.sql.SQLException;
import java.util.List;

public interface PersonService {
    public List<Person> AllPerson() throws SQLException;
    boolean selectOne(String studentId, String password);
    boolean selectOneRoot(String studentId, String password);
    public List<beddata> data(String studentId) throws SQLException;
    public  List<Class> classData(String studentId) throws SQLException;
    public List<beddata> queryAll() throws SQLException;
    public boolean addBedData(String studentId, String building, String room, String bed, String name) throws SQLException;
    public List<beddata> updateGetId(String id) throws SQLException;
    public boolean update(String originalId, String studentId, String building, String room, String bed, String name) throws SQLException ;
}
