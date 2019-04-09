package com.midtermmad3125.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.midtermmad3125.R;
import com.midtermmad3125.utils.ReadJSONUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainCityActivity extends AppCompatActivity
{

    private TextView txtCity2;
    private TextView txtLat2;
    private TextView txtLon2;
    private TextView txtPop2;
    private Button btnWeather2;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCity2 = findViewById(R.id.txtCity);
        txtLat2 = findViewById(R.id.txtLat);
        txtLon2 = findViewById(R.id.txtLon);



        processJSON();




    }

    private void processJSON()
    {
        String jsonString = loadJSONFromAsset();

        if(jsonString != null)
        {
            txtCity2.setText("Aqui JSON ");
            try
            {

                txtCity2.setText("Aqui try 1");

                JSONArray mJSONArray = new JSONArray(jsonString);

                txtCity2.setText("Aqui try 2");



                for(int i = 0; i < mJSONArray.length(); i++)
                {
                    JSONObject mJSONObject = mJSONArray.getJSONObject(i);

                    JSONObject mCity = mJSONObject.getJSONObject("city");


                    JSONObject mCountry = mJSONObject.getJSONObject("country");
                    JSONObject mPopulation = mJSONObject.getJSONObject("population");

                    int id = mCity.getInt("id");
                    String name = mCity.getString("name");

                    JSONObject mCord = mCity.getJSONObject("cord");
                    String lat = mCord.getString("lat");
                    String lon = mCord.getString("lon");

                    Integer ctn      =  mJSONObject.getInt("cnt");
                    JSONObject list  =   mJSONObject.getJSONObject("list");



                }



            } catch (JSONException e)
            {
                e.printStackTrace();
            }



        }


    }

    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("moscow_weather.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }






    public void btnWeather(View view)
    {



            Intent mIntent = new Intent(MainCityActivity.this, WeatherListActivity.class);
            startActivity(mIntent);

    }
}
