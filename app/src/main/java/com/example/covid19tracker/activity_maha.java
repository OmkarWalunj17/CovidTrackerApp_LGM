package com.example.covid19tracker;

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

import org.json.JSONException;
import org.json.JSONObject;

public class activity_maha extends AppCompatActivity {

    private final String URL = "https://data.covid19india.org/state_district_wise.json";
    private ListView maharashtra;
    public  RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maha);

        String[] maharashtraDistricts = {"Ahmednagar", "Akola", "Amravati", "Aurangabad", "Beed",
                "Bhandara", "Buldhana", "Chandrapur", "Dhule", "Gadchiroli", "Gondia", "Hingoli", "Jalgaon",
                "Jalna", "Kolhapur", "Latur", "Mumbai", "Nagpur", "Nanded", "Nandurbar", "Nashik", "Osmanabad",
                "Palghar", "Parbhani", "Pune", "Raigad", "Ratnagiri", "Sangli", "Satara", "Sindhudurg", "Solapur",
                "Thane", "Wardha", "Washim", "Yavatmal"};

        maharashtra = findViewById(R.id.mahalist);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, maharashtraDistricts);
        maharashtra.setAdapter(adapter);

        maharashtra.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected district name
                String selectedDistrict = maharashtraDistricts[position];

                // Show a toast with the selected district name
                Toast.makeText(activity_maha.this,
                        "Selected District: " + selectedDistrict,
                        Toast.LENGTH_SHORT).show();

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject maharashtraState = response.getJSONObject("Maharashtra");

                                    JSONObject districtData = maharashtraState.getJSONObject("districtData");

                                    JSONObject thaneData = districtData.getJSONObject("Thane");

                                    int activeCases = thaneData.getInt("active");
                                    int confirmedCases = thaneData.getInt("confirmed");
                                    int recoveredCases = thaneData.getInt("recovered");

                                    // Display the data in a toast or update UI accordingly
                                    String message = "District: " + selectedDistrict +
                                            "\nActive Cases: " + activeCases +
                                            "\nConfirmed Cases: " + confirmedCases +
                                            "\nRecovered Cases: " + recoveredCases;
                                    Toast.makeText(activity_maha.this, message, Toast.LENGTH_LONG).show();

                                    Log.d( "myapp",  "Resposnse: "  + "\n" + activeCases + "\n" + confirmedCases + "\n" + recoveredCases);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(activity_maha.this, "Error parsing JSON", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(activity_maha.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                            }
                        });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}
