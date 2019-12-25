package org.lsf.dao;

import org.lsf.model.Student;

public interface StudentDao {


    /*根据account And password查询*/
    public Student check(String account,String password);

    /*根据学号修改成绩*/
    public void UpdateScore(String account,int score);



    /*增删改查*/
    /*增*/
    public void addStudent(Student student);

    /*删*/
    public void deleteStudentByAccount(String account);

    /*改*/
    public void updateStudentByAccount(Student student,String account);

    /*查*/
    public Student queryStudentByAccount(String account);

}