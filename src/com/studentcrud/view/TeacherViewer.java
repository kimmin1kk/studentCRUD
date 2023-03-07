package com.studentcrud.view;

import com.studentcrud.user.Student;
import com.studentcrud.user.Teacher;
import com.studentcrud.user.User;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.studentcrud.config.Configuration.*;

public class TeacherViewer extends UserViewer{
    @Override
    protected void checkInstanceValidation(User user) {
        if (!(user instanceof Teacher)) throw new IllegalArgumentException();
    }

    public String inputId() { // 아이디를 입력하는 메서드
        String id = null;
        System.out.print("교직원 아이디를 입력하세요 :");
        id = sc.nextLine();
        return id;
    }

    public int teacherMainPage() { // 학생으로 로그인 했을 때 ui 메서드
        int num=0;
        boolean onOff= true;
        while(onOff) {
            System.out.println("---------------------------");
            System.out.println("| 학생 관리 시스템 (교직원용) |");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("| 1. 학생 검색 | 2. 학생 리스트 출력 | 3. 담당과목 점수 수정 | 4. 정보 수정 | 5. 로그아웃 | 6. 종료 |");
            System.out.println("------------------------------------------------------------------------------------------");
            try {
                System.out.print("값을 입력해주세요 : ");
                num = getInput();
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
            }else if (num > INPUT_RANGE_TEACHER_MAIN) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            switch(num) {
                case 1:
                    System.out.println("학생 검색을 선택하셨습니다.");break;
                case 2:
                    System.out.println("학생 리스트 출력을 선택하셨습니다.");break;
                case 3:
                    System.out.println("담당과목 점수 수정을 선택하셨습니다.");break;
                case 4:
                    System.out.println("정보 수정을 선택하셨습니다.");break;
                case 5:
                    System.out.println("로그아웃합니다.");
                    System.out.println("로그인 페이지로 넘어갑니다.");break;
                case 6:
                    System.out.println("학생 관리 시스템을 종료합니다.");break;
            }
            return num;
        }
        return num;
    }
}
