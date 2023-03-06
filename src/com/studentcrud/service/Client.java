package com.studentcrud.service;

import com.studentcrud.user.Student;
import com.studentcrud.user.Teacher;
import com.studentcrud.view.AdminInterface;
import com.studentcrud.view.StudentInterface;
import com.studentcrud.view.TeacherInterface;

public class Client {
    AdminInterface ai = new AdminInterface();
    StudentInterface si = new StudentInterface();
//    TeacherInterface ti = new TeacherInterface(); 아직 안 씀
    UserManager<Student> studentManager = new UserManager<>();
//    UserManager<Teacher> teacherManager = new UserManager<>(); 아직 안 씀
    public void run() {// 학생으로 로그인할지 관리자로 로그인할지 고를 수 있는 초기 페이지.
        String id = null;
        String pw = null;
        switch (ai.loginPage()) {
            case 1: // 학생 로그인
                id = si.inputId();
                pw = si.inputPw();

                if (studentManager.findUserByIdAndPassword(id, pw)) { //로그인 성공
                    studentMainPage(studentManager.findById(id));
                    break;
                } else { //로그인 실패
                    System.out.println("로그인 실패");
                    run();
                    break;
                }

            case 2: // 어드민 로그인
                switch (ai.adminLogin()) {
                    case 1: // 로그인 성공
                        adminMainPage();
                        break;
                    case 2: // 취소 했을 때
                        run();
                        break;
                }
                break;
        }
    }

    public void adminMainPage() { //어드민으로 로그인했을때 호출되는 메서드
        boolean onOff = true;
        while (onOff) {
            switch (ai.adminMainPage()) {
                case 1: //학생 입력
                    while (true) {
                        try {
                            studentManager.addUser(ai.typeStudent());
                            ai.printSuccessSignUp();
                            break;
                        } catch (IllegalArgumentException ignored) {
                            ai.printDuplicatedIdException();
                        }
                    }
                    break;
                case 2: // 학생 검색
                    ai.printStudent(studentManager.findById(si.inputId()));
                    break;
                case 3: // 학생 리스트 출력
                    for(Student std : studentManager.findAll()) {
                    ai.printStudent(std);;
                    }

                    break;
                case 4: // 삭제
                    studentManager.deleteUserById(si.inputId());
                    break;
                case 5: // 로그아웃
                    run(); //break 안 달은 이유 : 로그아웃할 때 현재 창이 종료가 되면서 새로운 창으로 넘어가는 느낌이라서
                case 6: // 종료
                    onOff = false;
                    break;
                default:
                    System.out.println("에러 발생");
                    break;
            }
        }

    }

    public void studentMainPage(Student student) { //학생으로 로그인 했을때 호출되는 메서드
        boolean onOff = true;
        while (onOff) {
            switch (si.studentMainPage()) {
                case 1:
//                    si.printUser(student);
                    break;
                case 2:
                    switch (si.replaceStudentInformation()) {
                        case 1: //이름 변경
                            si.replaceStudentName(student);
                            break;
                        case 2: //비밀번호 변경
                            si.replaceStudentPassword(student);
                            break;
                        case 3: //취소
                            studentMainPage(student);
                            break;
                    }
                    break;
                case 3:
                    run();
                case 4:
                    onOff = false;
                    break;
                default:
                    System.out.println("에러 발생");
                    break;
            }

        }

    }


}
