package com.test.service.impl;
import com.test.bean.Person;
import com.test.dao.PersonDao;
import com.test.dao.impl.PersonDAaoimpl;
import com.test.service.PersonService;

import java.sql.SQLException;
import java.util.List;

public class PersonServiceimpl implements PersonService {
    @Override
    public List<Person> AllPerson() throws SQLException {
        PersonDao dao=new PersonDAaoimpl() ;
        return dao.queryAll();
    }

    @Override
    public boolean selectOne(String studentId, String password) {
        PersonDao dao=new PersonDAaoimpl();
        //首先判断当前表中是否有同名，如果有，注册失败，没有的话，完成用户添加操作，注册成功
        try {
            if(dao.selectOne(studentId, password)){
                System.out.println(dao.selectOne(studentId, password));
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
