package com.example.hospitalroyal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteClass extends SQLiteOpenHelper {

    String sqlTextTable = "CREATE TABLE Text (text TEXT)";

    public SQLiteClass(Context contexto, String nombre,
                                 SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlTextTable);
        ContentValues txt1 = new ContentValues();
        ContentValues txt2 = new ContentValues();
        txt1.put("text", "Manual");
        txt2.put("text", "Demo");
        db.insert("Text", null, txt1);
        db.insert("Text", null, txt2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Text");
        db.execSQL(sqlTextTable);
    }

}
