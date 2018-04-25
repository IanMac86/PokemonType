package com.example.ian.poketype;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;


public class PokeDex extends AppCompatActivity {

    private ListView listView;
    private RequestQueue mQueue;

    private ArrayList<Pokemon> pokeList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_dex);


        listView = findViewById(R.id.listview_dex);

        mQueue = Volley.newRequestQueue(this);

        pokeList.clear();
        jsonParse();

    }




    private void jsonParse() {
        String url = "https://pastebin.com/raw/tahQmMYA";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("pokemon");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject pokemon = jsonArray.getJSONObject(i);


                                String id = pokemon.getString("id");
                                String name = pokemon.getString("name");
                                String smallImg = pokemon.getString("smallImg");
                                String largeImg = pokemon.getString("largeImg");

                                JSONObject nestObj = pokemon.getJSONObject("types");
                                String type1 = nestObj.getString("type1");
                                String type2 = nestObj.optString("type2");

                                JSONObject nestyObj = pokemon.getJSONObject("Evolutions");
                                String evo1 = nestyObj.getString("evo1");
                                String evo2 = nestyObj.optString("evo2");
                                String evo3 = nestyObj.optString("evo3");
                                String evo4 = nestyObj.optString("evo4");

                                if(type2 == null) {
                                    type2 = "";
                                }
                                if(evo2 == null) {
                                    evo2 = "";
                                }
                                if(evo3 == null) {
                                    evo3 = "";
                                }
                                if(evo4 == null) {
                                    evo4 = "";
                                }

                                Pokemon poke1 = new Pokemon(id, name, smallImg, largeImg, type1, type2, evo1, evo2, evo3, evo4);

                                pokeList.add(poke1);

                                fillListView();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    private void fillListView() {

        CustomAdapter myCustomAdapter = new CustomAdapter(PokeDex.this, pokeList);
        listView.setAdapter(myCustomAdapter);
    }

}