package com.example.class3demo.model;

public class Student {

    String name = "";
    String id = "";
    String phone="";
    String addres="";
    boolean flag = false;

    public Student(){}
    public Student(String name, String id, boolean flag,String phone,String addres ) {
        this.name = name;
        this.id = id;
        this.flag = flag;
        this.phone=phone;
        this.addres=addres;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isFlag() {
        return flag;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
