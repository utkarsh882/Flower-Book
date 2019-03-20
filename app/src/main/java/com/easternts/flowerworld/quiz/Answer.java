package com.easternts.flowerworld.quiz;

/**
 * Created by SVF 15213 on 20-06-2016.
 */
public class Answer {
    private int ansId;
    private int ans;
    private int ansType;
    private int ansResource;
    private int ansIsCorrect;
    private int aquesId;

    public Answer(int ansId, int ans, int ansType, int ansResource, int ansIsCorrect, int aquesId) {

        this.ansId = ansId;
        this.ans = ans;
        this.ansType = ansType;
        this.ansResource = ansResource;
        this.ansIsCorrect = ansIsCorrect;
        this.aquesId = aquesId;
    }

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public int getAnsType() {
        return ansType;
    }

    public void setAnsType(int ansType) {
        this.ansType = ansType;
    }

    public int getAnsResource() {
        return ansResource;
    }

    public void setAnsResource(int ansResource) {
        this.ansResource = ansResource;
    }

    public int getAnsIsCorrect() {
        return ansIsCorrect;
    }

    public void setAnsIsCorrect(int ansIsCorrect) {
        this.ansIsCorrect = ansIsCorrect;
    }

    public int getAquesId() {
        return aquesId;
    }

    public void setAquesId(int aquesId) {
        this.aquesId = aquesId;
    }


}
