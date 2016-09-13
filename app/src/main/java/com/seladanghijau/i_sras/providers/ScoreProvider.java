package com.seladanghijau.i_sras.providers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.seladanghijau.i_sras.dtos.Answer;
import com.seladanghijau.i_sras.dtos.Score;
import com.seladanghijau.i_sras.helper.DBHelper;

import java.util.List;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class ScoreProvider {
    public static Score loadScore() { // load semua kategori score dan return dlm bentuk object Score
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;

        // Score object vars
        int scoreId;
        int israsScore, vitalScore, recommendedScore;
        int israsLevel, vitalLevel, recommendedLevel;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY); // open db

        // run query
        sql = "SELECT * " +
                "FROM SCORE " +
                "LIMIT 1";
        cursor = sqliteDB.rawQuery(sql, null);

        // get all data
        scoreId = cursor.getInt(cursor.getColumnIndex("scoreId"));
        israsScore = cursor.getInt(cursor.getColumnIndex("israsScore"));
        vitalScore = cursor.getInt(cursor.getColumnIndex("vitalScore"));
        recommendedScore = cursor.getInt(cursor.getColumnIndex("recommendedScore"));
        israsLevel = cursor.getInt(cursor.getColumnIndex("israsLevel"));
        vitalLevel = cursor.getInt(cursor.getColumnIndex("vitalLevel"));
        recommendedLevel = cursor.getInt(cursor.getColumnIndex("recommendedLevel"));

        cursor.close();

        return new Score(scoreId, israsScore, vitalScore, recommendedScore, israsLevel, vitalLevel, recommendedLevel);
    }

    public static int loadISRASScore() { // load score bagi kategori isras drp database
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;
        int israsScore;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY); // open db

        // run query
        sql = "SELECT israsScore " +
                "FROM SCORE " +
                "LIMIT 1";
        cursor = sqliteDB.rawQuery(sql, null);

        // get all data
        israsScore = cursor.getInt(cursor.getColumnIndex("israsScore"));

        cursor.close();

        return israsScore;
    }

    public static int loadVitalScore() {  // load score bagi kategori vital drp database
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;
        int vitalScore;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY); // open db

        // run query
        sql = "SELECT vitalScore " +
                "FROM SCORE " +
                "LIMIT 1";
        cursor = sqliteDB.rawQuery(sql, null);

        // get all data
        vitalScore = cursor.getInt(cursor.getColumnIndex("vitalScore"));

        cursor.close();

        return vitalScore;
    }

    public static int loadRecommendedScore() { // load score bagi kategori recommended drp database
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;
        int recommendedScore;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY); // open db

        // run query
        sql = "SELECT recommendedScore " +
                "FROM SCORE " +
                "LIMIT 1";
        cursor = sqliteDB.rawQuery(sql, null);

        // get all data
        recommendedScore = cursor.getInt(cursor.getColumnIndex("recommendedScore"));

        cursor.close();

        return recommendedScore;
    }

    public static Score calculateScore() { // kira semua score (ISRAS, VITAL, RECOMMENDED) dan return dlm object Score
        Score tempScore;

        tempScore = new Score();
        tempScore.setIsrasScore(calculateScoreISRAS());
        tempScore.setVitalScore(calculateScoreVital());
        tempScore.setRecommendedScore(calculateScoreRecommended());

        return tempScore;
    }

    public static int calculateScoreISRAS() { // kira jumlah score antara vital & recommended
        return calculateScoreRecommended() + calculateScoreVital();
    }

    public static int calculateScoreVital() { // kira score bagi kategori vital
        List<Answer> vitalAnswerList;

        vitalAnswerList = AnswerProvider.loadAnswerBasedOnType(1);

        return (vitalAnswerList.size() * 3);
    }

    public static int calculateScoreRecommended() { // kira skor bagi kategori recommended
        List<Answer> recommendedAnswerList;

        recommendedAnswerList = AnswerProvider.loadAnswerBasedOnType(2);

        return recommendedAnswerList.size();
    }

    public static Score getLevelScore(int isras, int vital, int recommended) { // produce appopriate category berdasarkan value <param1> (tengok range skor yg miss buat). Return semua score dlm bentuk Score objek
        int israsLevel, vitalLevel, recommendedLevel;

        israsLevel = getLevelISRAS(isras);
        vitalLevel = getLevelVital(vital);
        recommendedLevel = getLevelRecommended(recommended);

        return new Score(israsLevel, vitalLevel, recommendedLevel);
    }

    public static int getLevelISRAS(int isras) { // produce appopriate category berdasarkan value <param1> (tengok range skor yg miss buat)
        int israsLevel;

        // isras level
        if(isras <= 60)
            israsLevel = 3;
        else if((isras > 60) && (isras <= 120))
            israsLevel = 2;
        else
            israsLevel = 1;

        return israsLevel;
    }

    public static int getLevelVital(int vital) { // produce appopriate category berdasarkan value <param1> (tengok range skor yg miss buat)
        int vitalLevel;

        // vital level
        if(vital <= 36)
            vitalLevel = 3;
        else if((vital > 36) && (vital <= 72))
            vitalLevel = 2;
        else
            vitalLevel = 1;

        return vitalLevel;
    }

    public static int getLevelRecommended(int recommended) { // produce appopriate category berdasarkan value <param1> (tengok range skor yg miss buat)
        int recommendedLevel;

        // recommended level
        if(recommended <= 26)
            recommendedLevel = 3;
        else if((recommended > 26) && (recommended <= 52))
            recommendedLevel = 2;
        else
            recommendedLevel = 1;

        return recommendedLevel;
    }

    public static boolean storeScore(Score score) { // simpan score baru. retrieve 3 jenis score(ISRAS, Vital & Recommended) dalam object <param1>
        int scoreId;
        int israsScore, vitalScore, recommendedScore;
        int israsLevel, vitalLevel, recommendedLevel;
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READWRITE); // open db

        // setup score levels
        scoreId = score.getScoreId();
        israsScore = score.getIsrasScore();
        vitalScore = score.getVitalScore();
        recommendedScore = score.getRecommendedScore();
        israsLevel = getLevelISRAS(score.getIsrasScore());
        vitalLevel = getLevelVital(score.getVitalScore());
        recommendedLevel = getLevelRecommended(score.getRecommendedScore());

        sql = "INSERT INTO Score " +
                "VALUES(" +
                    "'" + scoreId + "', " +
                    "'" + israsScore + "', " +
                    "'" + vitalScore + "', " +
                    "'" + recommendedScore + "', " +
                    "'" + israsLevel + "', " +
                    "'" + vitalLevel + "', " +
                    "'" + recommendedLevel + "'" +
                ")";
        cursor = sqliteDB.rawQuery(sql, null);

        cursor.close();

        return true;
    }

    public static boolean updateScore(Score score) { // update data score ikut <param1> & <param2>
        int israsScore, vitalScore, recommendedScore;
        int israsLevel, vitalLevel, recommendedLevel;

        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READWRITE); // open db

        // setup score levels
        israsScore = score.getIsrasScore();
        vitalScore = score.getVitalScore();
        recommendedScore = score.getRecommendedScore();
        israsLevel = getLevelISRAS(score.getIsrasScore());
        vitalLevel = getLevelVital(score.getVitalScore());
        recommendedLevel = getLevelRecommended(score.getRecommendedScore());

        sql = "UPDATE Score " +
                "SET " +
                    "israsScore='" + israsScore + "', " +
                    "vitalScore='" + vitalScore + "', " +
                    "recommendedScore='" + recommendedScore + "', " +
                    "israsLevel='" + israsLevel + "', " +
                    "vitalLevel='" + vitalLevel + "', " +
                    "recommendedLevel='" + recommendedLevel + "';";
        cursor = sqliteDB.rawQuery(sql, null);

        cursor.close();

        return true;
    }

    public static boolean clearScore() { // buang semua data dalam table score
        SQLiteDatabase sqliteDB;
        Cursor cursor;
        String sql;

        sqliteDB = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READWRITE); // open db

        sql = "DELETE FROM Score;";
        cursor = sqliteDB.rawQuery(sql, null);

        cursor.close();

        return true;
    }
}
