package com.example.hospitalroyal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends Activity implements View.OnClickListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        ImageView imagenLogo = findViewById(R.id.icono);
        imagenLogo.setImageResource(R.drawable.logo);
        Button btnNewFolder = findViewById(R.id.btnNewFolder);
        btnNewFolder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String url = "https://www.youtube.com/watch?v=kuzAZ4eQ08c";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
