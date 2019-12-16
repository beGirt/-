package org.lsf.service.impl;

import org.lsf.dao.StudentDao;
import org.lsf.dao.impl.StudentDaoImpl;
import org.lsf.model.Student;
import org.lsf.service.UserService;

public class UserServiceImpl implements UserService {

    private StudentDao studentDao = new StudentDaoImpl();


    @Override
    public String Login(String account,String password) {
        Student student = studentDao.queryByAccount(account);
        if(student != null && student.getStuPassword().equals(password)){
            return "登录成功";
        } else {
            return "登录失败";
        }

    }
}
