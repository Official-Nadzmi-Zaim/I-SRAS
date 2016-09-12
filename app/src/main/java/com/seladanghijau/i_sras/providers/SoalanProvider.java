package com.seladanghijau.i_sras.providers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.seladanghijau.i_sras.dtos.Answer;
import com.seladanghijau.i_sras.dtos.Soalan;
import com.seladanghijau.i_sras.helper.DBHelper;

import java.util.ArrayList;
import java.util.List;


public class SoalanProvider {
    public static List<Soalan> loadAllSoalan() { // load semua soalan drp database

        List<Soalan> soalanList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase;
        Cursor cursor;
        String sql;

        sqLiteDatabase = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY);
        sql = "SELECT * FROM Soalan";

        cursor = sqLiteDatabase.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {
                Soalan soalan = new Soalan();
                soalan.setSoalanId(cursor.getInt(0));
                soalan.setSoalanNo(cursor.getInt(1));
                soalan.setSoalanDesc(cursor.getString(2));
                soalan.setSoalanType(cursor.getInt(3));
                soalan.setSoalanCategory(cursor.getInt(4));

                soalanList.add(soalan);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return soalanList;
    }

    public static Soalan loadSoalan(int soalanId) { // load satu soalan berdasarkan <param1>
        return null;
    }

    public static List<Soalan> loadSoalanBasedOnCategory(int soalanCategory) { // load soalan berdasarkan <param1>

        List<Soalan> soalanList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase;
        Cursor cursor;
        String sql;

        sqLiteDatabase = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY);
        sql = "SELECT * FROM Soalan WHERE soalanCategory = " + soalanCategory;

        cursor = sqLiteDatabase.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {
                Soalan soalan = new Soalan();
                soalan.setSoalanId(cursor.getInt(0));
                soalan.setSoalanNo(cursor.getInt(1));
                soalan.setSoalanDesc(cursor.getString(2));
                soalan.setSoalanType(cursor.getInt(3));
                soalan.setSoalanCategory(cursor.getInt(4));

                soalanList.add(soalan);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return soalanList;
    }

    public static List<Soalan> loadSoalanBasedOnType(String soalanType) { // load soalan berdasarkan <param1>
        return null;
    }

    public static List<Soalan> loadSoalanBasedOnRangeAndCategory(int soalanCategory, int range1, int range2) { // load soalan berdasarkan <param1>
        List<Soalan> soalanList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase;
        Cursor cursor;
        String sql;

        sqLiteDatabase = SQLiteDatabase.openDatabase(DBHelper.DB_PATH, null, SQLiteDatabase.OPEN_READONLY);
        sql = "SELECT * FROM Soalan WHERE soalanCategory = " + soalanCategory + " AND ( soalanNo BETWEEN " + range1 + " AND " + range2 + " ) ";

        cursor = sqLiteDatabase.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {
                Soalan soalan = new Soalan();
                soalan.setSoalanId(cursor.getInt(0));
                soalan.setSoalanNo(cursor.getInt(1));
                soalan.setSoalanDesc(cursor.getString(2));
                soalan.setSoalanType(cursor.getInt(3));
                soalan.setSoalanCategory(cursor.getInt(4));

                soalanList.add(soalan);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return soalanList;
    }

    public static List<Soalan> loadSoalanBasedOnKeyArea(String soalanKeyArea) { // load soalan berdasarkan <param1>
        return null;
    }

    public static List<Soalan> loadSoalanBasedOnKeyCategory(String soalanKeyCategory) { // load soalan berdasarkan <param1>
        return null;
    }

    public static List<Soalan> loadSoalanBasedOnCriteria(int soalanType, String soalanKeyArea, String soalanCategory, String soalanKeyCategory) { // load soalan berdasarkan kriteria dlm <param1>, <param2>, <param3> & <param4>
        return null;
    }
}
