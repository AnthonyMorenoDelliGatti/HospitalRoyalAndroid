package com.example.hospitalroyal;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class ListenerFolder implements View.OnClickListener {
    MenuActivity menuActivity;
    String url;
    public ListenerFolder(String url, MenuActivity menuActivity){
        this.url = url;
        this.menuActivity = menuActivity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        menuActivity.startActivity(intent);
    }
}
