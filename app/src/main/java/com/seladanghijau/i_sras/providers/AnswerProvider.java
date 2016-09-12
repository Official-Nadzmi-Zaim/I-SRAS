package com.seladanghijau.i_sras.providers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.seladanghijau.i_sras.dtos.Answer;
import com.seladanghijau.i_sras.helper.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class AnswerProvider {
    public static List<Answer> loadAllAnswer() { // list semua jawapan yang ada dalam database
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;
        List<Answer> answerList;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY); // open db

        sql = "SELECT * FROM Answer"; // sql query
        cursor = sqliteDB.rawQuery(sql, null); // return quried data in cursor

        answerList = new ArrayList<>(); // initialize answer list
        cursor.moveToFirst(); // move cursor to first element
        for(int x=0 ; x<cursor.getCount() ; x++) {
            // temporary values for each data in cursor
            Answer tempAnswerObj;
            int tempAnswerId;
            boolean tempAnswer;

            // initialization of temporary Answer object
            tempAnswerObj = new Answer();

            // store all data taken from cursor into temporary vars
            tempAnswerId = cursor.getInt(cursor.getColumnIndex("answeerId")); // answerId
            if(cursor.getInt(cursor.getColumnIndex("answeerId")) == 0) // answer
                tempAnswer = false;
            else
                tempAnswer = true;

            // setup all data into temporary Answer object
            tempAnswerObj.setAnswerId(tempAnswerId);
            tempAnswerObj.setAnswer(tempAnswer);

            answerList.add(tempAnswerObj); // add the temporary Answer object into answerList and repeat the process
        }

        return answerList; // return list of Answer objects
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
