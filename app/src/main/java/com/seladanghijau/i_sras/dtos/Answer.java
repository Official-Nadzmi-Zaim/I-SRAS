package com.seladanghijau.i_sras.dtos;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class Answer {
    private int answerId, soalanNo, answerCategory;
    private boolean answer;

    // constructor
    public Answer() {
        answerId = 0;
        soalanNo = 0;
        answerCategory = 0;
        answer = false;
    }

    public Answer(int answerId, int soalanNo, int answerCategory, boolean answer) {
        this.answerId = answerId;
        this.soalanNo = soalanNo;
        this.answerCategory = answerCategory;
        this.answer = answer;
    }

    // getter
    public int getAnswerId() { return answerId; }
    public int getSoalanNo() { return soalanNo; }
    public int getAnswerCategory() { return answerCategory; }
    public boolean getAnswer() { return answer; }

    // setter
    public void setAnswerId(int answerId) { this.answerId = answerId; }
    public void setSoalanNo(int soalanNo) { this.soalanNo = soalanNo; }
    public void setAnswerCategory(int answerCategory) { this.answerCategory = answerCategory; }
    public void setAnswer(boolean answer) { this.answer = answer; }
}
