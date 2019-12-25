package org.lsf.service.impl;

import org.lsf.dao.StudentDao;
import org.lsf.dao.impl.StudentDaoImpl;
import org.lsf.model.Student;
import org.lsf.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();


    @Override
    public String Login(String account,String password) {
        Student student = studentDao.check(account,password);
        if(student != null){
            return "登录成功";
        } else {
            return "登录失败";
        }
    }

    @Override
    public void UpdateStuScore(String account, int score) {
        studentDao.UpdateScore(account,score);
    }

    @Override
    public boolean insertStudent(Student student) {

        /*String reg = "^(([\u4e00-\u9fa5]{2,8})|([a-zA-Z]{2,16}))$";
        boolean isMatch = Pattern.matches(reg,student.getStuAccount());
        if (!isMatch){
            System.out.println("姓名有误");
            return false;
        }
        if (student.getStuAccount().length() != 10){
            System.out.println("账号有误");
            return false;
        }*/
        if (studentDao.queryStudentByAccount(student.getStuAccount()) == null){
            studentDao.addStudent(student);
            return true;
        } else {/*账号重复,插入失败*/
            return false;
        }
    }
}
