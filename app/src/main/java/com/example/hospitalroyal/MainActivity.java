package com.example.hospitalroyal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texts = new ArrayList<>();
        ImageView imagenLogo = findViewById(R.id.icono);
        imagenLogo.setImageResource(R.drawable.logo);
        getSupportActionBar().hide();
        Button btnDemo = findViewById(R.id.btnDemo);
        Button btnManual = findViewById(R.id.btnManual);
        SQLiteClass bdHospitalRoyal = new SQLiteClass(MainActivity.this, "BDText", null, 1);
        SQLiteDatabase db = bdHospitalRoyal.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Text", null);
        //Recorremos el cursor hasta que no haya más registros
        c.moveToFirst();
        while (c.moveToNext()) {
            texts.add(c.getString(c.getColumnIndex("Text")));
        }
        //Cerramos la base de datos
        db.close();

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        btnManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}