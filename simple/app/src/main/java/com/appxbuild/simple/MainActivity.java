package com.appxbuild.simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* TextView mTxtDisplay;
        ImageView mImageView;

        mTxtDisplay = (TextView) findViewById(R.id.txtDisplay);*/
        String url = "http://192.168.2.4/stu/students.json";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println("Response: " + response.toString());
                        try{
                        JSONArray jsonArray = response.getJSONArray("students");
                            for(int i =0; i<jsonArray.length();i++)
                            {
                                System.out.println("name" + jsonArray.getJSONObject(i).getString("name"));
                                System.out.println("Photo" + jsonArray.getJSONObject(i).getString("photourl"));
                            }
                        }
                        catch (Exception e)
                        {

                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        System.out.println("Response: " + error.toString());
                    }
                });

// Access the RequestQueue through your singleton class.
        Volley.newRequestQueue(this).add(jsObjRequest);


    }
}
