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

    public List<Question> queryQuesByNumber(int number){
        List<Question> list = questionDao.queryQuesByNum(number);
        if (list == null || list.size() < number){
            return null;
        } else {
            return list;
        }
    }


    public static void main(String[] args) {
        /*QuestionService questionService = new QuestionServiceImpl();
        List<Question> list = questionService.queryQuesByNumber(2);
        System.out.println(list.get(1));*/
    }
}
