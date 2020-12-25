package org.lsf.Controller;

import org.lsf.model.PageMessage;
import org.lsf.model.Question;
import org.lsf.service.QuestionService;
import org.lsf.service.impl.QuestionServiceImpl;

import java.util.List;

public class ExamController {

    private QuestionService questionService = new QuestionServiceImpl();
    private List<Question> questions = questionService.queryAll();
    public QuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Question> getQuestionsByNum(int number){

        /*随机获取 number 道题目*/

        return null;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    /* 获取 第 i 道题(页) 的数据 , 返回类型为PageMessage */
    public PageMessage toPage(int i){
        if (i > questions.size()){
            return PageMessage.fail_2();
        } else if (i <= 0){
            return PageMessage.fail_1();
        } else {
            PageMessage pageMessage = PageMessage.success();
            pageMessage.add("Question",questions.get(i-1));
            return pageMessage;
        }
    }

}