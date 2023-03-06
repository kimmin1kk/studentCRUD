package com.studentcrud.user;

public class Teacher extends User{

    private String name;
    private String id;
    private String password;

    public Teacher(String name, String id) {
        this.name = name;
        this.id = id;
        this.password = password;
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
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
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
