package com.example.hospitalroyal;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ManualActivity extends Activity {
    ArrayList<Body>bodyList;
    private ExpandableListView expLV;
    private ArrayList<String>listPreguntas;
    private ArrayList<String>litsRespuestas;
    private Map<String, ArrayList<String>>mapChild;
    int count = 0;

    RecyclerView recyclerView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elv_child);
        bodyList = new ArrayList<Body>();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        run();
    }

    private void setRecyclerView() {
        try{
            BodyAdapter bodyAdapter=new BodyAdapter(bodyList);
            recyclerView.setAdapter(bodyAdapter);
            recyclerView.setHasFixedSize(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void initData(Question question) {
        bodyList.add(new Body(question.getQuestion(), question.getAnswer()));
    }

    public void run() {
        String language = Locale.getDefault().getLanguage();
        String url;
        switch (language){
            case "es":
                url =getResources().getString(R.string.webService)  + getResources().getString(R.string.esp) + "&id=";
                break;
            default:
                url =getResources().getString(R.string.webService) + getResources().getString(R.string.eng) + "&id=";
                break;
        }
        System.out.println(url);
        connectBD(url);
    }

    private void connectBD(String url){
        String copyUrl = url;
        copyUrl += getResources().getString(R.string.inicio);
        load(url);

        copyUrl = url;
        copyUrl += getResources().getString(R.string.ftp);
        load(copyUrl);

        copyUrl = url;
        copyUrl += getResources().getString(R.string.menu);
        load(copyUrl);

        copyUrl = url;
        copyUrl += getResources().getString(R.string.email);
        load(copyUrl);

    }

    private void load(String url) {
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONArray array = null;
                setRecyclerView();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        array = response.getJSONArray(i);
                        Question question = new Question("" + array.getString(1), "" + array.getString(2));
                        initData(question);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                count ++;
               if(count > 3){
                   setRecyclerView();
               }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getLocalizedMessage());
            }
        }
        );
        RequestQueue servicio = Volley.newRequestQueue(this);
        servicio.add(jsonArrayRequest);
    }
}
