package org.lsf.dao;

import org.lsf.model.Student;

public interface StudentDao {



    public Student check(String account,String password);

    /*根据学号修改成绩*/
    public void UpdateScore(String account,int score);

}