package com.seladanghijau.i_sras.providers;

import com.seladanghijau.i_sras.dtos.Answer;

import java.util.List;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class AnswerProvider {
    public static List<Answer> loadAllAnswer() { return null; }

    public static Answer loadAnswer(int answerId) { return null; }

    public static List<Answer> loadAnswerBasedOnAnswer(boolean answer) { return null; }

    public static List<Answer> loadAnswerBasedOnCategory(String answerCategory) { return null; }

    public static List<Answer> loadAnswerBAsedOnCriteria(String answerCategory, boolean answer) { return null; }

    public static boolean storeAnswer(Answer answer) { return false; }

    public static boolean updateAnswer(int answerId, Answer answer) { return false; }
}
