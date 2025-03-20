package com.test.bean;

public class Person {
    private  int id;
    private String name;
    private String pwd;

    public Person() {
    }
    public Person(String studentId, String password) {
        this.id = Integer.parseInt(studentId);
        this.name = studentId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
