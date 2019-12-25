package org.lsf.service;

import org.lsf.model.Question;

import java.util.List;

public interface QuestionService {
    public List<Question> queryAll();
    public List<Question> queryQuesByNumber(int number);
}
