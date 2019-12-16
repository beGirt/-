package org.lsf.dao;

import org.lsf.model.Student;

public interface StudentDao {



    public Student check(String account,String password);
    
}