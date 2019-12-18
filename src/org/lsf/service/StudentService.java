package org.lsf.service;

public interface StudentService {
    public abstract String Login(String account,String password);
    public void UpdateStuScore(String account,int score);
}
