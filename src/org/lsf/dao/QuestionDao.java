package org.lsf.dao;

import org.lsf.model.Question;

import java.util.List;

public interface QuestionDao {


    public List<Question> queryById(int id);
    public List<Question> queryByNum(int number);

    /*获取全部题目*/
    public List<Question> queryAllQues();

    /*增删改查实现*/



    public void updatePicture();
}
