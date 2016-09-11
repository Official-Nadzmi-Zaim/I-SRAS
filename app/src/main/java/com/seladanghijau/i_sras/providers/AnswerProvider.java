package com.seladanghijau.i_sras.providers;

import com.seladanghijau.i_sras.dtos.Answer;

import java.util.List;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class AnswerProvider {
    public static List<Answer> loadAllAnswer() { // list semua jawapan yang ada dalam database
        return null;
    }

    public static Answer loadAnswer(int answerId) { // load hanya satu jawapan dalam database. Cari jawapan guna <parameter1>
        return null;
    }

    public static List<Answer> loadAnswerBasedOnAnswer(boolean answer) { // load semua jawapan yang ada persamaan dengan <parameter1>
        return null;
    }

    public static List<Answer> loadAnswerBasedOnCategory(String answerCategory) { // load semua jawapan yang ada persamaan dengan <parameter1>
        return null;
    }

    public static List<Answer> loadAnswerBAsedOnCriteria(String answerCategory, boolean answer) { // load semua jawapan yang ada persamaan dengan <parameter1> & <parameret2>
        return null;
    }

    public static boolean storeAnswer(Answer answer) { // simpan jawapan baru kedalam databas
        return false;
    }

    public static boolean updateAnswer(int answerId, Answer answer) { // update jawapan sediada dalam database berdasarkana <parameter1>
        return false;
    }

    public static boolean clearAnswer() { // buang semua data dlm table answer dalam database
        return false;
    }
}
