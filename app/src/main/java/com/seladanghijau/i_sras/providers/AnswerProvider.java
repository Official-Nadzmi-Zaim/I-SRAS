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

        sql = "SELECT * " +
                "FROM Answer"; // sql query
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
            tempAnswerId = cursor.getInt(cursor.getColumnIndex("answerId")); // answerId
            if(cursor.getInt(cursor.getColumnIndex("answerId")) == 0) // answer
                tempAnswer = false;
            else
                tempAnswer = true;

            // setup all data into temporary Answer object
            tempAnswerObj.setAnswerId(tempAnswerId);
            tempAnswerObj.setAnswer(tempAnswer);

            answerList.add(tempAnswerObj); // add the temporary Answer object into answerList and repeat the process
        }

        cursor.close();

        return answerList; // return list of Answer objects
    }

    public static Answer loadAnswer(int answerId) { // load hanya satu jawapan dalam database. Cari jawapan guna <parameter1>
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        Answer tempAnswerObj;
        String sql;
        int tempAnswerId;
        boolean tempAnswer;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY); // open database

        sql = "SELECT * " +
                "FROM Answer " +
                "WHERE answerId LIKE '" + answerId + "' LIMIT 1"; // sql query
        cursor = sqliteDB.rawQuery(sql, null); // return quried data in cursor

        // initialization
        tempAnswerObj = new Answer();

        // store all data taken from cursor into temporary vars
        tempAnswerId = cursor.getInt(cursor.getColumnIndex("answerId")); // answerId
        if(cursor.getInt(cursor.getColumnIndex("answerId")) == 0) // answer
            tempAnswer = false;
        else
            tempAnswer = true;

        // setup all data into temporary Answer object
        tempAnswerObj.setAnswerId(tempAnswerId);
        tempAnswerObj.setAnswer(tempAnswer);

        cursor.close();

        return tempAnswerObj;
    }

    public static List<Answer> loadAnswerBasedOnAnswer(boolean answer) { // load semua jawapan yang ada persamaan dengan <parameter1>
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;
        List<Answer> answerList;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY); // open database

        sql = "SELECT * " +
                "FROM Answer " +
                "WHERE answer LIKE '" + answer + "'"; // sql query
        cursor = sqliteDB.rawQuery(sql, null); // return quried data in cursor

        answerList = new ArrayList<>();
        for(int x=0 ; x<cursor.getCount() ; x++) {
            Answer tempAnswerObj;
            int tempAnswerId;
            boolean tempAnswer;

            // initialization
            tempAnswerObj = new Answer();

            // store all data taken from cursor into temporary vars
            tempAnswerId = cursor.getInt(cursor.getColumnIndex("answerId")); // answerId
            if(cursor.getInt(cursor.getColumnIndex("answerId")) == 0) // answer
                tempAnswer = false;
            else
                tempAnswer = true;

            // setup all data into temporary Answer object
            tempAnswerObj.setAnswerId(tempAnswerId);
            tempAnswerObj.setAnswer(tempAnswer);

            answerList.add(tempAnswerObj);
        }

        cursor.close();

        return answerList;
    }

    public static List<Answer> loadAnswerBasedOnCategory(int soalanCategory) { // load semua jawapan yang ada persamaan dengan <parameter1>
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;
        List<Answer> answerList;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY); // open database

        sql = "SELECT * " +
                "FROM Answer " +
                "WHERE answerId LIKE (" +
                    "SELECT soalanId " +
                    "FROM Soalan " +
                    "WHERE soalanCategory LIKE " + soalanCategory +
                ");"; // sql query
        cursor = sqliteDB.rawQuery(sql, null); // return quried data in cursor

        answerList = new ArrayList<>();
        for(int x=0 ; x<cursor.getCount() ; x++) {
            Answer tempAnswerObj;
            int tempAnswerId;
            boolean tempAnswer;

            // initialization
            tempAnswerObj = new Answer();

            // store all data taken from cursor into temporary vars
            tempAnswerId = cursor.getInt(cursor.getColumnIndex("answerId")); // answerId
            if(cursor.getInt(cursor.getColumnIndex("answerId")) == 0) // answer
                tempAnswer = false;
            else
                tempAnswer = true;

            // setup all data into temporary Answer object
            tempAnswerObj.setAnswerId(tempAnswerId);
            tempAnswerObj.setAnswer(tempAnswer);

            answerList.add(tempAnswerObj);
        }

        cursor.close();

        return answerList;
    }

    public static List<Answer> loadAnswerBasedOnType(int soalanType) {
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;
        List<Answer> answerList;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY); // open database

        sql = "SELECT * " +
                "FROM Answer " +
                "WHERE answerId LIKE (" +
                    "SELECT soalanId " +
                    "FROM Soalan " +
                    "WHERE soalanType LIKE " + soalanType +
                ");"; // sql query
        cursor = sqliteDB.rawQuery(sql, null); // return quried data in cursor

        answerList = new ArrayList<>();
        for(int x=0 ; x<cursor.getCount() ; x++) {
            Answer tempAnswerObj;
            int tempAnswerId;
            boolean tempAnswer;

            // initialization
            tempAnswerObj = new Answer();

            // store all data taken from cursor into temporary vars
            tempAnswerId = cursor.getInt(cursor.getColumnIndex("answerId")); // answerId
            if(cursor.getInt(cursor.getColumnIndex("answerId")) == 0) // answer
                tempAnswer = false;
            else
                tempAnswer = true;

            // setup all data into temporary Answer object
            tempAnswerObj.setAnswerId(tempAnswerId);
            tempAnswerObj.setAnswer(tempAnswer);

            answerList.add(tempAnswerObj);
        }

        cursor.close();

        return answerList;
    }

    public static List<Answer> loadAnswerBAsedOnCriteria(int soalanCategory, boolean answer) { // load semua jawapan yang ada persamaan dengan <parameter1> & <parameret2>
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;
        List<Answer> answerList;
        int answerInInt;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY); // open database

        if(answer)
            answerInInt = 1; // if answer is true, return 1
        else
            answerInInt = 0; // if answer is false, return 0

        sql = "SELECT * " +
                "FROM Answer " +
                "WHERE " +
                    "answerId LIKE (" +
                        "SELECT soalanId " +
                        "FROM Soalan " +
                        "WHERE soalanCategory LIKE " + soalanCategory +
                    ") " +
                    "AND " +
                    "answer LIKE " + answerInInt + ";"; // sql query
        cursor = sqliteDB.rawQuery(sql, null); // return queried data in cursor

        answerList = new ArrayList<>();
        for(int x=0 ; x<cursor.getCount() ; x++) {
            Answer tempAnswerObj;
            int tempAnswerId;
            boolean tempAnswer;

            // initialization
            tempAnswerObj = new Answer();

            // store all data taken from cursor into temporary vars
            tempAnswerId = cursor.getInt(cursor.getColumnIndex("answerId")); // answerId
            if(cursor.getInt(cursor.getColumnIndex("answerId")) == 0) // answer
                tempAnswer = false;
            else
                tempAnswer = true;

            // setup all data into temporary Answer object
            tempAnswerObj.setAnswerId(tempAnswerId);
            tempAnswerObj.setAnswer(tempAnswer);

            answerList.add(tempAnswerObj);
        }

        cursor.close();

        return answerList;
    }

    public static boolean storeAnswer(Answer answer) { // simpan jawapan baru kedalam database
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;
        int tempAnswerId, tempAnswer;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READWRITE); // open database

        // extract data from Answer obj
        tempAnswerId = answer.getAnswerId();
        tempAnswer = answer.getAnswer() ? 1 : 0;

        // sql query
        sql = "INSERT INTO Answer\n" +
                "VALUES('" + tempAnswerId + "', '" + tempAnswer + "');";
        cursor = sqliteDB.rawQuery(sql, null); // return queried data in cursor

        cursor.close();

        return true;
    }

    public static boolean updateAnswer(int answerId, Answer answer) { // update jawapan sediada dalam database berdasarkana <parameter1>
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READWRITE); // open database

        // sql query
        sql = "UPDATE Answer " +
                "SET answer='" + answer + "' " +
                "WHERE answerId LIKE '" + answerId + "';";
        cursor = sqliteDB.rawQuery(sql, null); // return queried data in cursor

        cursor.close();

        return true;
    }

    public static boolean clearAnswer() { // buang semua data dlm table answer dalam database
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READWRITE); // open database

        // sql query
        sql = "DELETE * " +
                "FROM Answer";
        cursor = sqliteDB.rawQuery(sql, null); // return queried data in cursor

        cursor.close();

        return true;
    }
}
