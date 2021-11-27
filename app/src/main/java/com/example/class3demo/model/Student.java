package com.example.class3demo.model;

public class Student {
    String name;
    String id;
    boolean flag;

    public  Student(){}
    public Student(String name, String id, boolean flag) {
        this.name = name;
        this.id = id;
        this.flag = flag;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
