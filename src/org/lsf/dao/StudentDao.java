package org.lsf.dao;

import org.lsf.model.Student;

public interface StudentDao {


    public boolean check();

    public Student queryByAccount(String account);

}