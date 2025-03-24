package com.test.bean;

public class Class {
    private String id;
    private String xueyuan;
    private String banji;
    private String fudaoyuan;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXueyuan() {
        return xueyuan;
    }

    public void setXueyuan(String xueyuan) {
        this.xueyuan = xueyuan;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }
    @Override
    public String toString() {
        return "Class{" +
                "xueyuan='" + xueyuan + '\'' +
                ", banji='" + banji + '\''
                ;
    }

    public String getFudaoyuan() {
        return fudaoyuan;
    }

    public void setFudaoyuan(String fudaoyuan) {
        this.fudaoyuan = fudaoyuan;
    }
}
