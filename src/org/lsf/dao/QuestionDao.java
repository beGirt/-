package org.lsf.dao;

import org.lsf.model.Question;

import java.util.List;

public interface QuestionDao {
    public List<Question> queryById(int id);
    public List<Question> queryByNum(int number);
    public List<Question> queryAllQues();

    public void updatePicture();
}
