package com.example.hospitalroyal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteClass extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Actividades
    String sqlUserTable = "CREATE TABLE Users (Name TEXT PRIMARY KEY, "
            + "Password TEXT, Rol TEXT)";
    String sqlLog = "CREATE TABLE Log (Description TEXT, Date DATE, Time TIME, Act TEXT, UserName TEXT)";


    // Constructor de la clase. Podr�amos eliminar los par�metros
    // menos el contexto
    public SQLiteClass(Context contexto, String nombre,
                                 SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creamos la tabla por SQL. Podria ya existir la BD
        db.execSQL(sqlUserTable);
        db.execSQL(sqlLog);
        //Creamos el registro a insertar como objeto ContentValues
        ContentValues admin = new ContentValues();
        admin.put("Name", "admin");
        admin.put("Password", "admin");
        admin.put("Rol", "medico");

        ContentValues user = new ContentValues();
        user.put("Name", "user");
        user.put("Password", "user");
        user.put("Rol", "paciente");
        //Insertamos el registro en la base de datos
        db.insert("Users", null, admin);
        db.insert("Users", null, user);
    }

    @Override
    // S�lo se ejecuta si las versiones son distintas
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la versi�n anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        // Volvemos a crear la tabla
        db.execSQL(sqlUserTable);
    }

}
