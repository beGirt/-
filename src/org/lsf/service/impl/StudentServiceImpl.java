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
}
