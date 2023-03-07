package com.studentcrud.user;

public class Teacher extends User{

    public Teacher(String name, String id) {
        super.name = name;
        super.id = id;
        super.pw = id;
    }
    public Teacher() { //오버로딩
    }



    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getPw() {
        return super.getPw();
    }

    @Override
    public void setPw(String pw) {
        super.setPw(pw);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
