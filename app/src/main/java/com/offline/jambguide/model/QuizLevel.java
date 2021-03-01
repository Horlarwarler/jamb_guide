package com.offline.jambguide.model;

import com.offline.jambguide.Constant;
import com.offline.jambguide.adapter.DBHelper;

import java.util.Collections;
import java.util.List;

public class QuizLevel {
    DBHelper questionsDao;
    private int levelNo;
    private int noOfQuestion;
    private List<Quizplay> question;

    public QuizLevel(int levelNo, int noOfQuestion, DBHelper questionsDao) {
        super();
        this.levelNo = levelNo;
        this.noOfQuestion = noOfQuestion;
        this.questionsDao = questionsDao;
    }

    public int getLevelNo() {
        return levelNo;
    }

    public int getNoOfQuestion() {
        return noOfQuestion;
    }

    public List<Quizplay> getQuestion() {
        return question;
    }

    public void setQuestionGuj() {
//        question = questionsDao.getQuestionGuj(Constant.categoryId,Constant.subCategoryId,getNoOfQuestion(), getLevelNo());
        question = questionsDao.getQuestionGujSingleCat(Constant.categoryId, getNoOfQuestion());
        Collections.shuffle(question);
    }
}
