package com.example.hospitalroyal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        ImageView imagenLogo = findViewById(R.id.icono);
        imagenLogo.setImageResource(R.drawable.logo);
        String url = null;
        Button btnNewFolder = findViewById(R.id.btnNewFolder);

        ListenerFolder listener = new ListenerFolder("https://youtu.be/9XFz_uuytrE", this);
        btnNewFolder.setOnClickListener(listener);

        ListenerFolder listener2 = new ListenerFolder("https://youtu.be/iVVkyjsg0i0", this);
        Button b1 = findViewById(R.id.btnDowload);
        b1.setOnClickListener(listener2);

        ListenerFolder listener3 = new ListenerFolder("https://youtu.be/vsz2qULgX9Y", this);
        Button b2 = findViewById(R.id.btnUpload);
        b2.setOnClickListener(listener3);

        ListenerFolder listener4 = new ListenerFolder("https://youtu.be/6nrQuTUmtRI", this);
        Button b3 = findViewById(R.id.btnDelete);
        b3.setOnClickListener(listener4);

        ListenerFolder listener5 = new ListenerFolder("https://youtu.be/LAiWWgDNmcc", this);
        Button b4 = findViewById(R.id.btnModifyName);
        b4.setOnClickListener(listener5);
    }

}
