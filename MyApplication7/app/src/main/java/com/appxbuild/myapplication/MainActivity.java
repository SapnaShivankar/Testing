package com.appxbuild.myapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;


public  class MainActivity extends Activity implements OnItemClickListener {

    ListView lview3;
    ListViewCustomAdapter adapter;
    private ArrayList<Object> itemList;
    private ItemBean1 bean1;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareArrayLits();
        lview3 = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewCustomAdapter(this, itemList);
        lview3.setAdapter(adapter);

        lview3.setOnItemClickListener(this);

    }

        @Override
        public void onItemClick (AdapterView < ? > arg0, View arg1,int position, long id){
            //  TODO Auto-generated method stub
            ItemBean1 bean1 = (ItemBean1) adapter.getItem(position);
            Toast.makeText(this, "Title => " + bean1.getTitle() + "  Description => " + bean1.getDescription(), Toast.LENGTH_SHORT).show();
        }


    /* Method used to prepare the ArrayList,
     * Same way, you can also do looping and adding object into the ArrayList.
     */

    public void prepareArrayLits()
    {
        itemList = new ArrayList<Object>();

//        AddObjectToList(R.drawable.add, "Karishma", "Roll no 1");
//        AddObjectToList(R.drawable.delete, "ABC", "Roll no 2");
//        AddObjectToList(R.drawable.down, "PQR", "Roll no 3");
//        AddObjectToList(R.drawable.info, "XYZ", "Roll no 4");
//        AddObjectToList(R.drawable.help, "abc", "Roll no 5");
//        AddObjectToList(R.drawable.download, "pqr", "Roll no 5");
//        AddObjectToList(R.drawable.mail, "xyz", "Roll no 6");
//        AddObjectToList(R.drawable.search, "qwe", "Roll no 7");
//        AddObjectToList(R.drawable.settings, "asd", "Roll no 8");

        final String url = "http://192.168.2.5/stu/students.json";

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
                               // System.out.println("Photo" + jsonArray.getJSONObject(i).getString("photourl"));
                                AddObjectToList(R.drawable.add, jsonArray.getJSONObject(i).getString("name"), jsonArray.getJSONObject(i).getString("photourl"));

                            }

                            adapter.notifyDataSetChanged();
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





    // Add one item into the Array List
    public void AddObjectToList(int image, String title, String desc)
    {
        bean1 = new ItemBean1();
        bean1.setDescription(desc);
        bean1.setImage(image);
        bean1.setTitle(title);
        itemList.add(bean1);
    }
}