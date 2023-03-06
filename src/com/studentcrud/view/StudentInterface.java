package com.studentcrud.view;

import com.studentcrud.user.Student;
import com.studentcrud.user.User;

import java.util.InputMismatchException;
import java.util.Scanner;


import static com.studentcrud.config.Configuration.*;

public class StudentInterface extends UserInterface{
    Student student = new Student();

    @Override
    public void printUser(User user) { //출력하는 메서드.
        checkInstanceValidation(user);
        System.out.println(makeUserInfo(student));
    }
    @Override
    protected String makeUserInfo(User user) {
        return "|이름 :" + student.getName() + " \t\t| 학번 :" + student.getId() + "\t\t| 국어:" + student.getkScore()+ " \t| 영어:" + student.geteScore()
                + "\t| 수학:" + student.getmScore()+ "\t| 총점:" + (student.getkScore() + student.geteScore() + student.getmScore())+ "\t" +
                "| 평균 :" + (student.getkScore() + student.geteScore() + student.getmScore()) / 3;
    }

    @Override
    protected void checkInstanceValidation(User user) {
        if (!(user instanceof Student)) throw new IllegalArgumentException();
    }

    public String inputId() { // 아이디를 입력하는 메서드
        int id = 0;
        System.out.print("학번을 입력하세요 :");
        id = getInput();
        return Integer.toString(id);
    }
    public String inputPw() { // 비밀번호를 입력하는 메서드
        Scanner sc = new Scanner(System.in);
        String pw = null;
        System.out.print("비밀번호를 입력하세요 :");
        pw = sc.nextLine();
        return pw;
    }


    public int studentMainPage() { // 학생으로 로그인 했을 때 ui 메서드
        Scanner sc = new Scanner(System.in);
        int num=0;
        boolean onOff= true;
        while(onOff) {
            System.out.println("-------------------------");
            System.out.println("| 학생 관리 시스템 (학생용) |");
            System.out.println("-----------------------------------");
            System.out.println("| 1. 성적 열람 | 2 수정 | 3 로그아웃 | 4. 종료 |");
            System.out.println("-----------------------------------");
            try {
                System.out.print("값을 입력해주세요 : ");
                num = sc.nextInt();
            }
            catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("정수형만 입력할 수 있습니다.");
                continue;
            }
            if (num < PREVENT_MINUS_N_ZERO) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            }else if (num > INPUT_RANGE_STUDENT_MAIN) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            switch(num) {
                case 1:
                    System.out.println("성적 열람을 선택하셨습니다.");break;
                case 2:
                    System.out.println("수정을 선택하셨습니다.");break;
                case 3:
                    System.out.println("로그아웃합니다.");
                    System.out.println("로그인 페이지로 넘어갑니다.");break;
                case 4:
                    System.out.println("학생 관리 시스템을 종료합니다.");break;
            }
            return num;
        }
        return num;
    }


    public int replaceStudentInformation() { // 학생으로 로그인해서 수정을 선택했을 때 호출되는 ui 메서드
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean onOff = true;
        while (onOff) {
            System.out.println("----------------");
            System.out.println("| 학생 정보 수정 |");
            System.out.println("--------------------------------------");
            System.out.println("| 1. 이름 변경 | 2 비밀번호 변경 | 3 취소 |");
            System.out.println("--------------------------------------");
            try {
                System.out.print("값을 입력해주세요 : ");
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("정수형만 입력할 수 있습니다.");
                continue;
            }
            if (num < PREVENT_MINUS_N_ZERO) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            } else if (num > INPUT_RANGE_STUDENT_MODIFY) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            switch(num) {
                case 1:
                    System.out.println("이름 변경을 선택하셨습니다.");break;
                case 2:
                    System.out.println("비밀번호 변경을 선택하셨습니다.");break;
                case 3:
                    System.out.println("정보 수정을 취소합니다.");break;
            }
            return num;
        }
        return num;
    }

    public void replaceStudentName(Student student) { // 이름을 수정할 때 쓰는 메서드
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 이름을 입력해주세요 :");
        String name = sc.nextLine();
        student.setName(name);
    }

    public void replaceStudentPassword(Student student) { // 비밀번호를 수정할 때 쓰는 메서드
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 비밀번호를 입력해주세요 :");
        String pw = sc.nextLine();
        student.setPw(pw);
    }
}
