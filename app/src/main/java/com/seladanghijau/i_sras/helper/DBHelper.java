package com.seladanghijau.i_sras.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "isras.db";
    public static final int DB_VERSION = 1;
    public static String DB_PATH;

    private static Context context;

    // constructor
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        DB_PATH = context.getDatabasePath(DB_NAME).getPath();
        this.context = context;
    }

    // init methods --------------------------------------------------------------------------------
    public void initDB() throws Exception { // initialize db
        if(!checkDBExistence()) { // check samada db dah ada atau belum
            this.getReadableDatabase(); // kalau xda, buat db baru (copy db)
            copyDB();
        }
    }

    private boolean checkDBExistence() { // check if db exist or not
        return context.getDatabasePath(DB_NAME).exists();
    }

    private void copyDB() throws Exception { // copy isras.db from external file to app internal path
        InputStream inputStream;
        OutputStream outputStream;
        int dataLength;

        inputStream = context.getAssets().open(DB_NAME); // secify inputstream toward isras.db file
        outputStream = new FileOutputStream(DB_PATH); // specify outputstream towards app internal path

        // copy isras.db from external file to app internal path
        byte[] buffer = new byte[1024];
        while ((dataLength = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, dataLength);
        }

        // close stream
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
    // ---------------------------------------------------------------------------------------------

    // override methods ----------------------------------------------------------------------------
    public void onCreate(SQLiteDatabase db) {}
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    // ---------------------------------------------------------------------------------------------
}
