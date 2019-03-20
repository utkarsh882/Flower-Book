package com.easternts.flowerworld.quiz;

/**
 * Created by SVF 15213 on 20-06-2016.
 */
public class Question {
    private int quesId;
    private int ques;
    private int quesType;
    private int quesResource;   //Normal, Image, Sound etc..

    public Question(int quesId, int ques, int quesType, int quesResource) {
        this.quesId = quesId;
        this.ques = ques;
        this.quesType = quesType;
        this.quesResource = quesResource;
    }

    public int getQuesId() {
        return quesId;
    }

    public int getQues() {
        return ques;
    }

    public void setQues(int ques) {
        this.ques = ques;
    }

    public int getQuesType() {
        return quesType;
    }

    public void setQuesType(int quesType) {
        this.quesType = quesType;
    }

    public int getQuesResource() {
        return quesResource;
    }

    public void setQuesResource(int quesResource) {
        this.quesResource = quesResource;
    }
}
