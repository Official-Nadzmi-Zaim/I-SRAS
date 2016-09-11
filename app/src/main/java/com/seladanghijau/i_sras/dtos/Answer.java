package com.seladanghijau.i_sras.dtos;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class Answer {
    private int answerId;
    private boolean answer;

    // constructor
    public Answer() {
        answerId = 0;
        answer = false;
    }

    public Answer(int answerId, boolean answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    // getter
    public int getAnswerId() { return answerId; }
    public boolean getAnswer() { return answer; }

    // setter
    public void setAnswerId(int answerId) { this.answerId = answerId; }
    public void setAnswer(boolean answer) { this.answer = answer; }
}
