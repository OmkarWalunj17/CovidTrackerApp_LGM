package com.example.covid19tracker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private final String URL = "https://data.covid19india.org/state_district_wise.json";
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        requestQueue = Volley.newRequestQueue(this);

        String[] data = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Delhi",
                "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh",
                "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan",
                "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};

        // Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 14:
                        intent = new Intent(MainActivity.this, activity_maha.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, activity_bihar.class);
                        startActivity(intent);
                        break;
                    case 20:
                        intent = new Intent(MainActivity.this, activity_punjab.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, activity_delhi.class);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(MainActivity.this, activity_karnataka.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "No Data Available for the Selected State", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

        });

        // Volley JSON Object Request
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
//                URL, null,
//
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            // Check if response is not null
//                            if (response != null) {
//                                // Get data for Maharashtra
//                                JSONObject maharashtraData = response.getJSONObject("Maharashtra");
//                                JSONObject districtData = maharashtraData.getJSONObject("districtData");
//                                JSONObject Thane = districtData.getJSONObject("Thane");
//
//                                     int active = Thane.getInt("active");
//                                    int confirmed = Thane.getInt("confirmed");
//                                    int deceased = Thane.getInt("deceased");
//                                    int recovered = Thane.getInt("recovered");
//
//                                Toast.makeText(MainActivity.this, "\n Active : " + active + "\n" + confirmed, Toast.LENGTH_LONG).show();
//                                // Clear existing data in dataList
////                                dataList.clear();
//
//                                // Iterate through all districts
////                                Iterator<String> districtKeys = districtData.keys();
////                                while (districtKeys.hasNext()) {
////                                    String districtName = districtKeys.next();
////                                    JSONObject districtInfo = districtData.getJSONObject(districtName);
////
////
////
////                                    // Add district data to the dataList
////                                    dataList.add(new Model(districtName, active, confirmed, deceased, recovered));
////                                }
////
////                                // Notify the adapter that the data has changed
////                                CovidAdapter adapter = new CovidAdapter(MainActivity.this, dataList);
//////                                listView.setAdapter(adapter);
//////                                adapter.notifyDataSetChanged();
//                            }
//                        } catch (JSONException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        Log.d("myapp", "Something is wrong !");
//                        Toast.makeText(MainActivity.this, "Error fetching data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//
//        requestQueue.add(jsonObjectRequest);
    }
}
