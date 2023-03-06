package com.studentcrud.user;

public class Student extends User{ //오직 데이터만을 담고있다.
    private String name;
    private String id;
    private int kScore;
    private int eScore;
    private int mScore;
    private String pw;

    public Student(String name, String id, int kScore, int eScore, int mScore) {
        this.name = name;
        this.id = id;
        this.kScore = kScore;
        this. eScore = eScore;
        this.mScore = mScore;
        this.pw = String.valueOf(id);
    }
    public Student() { //오버로딩
    }



    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getkScore() {
        return kScore;
    }

    public int geteScore() {
        return eScore;
    }

    public int getmScore() {
        return mScore;
    }

    public String getPw() {return pw;}

    public void setName(String name) {this.name = name;}
    public void setPw(String pw) {this.pw = pw;}


}