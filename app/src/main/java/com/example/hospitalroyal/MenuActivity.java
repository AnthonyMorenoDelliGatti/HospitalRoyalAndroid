package com.example.hospitalroyal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class MenuActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        ImageView imagenLogo = findViewById(R.id.icono);
        imagenLogo.setImageResource(R.drawable.logo);
    }
}
