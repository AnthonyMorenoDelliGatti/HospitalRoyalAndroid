package com.example.hospitalroyal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imagenLogo = findViewById(R.id.icono);
        imagenLogo.setImageResource(R.drawable.logo);
        getSupportActionBar().hide();
        Button btnDemo = findViewById(R.id.btnDemo);
        Button btnManual = findViewById(R.id.btnManual);

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*SQLiteClass bdHospitalRoyal = new SQLiteClass(LoginActivity.this, "BDUsers", null, 1);
                SQLiteDatabase db = bdHospitalRoyal.getWritableDatabase();
                String textUser = textUserName.getText().toString();
                String textPass = textPassword.getText().toString();
                //Consultamos el registro en la base de datos

                Cursor c = db.rawQuery(" SELECT * FROM Users WHERE Name='" + textUser + "'" +
                        " AND Password='" + textPass + "'", null);

                //Nos aseguramos de que existe al menos un registro
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        Intent intent = new Intent(v.getContext(),MenuActivity.class);
                        finish();
                        startActivity(intent);
                    } while (c.moveToNext());
                }else{
                    Toast.makeText(getApplicationContext(), "The user does not exist or the password is incorrect", Toast.LENGTH_SHORT).show();
                    textPassword.setText("");
                    textUserName.setText("");
                }
                //Cerramos la base de datos
                db.close();*/
                Intent intent = new Intent(v.getContext(),MenuActivity.class);
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