package com.studentcrud.user;

public enum Subject {
    MATH(1),
    KOREAN(2),
    ENGLISH(3);

    int choose;

    Subject(int choose) {
        this.choose = choose;
    }
}
