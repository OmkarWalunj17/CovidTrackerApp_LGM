//package com.example.covid19tracker;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//
//public class DistrictActivity extends AppCompatActivity {
//
//        private ListView districtListView;
//        private List<String> districtList;
//        private ArrayAdapter<String> adapter;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_districts);
//
//            districtListView = findViewById(R.id.districtView);
//            districtList = new ArrayList<>();
//            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, districtList);
//            districtListView.setAdapter(adapter);
//
//            Intent intent = getIntent();
//            String selectedState = intent.getStringExtra("STATE_NAME");
//
//            fetchDistricts(selectedState);
//        }
//
//    private void fetchDistricts(String selectedState) {
//        String districtUrl = "https://data.covid19india.org/state_district_wise.json"; // Replace with your actual API endpoint
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
//                districtUrl, null,
//
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONObject stateObject = response.getJSONObject(selectedState);
//                            JSONObject districtDataObject = stateObject.getJSONObject("districtData");
//
//                            Iterator<String> keys = districtDataObject.keys();
//                            while (keys.hasNext()) {
//                                String districtName = keys.next();
//                                districtList.add(districtName);
//                            }
//
//                            adapter.notifyDataSetChanged();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("DistrictActivity", "Error fetching district data: " + error.getMessage());
//                        // Handle error
//                    }
//                }
//        );
//
//        // Add the request to the RequestQueue
//        Volley.newRequestQueue(this).add(jsonObjectRequest);
//    }
//
//}
//
