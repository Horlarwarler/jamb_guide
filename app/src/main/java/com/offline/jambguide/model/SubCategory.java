package com.offline.jambguide.model;

import java.util.ArrayList;

public class SubCategory {
    public ArrayList<Quizplay> questionList;
    int totalLevel;
    private int id;
    private String name, image, categoryId;

    public SubCategory() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getTotalLevel() {
        return totalLevel;
    }

    public void setTotalLevel(int totalLevel) {
        this.totalLevel = totalLevel;
    }

    public ArrayList<Quizplay> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Quizplay> questionList) {
        this.questionList = questionList;
    }
}
