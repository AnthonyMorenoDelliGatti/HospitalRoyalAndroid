package com.example.hospitalroyal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MenuActivity extends Activity implements View.OnClickListener {

    Button btnNewFolder, btnDowload, btnUpload, btnDelete, btnModifyName, btnSendEmail;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        ImageView imagenLogo = findViewById(R.id.icono);
        imagenLogo.setImageResource(R.drawable.logo);
        btnNewFolder = findViewById(R.id.btnNewFolder);
        btnNewFolder.setOnClickListener(this);
        btnDowload = findViewById(R.id.btnDowload);
        btnDowload.setOnClickListener(this);
        btnUpload = findViewById(R.id.btnUpload);
        btnUpload.setOnClickListener(this);
        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
        btnModifyName = findViewById(R.id.btnModifyName);
        btnModifyName.setOnClickListener(this);
        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnSendEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnNewFolder.getId()){
            String url = "https://www.youtube.com/watch?v=kuzAZ4eQ08c";
            startVideo(url);
        }else if(v.getId()==btnDowload.getId()){

        }else if(v.getId()==btnUpload.getId()){

        }else if(v.getId()==btnDelete.getId()){

        }else if(v.getId()==btnModifyName.getId()){

        }else if(v.getId()==btnSendEmail.getId()){

        }
    }

    private void startVideo(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
