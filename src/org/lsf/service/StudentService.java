package org.lsf.service;

import org.lsf.model.Student;

public interface StudentService {
    public abstract String Login(String account,String password);
    public void UpdateStuScore(String account,int score);

    /*向数据库添加一个学生的信息: 账号 密码 姓名*/
    public boolean insertStudent(Student student);

    public Student queryByName(String name);

    public int deleteById(int stuId);
}
