package org.lsf.service.impl;

import org.lsf.dao.QuestionDao;
import org.lsf.dao.impl.QuestionDaoImpl;
import org.lsf.model.Question;
import org.lsf.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao = new QuestionDaoImpl();

    @Override
    public List<Question> queryAll() {
        List<Question> questions = questionDao.queryAllQues();
        return questions;
    }
}
