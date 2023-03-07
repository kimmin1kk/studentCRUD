package com.studentcrud.service;

import com.studentcrud.user.Student;
import com.studentcrud.user.Teacher;
import com.studentcrud.view.AdminViewer;
import com.studentcrud.view.StudentViewer;
import com.studentcrud.view.TeacherViewer;

public class Client {
    AdminViewer av = new AdminViewer();
    StudentViewer sv = new StudentViewer();
    TeacherViewer tv = new TeacherViewer();
    UserManager<Student> studentManager = new UserManager<>();
    UserManager<Teacher> teacherManager = new UserManager<Teacher>(){
        @Override
        public void addUser(Teacher teacher) throws IllegalArgumentException {
            super.addUser(teacher);
        }
    } ;
    public void run() {// 학생으로 로그인할지 관리자로 로그인할지 고를 수 있는 초기 페이지.
        String id = null;
        String pw = null;
        switch (av.loginPage()) {
            case 1: // 학생 로그인
                id = sv.inputId();
                pw = sv.inputPw();

                if (studentManager.findUserByIdAndPassword(id, pw)) { //로그인 성공
                    studentMainPage(studentManager.findById(id));
                    break;
                } else { //로그인 실패
                    System.out.println("로그인 실패");
                    run();
                    break;
                }

            case 2: // 어드민 로그인
                switch (av.adminLogin()) {
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
            switch (av.adminMainPage()) {
                case 1: //학생 입력
                    while (true) {
                        try {
                            studentManager.addUser(av.typeStudent());
                            av.printSuccessSignUp(); //회원가입 성공 메세지
                            break;
                        } catch (IllegalArgumentException ignored) {
                            av.printDuplicatedIdException(); //회원가입 실패 메세지
                        }
                    }
                    break;
                case 2: // 학생 검색
                    av.printStudent(studentManager.findById(sv.inputId()));
                    break;
                case 3: // 학생 리스트 출력
                    for(Student std : studentManager.findAll()) {
                    av.printStudent(std);;
                    }

                    break;
                case 4: // 학생 삭제
                    studentManager.deleteUserById(sv.inputId());
                    break;
                case 5: //교직원 추가
                    while(true) {
                        try{
                            //입력 받고 typeTeacher에 넣어주는건? -> 안됨.
                        teacherManager.addUser(av.typeTeacher());
                        av.printSuccessSignUp(); //회원가입 성공 메세지
                        break;
                        } catch (IllegalArgumentException ignored) {
                        av.printDuplicatedIdException(); //회원가입 실패 메세지
                            }
                    }
                    break;
                case 6: //교직원 담당과목 수정
                    break;
                case 7: //교직원 삭제
                    break;
                case 8: // 로그아웃
                    run(); //break 안 달은 이유 : 로그아웃할 때 현재 창이 종료가 되면서 새로운 창으로 넘어가는 느낌이라서
                case 9: // 종료
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
            switch (sv.studentMainPage()) {
                case 1:
                    av.printStudent(student);
                    break;
                case 2:
                    switch (sv.replaceStudentInformation()) {
                        case 1: //이름 변경
                            sv.replaceStudentName(student);
                            break;
                        case 2: //비밀번호 변경
                            sv.replaceStudentPassword(student);
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
