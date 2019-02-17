package com.shadhinsoft.weatherui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {

    TextView t1_temp;
    TextView t3_description;
    TextView t4_date;
    TextView t5_time;
    TextView today_air_humidity;
    TextView t_sunset;
    TextView t_sunrise;
    TextView today_wind_speed;
    TextView today_wind_deg;
    TextView today_pressure;
    TextView day_today_min, day_today_max, day_next1_min, day_next1_max, day_next2_min, day_next2_max, day_next3_min, day_next3_max, day_next4_min, day_next4_max, day_next5_min, day_next5_max, day_next6_min, day_next6_max, day_next7_min, day_next7_max;
    TextView t_wind_deg, rain_probability, t_city, desh;
    //bar
    TextView day_today, t_day_next1, t_day_next2, t_day_next3, t_day_next4, t_day_next5, t_day_next6, t_day_next7;
    //hourly forecast
    //temp
    TextView getT_houtly_0, getT_houtly_1, getT_houtly_2, getT_houtly_3, getT_houtly_4, getT_houtly_5, getT_houtly_6, getT_houtly_7, getT_houtly_8, getT_houtly_9, getT_houtly_10, getT_houtly_11, getT_houtly_12, getT_houtly_13, getT_houtly_14, getT_houtly_15, getT_houtly_16, getT_houtly_17, getT_houtly_18, getT_houtly_19, getT_houtly_20, getT_houtly_21, getT_houtly_22, getT_houtly_23, getT_houtly_24;
    //time
    TextView time_get_0, time_get_1, time_get_2, time_get_3, time_get_4, time_get_5, time_get_6, time_get_7, time_get_8, time_get_9, time_get_10, time_get_11, time_get_12, time_get_13, time_get_14, time_get_15, time_get_16, time_get_17, time_get_18, time_get_19, time_get_20, time_get_21, time_get_22, time_get_23, time_get_24;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make a full_screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Linking ID
        rain_probability = (TextView) findViewById(R.id.today_rian);
        day_today_max = (TextView) findViewById(R.id.today_max_tm);
        day_today_min = (TextView) findViewById(R.id.today_min_tm);
        t_wind_deg = (TextView) findViewById(R.id.today_wind_deg);
        day_next1_max = (TextView) findViewById(R.id.next1_max_tm);
        day_next1_min = (TextView) findViewById(R.id.next1_min_tm);
        day_next2_max = (TextView) findViewById(R.id.next2_max_tm);
        day_next2_min = (TextView) findViewById(R.id.next2_min_tm);
        day_next3_max = (TextView) findViewById(R.id.next3_max_tm);
        day_next3_min = (TextView) findViewById(R.id.next3_min_tm);
        day_next4_max = (TextView) findViewById(R.id.next4_max_tm);
        day_next4_min = (TextView) findViewById(R.id.next4_min_tm);
        day_next5_max = (TextView) findViewById(R.id.next5_max_tm);
        day_next5_min = (TextView) findViewById(R.id.next5_min_tm);
        day_next6_max = (TextView) findViewById(R.id.next6_max_tm);
        day_next6_min = (TextView) findViewById(R.id.next6_min_tm);
        day_next7_max = (TextView) findViewById(R.id.next7_max_tm);
        day_next7_min = (TextView) findViewById(R.id.next7_min_tm);
        t1_temp = (TextView) findViewById(R.id.tempreture);
        t_city = (TextView) findViewById(R.id.my_city);
        desh = (TextView) findViewById(R.id.country);
        t3_description = (TextView) findViewById(R.id.description);
        t4_date = (TextView) findViewById(R.id.date);
        t5_time = (TextView) findViewById(R.id.time);
        today_air_humidity = (TextView) findViewById(R.id.today_air_humidity);
        t_sunrise = (TextView) findViewById(R.id.today_sunrise);
        t_sunset = (TextView) findViewById(R.id.today_sunset);
        today_wind_speed = (TextView) findViewById(R.id.today_wind_speed);
        //today_wind_deg = (TextView) findViewById(R.id.today_wind_deg);
        today_pressure = (TextView) findViewById(R.id.today_pressure);


        //dailly forecast
        day_today = (TextView) findViewById(R.id.day_today);
        t_day_next1 = (TextView) findViewById(R.id.day_next1);
        t_day_next2 = (TextView) findViewById(R.id.day_next2);
        t_day_next3 = (TextView) findViewById(R.id.day_next3);
        t_day_next4 = (TextView) findViewById(R.id.day_next4);
        t_day_next5 = (TextView) findViewById(R.id.day_next5);
        t_day_next6 = (TextView) findViewById(R.id.day_next6);
        t_day_next7 = (TextView) findViewById(R.id.day_next7);



        //hourly forecast
        getT_houtly_0 = (TextView) findViewById(R.id.tm_0);
        getT_houtly_1 = (TextView) findViewById(R.id.tm_1);
        getT_houtly_2 = (TextView) findViewById(R.id.tm_2);
        getT_houtly_3 = (TextView) findViewById(R.id.tm_3);
        getT_houtly_4 = (TextView) findViewById(R.id.tm_4);
        getT_houtly_5 = (TextView) findViewById(R.id.tm_5);
        getT_houtly_6 = (TextView) findViewById(R.id.tm_6);
        getT_houtly_7 = (TextView) findViewById(R.id.tm_7);
        getT_houtly_8 = (TextView) findViewById(R.id.tm_8);
        getT_houtly_9 = (TextView) findViewById(R.id.tm_9);
        getT_houtly_10 = (TextView) findViewById(R.id.tm_10);
        getT_houtly_11 = (TextView) findViewById(R.id.tm_11);
        getT_houtly_12 = (TextView) findViewById(R.id.tm_12);
        getT_houtly_13 = (TextView) findViewById(R.id.tm_13);
        getT_houtly_14 = (TextView) findViewById(R.id.tm_14);
        getT_houtly_15 = (TextView) findViewById(R.id.tm_15);
        getT_houtly_16 = (TextView) findViewById(R.id.tm_16);
        getT_houtly_17 = (TextView) findViewById(R.id.tm_17);
        getT_houtly_18 = (TextView) findViewById(R.id.tm_18);
        getT_houtly_19 = (TextView) findViewById(R.id.tm_19);
        getT_houtly_20 = (TextView) findViewById(R.id.tm_20);
        getT_houtly_21 = (TextView) findViewById(R.id.tm_21);
        getT_houtly_22 = (TextView) findViewById(R.id.tm_22);
        getT_houtly_23 = (TextView) findViewById(R.id.tm_23);
        getT_houtly_24 = (TextView) findViewById(R.id.tm_24);

        //time
        time_get_0 = (TextView) findViewById(R.id.time_0);
        time_get_1 = (TextView) findViewById(R.id.time_1);
        time_get_2 = (TextView) findViewById(R.id.time_2);
        time_get_3 = (TextView) findViewById(R.id.time_3);
        time_get_4 = (TextView) findViewById(R.id.time_4);
        time_get_5 = (TextView) findViewById(R.id.time_5);
        time_get_6 = (TextView) findViewById(R.id.time_6);
        time_get_7 = (TextView) findViewById(R.id.time_7);
        time_get_8 = (TextView) findViewById(R.id.time_8);
        time_get_9 = (TextView) findViewById(R.id.time_9);
        time_get_10 = (TextView) findViewById(R.id.time_10);
        time_get_11 = (TextView) findViewById(R.id.time_11);
        time_get_12 = (TextView) findViewById(R.id.time_12);
        time_get_13 = (TextView) findViewById(R.id.time_13);
        time_get_14 = (TextView) findViewById(R.id.time_14);
        time_get_15 = (TextView) findViewById(R.id.time_15);
        time_get_16 = (TextView) findViewById(R.id.time_16);
        time_get_17 = (TextView) findViewById(R.id.time_17);
        time_get_18 = (TextView) findViewById(R.id.time_18);
        time_get_19 = (TextView) findViewById(R.id.time_19);
        time_get_20 = (TextView) findViewById(R.id.time_20);
        time_get_21 = (TextView) findViewById(R.id.time_21);
        time_get_22 = (TextView) findViewById(R.id.time_22);
        time_get_23 = (TextView) findViewById(R.id.time_23);
        time_get_24 = (TextView) findViewById(R.id.time_24);



        find_weather();
        openweathermap_API();

    }

    public void openweathermap_API(){

        //openweathermap_API
        String url2 = "https://api.openweathermap.org/data/2.5/weather?appid=0240bd25f2d8cd47e72f44a72e3956a3&q=dhaka,%20bd";
        JsonObjectRequest jor2 = new JsonObjectRequest(Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject main_objet = response.getJSONObject("sys");

                    String t_counrty = String.valueOf(main_objet.getString("country"));
                    String city = response.getString("name");

                    desh.setText(t_counrty);
                    t_city.setText(city);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue queue2 = Volley.newRequestQueue(this);
        queue2.add(jor2);
    }

    public void find_weather() {
        //darksky_API
        String url = "https://api.darksky.net/forecast/737a0e6c28452a63589dd0bd7d1c1e12/24.9,91.86/?units=si";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener <JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    //Hourlly_forecast_Start
                    JSONObject hourly_object = response.getJSONObject("hourly");

                    JSONArray array_object = hourly_object.getJSONArray("data");

                    JSONObject hourly_main_0 = array_object.getJSONObject(0);
                    JSONObject hourly_main_1 = array_object.getJSONObject(1);
                    JSONObject hourly_main_2 = array_object.getJSONObject(2);
                    JSONObject hourly_main_3 = array_object.getJSONObject(3);
                    JSONObject hourly_main_4 = array_object.getJSONObject(4);
                    JSONObject hourly_main_5 = array_object.getJSONObject(5);
                    JSONObject hourly_main_6 = array_object.getJSONObject(6);
                    JSONObject hourly_main_7 = array_object.getJSONObject(7);
                    JSONObject hourly_main_8 = array_object.getJSONObject(8);
                    JSONObject hourly_main_9 = array_object.getJSONObject(9);
                    JSONObject hourly_main_10 = array_object.getJSONObject(10);
                    JSONObject hourly_main_11 = array_object.getJSONObject(11);
                    JSONObject hourly_main_12 = array_object.getJSONObject(12);
                    JSONObject hourly_main_13 = array_object.getJSONObject(13);
                    JSONObject hourly_main_14 = array_object.getJSONObject(14);
                    JSONObject hourly_main_15 = array_object.getJSONObject(15);
                    JSONObject hourly_main_16 = array_object.getJSONObject(16);
                    JSONObject hourly_main_17 = array_object.getJSONObject(17);
                    JSONObject hourly_main_18 = array_object.getJSONObject(18);
                    JSONObject hourly_main_19 = array_object.getJSONObject(19);
                    JSONObject hourly_main_20 = array_object.getJSONObject(20);
                    JSONObject hourly_main_21 = array_object.getJSONObject(21);
                    JSONObject hourly_main_22 = array_object.getJSONObject(22);
                    JSONObject hourly_main_23 = array_object.getJSONObject(23);
                    JSONObject hourly_main_24 = array_object.getJSONObject(24);

                    //hourly forecast TEMP start

                    String hourlt_0 = String.valueOf(hourly_main_0.getDouble("temperature"));
                    String hourlt_1 = String.valueOf(hourly_main_1.getDouble("temperature"));
                    String hourlt_2 = String.valueOf(hourly_main_2.getDouble("temperature"));
                    String hourlt_3 = String.valueOf(hourly_main_3.getDouble("temperature"));
                    String hourlt_4 = String.valueOf(hourly_main_4.getDouble("temperature"));
                    String hourlt_5 = String.valueOf(hourly_main_5.getDouble("temperature"));
                    String hourlt_6 = String.valueOf(hourly_main_6.getDouble("temperature"));
                    String hourlt_7 = String.valueOf(hourly_main_7.getDouble("temperature"));
                    String hourlt_8 = String.valueOf(hourly_main_8.getDouble("temperature"));
                    String hourlt_9 = String.valueOf(hourly_main_9.getDouble("temperature"));
                    String hourlt_10 = String.valueOf(hourly_main_10.getDouble("temperature"));
                    String hourlt_11 = String.valueOf(hourly_main_11.getDouble("temperature"));
                    String hourlt_12 = String.valueOf(hourly_main_12.getDouble("temperature"));
                    String hourlt_13 = String.valueOf(hourly_main_13.getDouble("temperature"));
                    String hourlt_14 = String.valueOf(hourly_main_14.getDouble("temperature"));
                    String hourlt_15 = String.valueOf(hourly_main_15.getDouble("temperature"));
                    String hourlt_16 = String.valueOf(hourly_main_16.getDouble("temperature"));
                    String hourlt_17 = String.valueOf(hourly_main_17.getDouble("temperature"));
                    String hourlt_18 = String.valueOf(hourly_main_18.getDouble("temperature"));
                    String hourlt_19 = String.valueOf(hourly_main_19.getDouble("temperature"));
                    String hourlt_20 = String.valueOf(hourly_main_20.getDouble("temperature"));
                    String hourlt_21 = String.valueOf(hourly_main_21.getDouble("temperature"));
                    String hourlt_22 = String.valueOf(hourly_main_22.getDouble("temperature"));
                    String hourlt_23 = String.valueOf(hourly_main_23.getDouble("temperature"));
                    String hourlt_24 = String.valueOf(hourly_main_24.getDouble("temperature"));


                    //0
                    double temp_hourly_0 = Double.parseDouble(hourlt_0);
                    double c_h_0 = temp_hourly_0;
                    int i_h_0 = (int)c_h_0;
                    getT_houtly_0.setText(String.valueOf(i_h_0));

                    //1
                    double temp_hourly_1 = Double.parseDouble(hourlt_1);
                    double c_h_1 = temp_hourly_1;
                    int i_h_1 = (int)c_h_1;
                    getT_houtly_1.setText(String.valueOf(i_h_1));

                    //2
                    double temp_hourly_2 = Double.parseDouble(hourlt_2);
                    double c_h_2 = temp_hourly_2;
                    int i_h_2 = (int)c_h_2;
                    getT_houtly_2.setText(String.valueOf(i_h_2));

                    //3
                    double temp_hourly_3 = Double.parseDouble(hourlt_3);
                    double c_h_3 = temp_hourly_3;
                    int i_h_3 = (int)c_h_3;
                    getT_houtly_3.setText(String.valueOf(i_h_3));

                    //4
                    double temp_hourly_4 = Double.parseDouble(hourlt_4);
                    double c_h_4 = temp_hourly_4;
                    int i_h_4 = (int)c_h_4;
                    getT_houtly_4.setText(String.valueOf(i_h_4));

                    //5
                    double temp_hourly_5 = Double.parseDouble(hourlt_5);
                    double c_h_5 = temp_hourly_5;
                    int i_h_5 = (int)c_h_5;
                    getT_houtly_5.setText(String.valueOf(i_h_5));

                    //6
                    double temp_hourly_6 = Double.parseDouble(hourlt_6);
                    double c_h_6 = temp_hourly_6;
                    int i_h_6 = (int)c_h_6;
                    getT_houtly_6.setText(String.valueOf(i_h_6));

                    //7
                    double temp_hourly_7 = Double.parseDouble(hourlt_7);
                    double c_h_7 = temp_hourly_7;
                    int i_h_7 = (int)c_h_7;
                    getT_houtly_7.setText(String.valueOf(i_h_7));

                    //8
                    double temp_hourly_8 = Double.parseDouble(hourlt_8);
                    double c_h_8 = temp_hourly_8;
                    int i_h_8 = (int)c_h_8;
                    getT_houtly_8.setText(String.valueOf(i_h_8));

                    //9
                    double temp_hourly_9 = Double.parseDouble(hourlt_9);
                    double c_h_9 = temp_hourly_9;
                    int i_h_9 = (int)c_h_9;
                    getT_houtly_9.setText(String.valueOf(i_h_9));

                    //10
                    double temp_hourly_10 = Double.parseDouble(hourlt_10);
                    double c_h_10 = temp_hourly_10;
                    int i_h_10 = (int)c_h_10;
                    getT_houtly_10.setText(String.valueOf(i_h_10));

                    //11
                    double temp_hourly_11 = Double.parseDouble(hourlt_11);
                    double c_h_11 = temp_hourly_11;
                    int i_h_11 = (int)c_h_11;
                    getT_houtly_11.setText(String.valueOf(i_h_11));

                    //12
                    double temp_hourly_12 = Double.parseDouble(hourlt_12);
                    double c_h_12 = temp_hourly_12;
                    int i_h_12 = (int)c_h_12;
                    getT_houtly_12.setText(String.valueOf(i_h_12));

                    //13
                    double temp_hourly_13 = Double.parseDouble(hourlt_13);
                    double c_h_13 = temp_hourly_13;
                    int i_h_13 = (int)c_h_13;
                    getT_houtly_13.setText(String.valueOf(i_h_13));

                    //14
                    double temp_hourly_14 = Double.parseDouble(hourlt_14);
                    double c_h_14 = temp_hourly_14;
                    int i_h_14 = (int)c_h_14;
                    getT_houtly_14.setText(String.valueOf(i_h_14));

                    //15
                    double temp_hourly_15 = Double.parseDouble(hourlt_15);
                    double c_h_15 = temp_hourly_15;
                    int i_h_15 = (int)c_h_15;
                    getT_houtly_15.setText(String.valueOf(i_h_15));

                    //16
                    double temp_hourly_16 = Double.parseDouble(hourlt_16);
                    double c_h_16 = temp_hourly_16;
                    int i_h_16 = (int)c_h_16;
                    getT_houtly_16.setText(String.valueOf(i_h_16));

                    //17
                    double temp_hourly_17 = Double.parseDouble(hourlt_17);
                    double c_h_17 = temp_hourly_17;
                    int i_h_17 = (int)c_h_17;
                    getT_houtly_17.setText(String.valueOf(i_h_17));

                    //18
                    double temp_hourly_18 = Double.parseDouble(hourlt_18);
                    double c_h_18 = temp_hourly_18;
                    int i_h_18 = (int)c_h_18;
                    getT_houtly_18.setText(String.valueOf(i_h_18));

                    //19
                    double temp_hourly_19 = Double.parseDouble(hourlt_19);
                    double c_h_19 = temp_hourly_19;
                    int i_h_19 = (int)c_h_19;
                    getT_houtly_19.setText(String.valueOf(i_h_19));

                    //20
                    double temp_hourly_20 = Double.parseDouble(hourlt_20);
                    double c_h_20 = temp_hourly_20;
                    int i_h_20 = (int)c_h_20;
                    getT_houtly_20.setText(String.valueOf(i_h_20));

                    //21
                    double temp_hourly_21 = Double.parseDouble(hourlt_21);
                    double c_h_21 = temp_hourly_21;
                    int i_h_21 = (int)c_h_21;
                    getT_houtly_21.setText(String.valueOf(i_h_21));

                    //22
                    double temp_hourly_22 = Double.parseDouble(hourlt_22);
                    double c_h_22 = temp_hourly_22;
                    int i_h_22 = (int)c_h_22;
                    getT_houtly_22.setText(String.valueOf(i_h_22));

                    //23
                    double temp_hourly_23 = Double.parseDouble(hourlt_23);
                    double c_h_23 = temp_hourly_23;
                    int i_h_23 = (int)c_h_23;
                    getT_houtly_23.setText(String.valueOf(i_h_23));

                    //24
                    double temp_hourly_24 = Double.parseDouble(hourlt_24);
                    double c_h_24 = temp_hourly_24;
                    int i_h_24 = (int)c_h_24;
                    getT_houtly_24.setText(String.valueOf(i_h_24));
                    //hourly forecast TEMP end

                    //hourly forecast TIME start
                    String h_time_0 = String.valueOf(hourly_main_0.getDouble("time"));
                    String h_time_1 = String.valueOf(hourly_main_1.getDouble("time"));
                    String h_time_2 = String.valueOf(hourly_main_2.getDouble("time"));
                    String h_time_3 = String.valueOf(hourly_main_3.getDouble("time"));
                    String h_time_4 = String.valueOf(hourly_main_4.getDouble("time"));
                    String h_time_5 = String.valueOf(hourly_main_5.getDouble("time"));
                    String h_time_6 = String.valueOf(hourly_main_6.getDouble("time"));
                    String h_time_7 = String.valueOf(hourly_main_7.getDouble("time"));
                    String h_time_8 = String.valueOf(hourly_main_8.getDouble("time"));
                    String h_time_9 = String.valueOf(hourly_main_9.getDouble("time"));
                    String h_time_10 = String.valueOf(hourly_main_10.getDouble("time"));
                    String h_time_11 = String.valueOf(hourly_main_11.getDouble("time"));
                    String h_time_12 = String.valueOf(hourly_main_12.getDouble("time"));
                    String h_time_13 = String.valueOf(hourly_main_13.getDouble("time"));
                    String h_time_14 = String.valueOf(hourly_main_14.getDouble("time"));
                    String h_time_15 = String.valueOf(hourly_main_15.getDouble("time"));
                    String h_time_16 = String.valueOf(hourly_main_16.getDouble("time"));
                    String h_time_17 = String.valueOf(hourly_main_17.getDouble("time"));
                    String h_time_18 = String.valueOf(hourly_main_18.getDouble("time"));
                    String h_time_19 = String.valueOf(hourly_main_19.getDouble("time"));
                    String h_time_20 = String.valueOf(hourly_main_20.getDouble("time"));
                    String h_time_21 = String.valueOf(hourly_main_21.getDouble("time"));
                    String h_time_22 = String.valueOf(hourly_main_22.getDouble("time"));
                    String h_time_23 = String.valueOf(hourly_main_23.getDouble("time"));
                    String h_time_24 = String.valueOf(hourly_main_24.getDouble("time"));



                    //time_0
                    double time_h_0 = Double.parseDouble(h_time_0);
                    double centi_h_0 = time_h_0;
                    centi_h_0 = Math.round(centi_h_0);
                    int  nt_h_0 = (int) centi_h_0;

                    long long_h_0 = nt_h_0;
                    Date date_h_0 = new Date(long_h_0 * 1000L);
                    SimpleDateFormat jdf_h_0 = new SimpleDateFormat("hh:mm a");
                    jdf_h_0.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_0 = jdf_h_0.format(date_h_0);
                    time_get_0.setText(java_dare_h_0);

                    //time_1
                    double time_h_1 = Double.parseDouble(h_time_1);
                    double centi_h_1 = time_h_1;
                    centi_h_1 = Math.round(centi_h_1);
                    int  nt_h_1 = (int) centi_h_1;

                    long long_h_1 = nt_h_1;
                    Date date_h_1 = new Date(long_h_1 * 1000L);
                    SimpleDateFormat jdf_h_1 = new SimpleDateFormat("hh:mm a");
                    jdf_h_1.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_1 = jdf_h_1.format(date_h_1);
                    time_get_1.setText(java_dare_h_1);

                    //time_2
                    double time_h_2 = Double.parseDouble(h_time_2);
                    double centi_h_2 = time_h_2;
                    centi_h_2 = Math.round(centi_h_2);
                    int  nt_h_2 = (int) centi_h_2;

                    long long_h_2 = nt_h_2;
                    Date date_h_2 = new Date(long_h_2 * 1000L);
                    SimpleDateFormat jdf_h_2 = new SimpleDateFormat("hh:mm a");
                    jdf_h_2.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_2 = jdf_h_2.format(date_h_2);
                    time_get_2.setText(java_dare_h_2);

                    //time_3
                    double time_h_3 = Double.parseDouble(h_time_3);
                    double centi_h_3 = time_h_3;
                    centi_h_3 = Math.round(centi_h_3);
                    int  nt_h_3 = (int) centi_h_3;

                    long long_h_3 = nt_h_3;
                    Date date_h_3 = new Date(long_h_3 * 1000L);
                    SimpleDateFormat jdf_h_3 = new SimpleDateFormat("hh:mm a");
                    jdf_h_3.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_3 = jdf_h_3.format(date_h_3);
                    time_get_3.setText(java_dare_h_3);

                    //4
                    double time_h_4 = Double.parseDouble(h_time_4);
                    double centi_h_4 = time_h_4;
                    centi_h_4 = Math.round(centi_h_4);
                    int  nt_h_4 = (int) centi_h_4;

                    long long_h_4 = nt_h_4;
                    Date date_h_4 = new Date(long_h_4 * 1000L);
                    SimpleDateFormat jdf_h_4 = new SimpleDateFormat("hh:mm a");
                    jdf_h_4.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_4 = jdf_h_4.format(date_h_4);
                    time_get_4.setText(java_dare_h_4);

                    //time_5
                    double time_h_5 = Double.parseDouble(h_time_5);
                    double centi_h_5 = time_h_5;
                    centi_h_5 = Math.round(centi_h_5);
                    int  nt_h_5 = (int) centi_h_5;

                    long long_h_5 = nt_h_5;
                    Date date_h_5 = new Date(long_h_5 * 1000L);
                    SimpleDateFormat jdf_h_5 = new SimpleDateFormat("hh:mm a");
                    jdf_h_5.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_5 = jdf_h_5.format(date_h_5);
                    time_get_5.setText(java_dare_h_5);


                    //6
                    double time_h_6 = Double.parseDouble(h_time_6);
                    double centi_h_6 = time_h_6;
                    centi_h_6 = Math.round(centi_h_6);
                    int  nt_h_6 = (int) centi_h_6;

                    long long_h_6 = nt_h_6;
                    Date date_h_6 = new Date(long_h_6 * 1000L);
                    SimpleDateFormat jdf_h_6 = new SimpleDateFormat("hh:mm a");
                    jdf_h_6.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_6 = jdf_h_6.format(date_h_6);
                    time_get_6.setText(java_dare_h_6);


                    //time_7
                    double time_h_7 = Double.parseDouble(h_time_7);
                    double centi_h_7 = time_h_7;
                    centi_h_7 = Math.round(centi_h_7);
                    int  nt_h_7 = (int) centi_h_7;

                    long long_h_7 = nt_h_7;
                    Date date_h_7 = new Date(long_h_7 * 1000L);
                    SimpleDateFormat jdf_h_7 = new SimpleDateFormat("hh:mm a");
                    jdf_h_7.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_7 = jdf_h_7.format(date_h_7);
                    time_get_7.setText(java_dare_h_7);


                    //8
                    double time_h_8 = Double.parseDouble(h_time_8);
                    double centi_h_8 = time_h_8;
                    centi_h_8 = Math.round(centi_h_8);
                    int  nt_h_8 = (int) centi_h_8;

                    long long_h_8 = nt_h_8;
                    Date date_h_8 = new Date(long_h_8 * 1000L);
                    SimpleDateFormat jdf_h_8 = new SimpleDateFormat("hh:mm a");
                    jdf_h_8.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_8= jdf_h_8.format(date_h_8);
                    time_get_8.setText(java_dare_h_8);


                    //time_9
                    double time_h_9 = Double.parseDouble(h_time_9);
                    double centi_h_9 = time_h_9;
                    centi_h_9 = Math.round(centi_h_9);
                    int  nt_h_9 = (int) centi_h_9;

                    long long_h_9 = nt_h_9;
                    Date date_h_9 = new Date(long_h_9 * 1000L);
                    SimpleDateFormat jdf_h_9 = new SimpleDateFormat("hh:mm a");
                    jdf_h_9.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_9 = jdf_h_9.format(date_h_9);
                    time_get_9.setText(java_dare_h_9);


                    //time_10
                    double time_h_10 = Double.parseDouble(h_time_10);
                    double centi_h_10 = time_h_10;
                    centi_h_10 = Math.round(centi_h_10);
                    int  nt_h_10 = (int) centi_h_10;

                    long long_h_10 = nt_h_10;
                    Date date_h_10 = new Date(long_h_10 * 1000L);
                    SimpleDateFormat jdf_h_10 = new SimpleDateFormat("hh:mm a");
                    jdf_h_10.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_10 = jdf_h_10.format(date_h_10);
                    time_get_10.setText(java_dare_h_10);


                    //time_11
                    double time_h_11 = Double.parseDouble(h_time_11);
                    double centi_h_11 = time_h_11;
                    centi_h_11 = Math.round(centi_h_11);
                    int  nt_h_11 = (int) centi_h_11;

                    long long_h_11 = nt_h_11;
                    Date date_h_11 = new Date(long_h_11 * 1000L);
                    SimpleDateFormat jdf_h_11 = new SimpleDateFormat("hh:mm a");
                    jdf_h_11.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_11 = jdf_h_11.format(date_h_11);
                    time_get_11.setText(java_dare_h_11);


                    //time_12
                    double time_h_12 = Double.parseDouble(h_time_12);
                    double centi_h_12 = time_h_12;
                    centi_h_12 = Math.round(centi_h_12);
                    int  nt_h_12 = (int) centi_h_12;

                    long long_h_12 = nt_h_12;
                    Date date_h_12 = new Date(long_h_12 * 1000L);
                    SimpleDateFormat jdf_h_12 = new SimpleDateFormat("hh:mm a");
                    jdf_h_12.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_12 = jdf_h_12.format(date_h_12);
                    time_get_12.setText(java_dare_h_12);

                    //13
                    double time_h_13 = Double.parseDouble(h_time_13);
                    double centi_h_13 = time_h_13;
                    centi_h_13 = Math.round(centi_h_13);
                    int  nt_h_13 = (int) centi_h_13;

                    long long_h_13 = nt_h_13;
                    Date date_h_13 = new Date(long_h_13 * 1000L);
                    SimpleDateFormat jdf_h_13 = new SimpleDateFormat("hh:mm a");
                    jdf_h_13.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_13 = jdf_h_13.format(date_h_13);
                    time_get_13.setText(java_dare_h_13);

                    //time_14
                    double time_h_14 = Double.parseDouble(h_time_14);
                    double centi_h_14 = time_h_14;
                    centi_h_14 = Math.round(centi_h_14);
                    int  nt_h_14 = (int) centi_h_14;

                    long long_h_14 = nt_h_14;
                    Date date_h_14 = new Date(long_h_14 * 1000L);
                    SimpleDateFormat jdf_h_14 = new SimpleDateFormat("hh:mm a");
                    jdf_h_14.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_14 = jdf_h_14.format(date_h_14);
                    time_get_14.setText(java_dare_h_14);

                    //time_15
                    double time_h_15 = Double.parseDouble(h_time_15);
                    double centi_h_15 = time_h_15;
                    centi_h_15 = Math.round(centi_h_15);
                    int  nt_h_15 = (int) centi_h_15;

                    long long_h_15 = nt_h_15;
                    Date date_h_15 = new Date(long_h_15 * 1000L);
                    SimpleDateFormat jdf_h_15 = new SimpleDateFormat("hh:mm a");
                    jdf_h_15.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_15 = jdf_h_15.format(date_h_15);
                    time_get_15.setText(java_dare_h_15);

                    //16
                    double time_h_16 = Double.parseDouble(h_time_16);
                    double centi_h_16 = time_h_16;
                    centi_h_16 = Math.round(centi_h_16);
                    int  nt_h_16 = (int) centi_h_16;

                    long long_h_16 = nt_h_16;
                    Date date_h_16 = new Date(long_h_16 * 1000L);
                    SimpleDateFormat jdf_h_16 = new SimpleDateFormat("hh:mm a");
                    jdf_h_16.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_16 = jdf_h_16.format(date_h_16);
                    time_get_16.setText(java_dare_h_16);


                    //17
                    double time_h_17 = Double.parseDouble(h_time_17);
                    double centi_h_17 = time_h_17;
                    centi_h_17 = Math.round(centi_h_17);
                    int  nt_h_17 = (int) centi_h_17;

                    long long_h_17 = nt_h_17;
                    Date date_h_17 = new Date(long_h_17 * 1000L);
                    SimpleDateFormat jdf_h_17 = new SimpleDateFormat("hh:mm a");
                    jdf_h_17.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_17 = jdf_h_17.format(date_h_17);
                    time_get_17.setText(java_dare_h_17);


                    //18
                    double time_h_18 = Double.parseDouble(h_time_18);
                    double centi_h_18 = time_h_18;
                    centi_h_18 = Math.round(centi_h_18);
                    int  nt_h_18 = (int) centi_h_18;

                    long long_h_18 = nt_h_18;
                    Date date_h_18 = new Date(long_h_18 * 1000L);
                    SimpleDateFormat jdf_h_18 = new SimpleDateFormat("hh:mm a");
                    jdf_h_18.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_18 = jdf_h_18.format(date_h_18);
                    time_get_18.setText(java_dare_h_18);


                    //19
                    double time_h_19 = Double.parseDouble(h_time_19);
                    double centi_h_19 = time_h_19;
                    centi_h_19 = Math.round(centi_h_19);
                    int  nt_h_19 = (int) centi_h_19;

                    long long_h_19 = nt_h_19;
                    Date date_h_19 = new Date(long_h_19 * 1000L);
                    SimpleDateFormat jdf_h_19 = new SimpleDateFormat("hh:mm a");
                    jdf_h_19.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_19 = jdf_h_19.format(date_h_19);
                    time_get_19.setText(java_dare_h_19);


                    //20
                    double time_h_20 = Double.parseDouble(h_time_20);
                    double centi_h_20 = time_h_20;
                    centi_h_20 = Math.round(centi_h_20);
                    int  nt_h_20 = (int) centi_h_20;

                    long long_h_20 = nt_h_20;
                    Date date_h_20 = new Date(long_h_20 * 1000L);
                    SimpleDateFormat jdf_h_20 = new SimpleDateFormat("hh:mm a");
                    jdf_h_20.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_20 = jdf_h_20.format(date_h_20);
                    time_get_20.setText(java_dare_h_20);


                    //21
                    double time_h_21 = Double.parseDouble(h_time_21);
                    double centi_h_21 = time_h_21;
                    centi_h_21 = Math.round(centi_h_21);
                    int  nt_h_21 = (int) centi_h_21;

                    long long_h_21 = nt_h_21;
                    Date date_h_21 = new Date(long_h_21 * 1000L);
                    SimpleDateFormat jdf_h_21 = new SimpleDateFormat("hh:mm a");
                    jdf_h_21.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_21 = jdf_h_21.format(date_h_21);
                    time_get_21.setText(java_dare_h_21);


                    //22
                    double time_h_22 = Double.parseDouble(h_time_22);
                    double centi_h_22 = time_h_22;
                    centi_h_22 = Math.round(centi_h_22);
                    int  nt_h_22 = (int) centi_h_22;

                    long long_h_22 = nt_h_22;
                    Date date_h_22 = new Date(long_h_22 * 1000L);
                    SimpleDateFormat jdf_h_22 = new SimpleDateFormat("hh:mm a");
                    jdf_h_22.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_22 = jdf_h_2.format(date_h_22);
                    time_get_22.setText(java_dare_h_22);

                    //23
                    double time_h_23 = Double.parseDouble(h_time_23);
                    double centi_h_23 = time_h_23;
                    centi_h_23 = Math.round(centi_h_23);
                    int  nt_h_23 = (int) centi_h_23;

                    long long_h_23 = nt_h_23;
                    Date date_h_23 = new Date(long_h_23 * 1000L);
                    SimpleDateFormat jdf_h_23 = new SimpleDateFormat("hh:mm a");
                    jdf_h_23.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_23 = jdf_h_23.format(date_h_23);
                    time_get_23.setText(java_dare_h_23);


                    //24
                    double time_h_24 = Double.parseDouble(h_time_24);
                    double centi_h_24 = time_h_24;
                    centi_h_24 = Math.round(centi_h_24);
                    int  nt_h_24 = (int) centi_h_24;

                    long long_h_24 = nt_h_24;
                    Date date_h_24 = new Date(long_h_24 * 1000L);
                    SimpleDateFormat jdf_h_24 = new SimpleDateFormat("hh:mm a");
                    jdf_h_24.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_h_24 = jdf_h_24.format(date_h_24);
                    time_get_24.setText(java_dare_h_24);
                    //hourly_forecast_END

                    //Dailly_forecast_Start
                    JSONObject daily_main = response.getJSONObject("daily");

                    JSONArray array = daily_main.getJSONArray("data");
                    JSONObject dailly_main_0 = array.getJSONObject(0);
                    JSONObject dailly_main_1 = array.getJSONObject(1);
                    JSONObject dailly_main_2 = array.getJSONObject(2);
                    JSONObject dailly_main_3 = array.getJSONObject(3);
                    JSONObject dailly_main_4 = array.getJSONObject(4);
                    JSONObject dailly_main_5 = array.getJSONObject(5);
                    JSONObject dailly_main_6 = array.getJSONObject(6);
                    JSONObject dailly_main_7 = array.getJSONObject(7);

                    //0
                    String dailly_0_sunrise = String.valueOf(dailly_main_0.getInt("sunriseTime"));
                    String dailly_0_sunset = String.valueOf(dailly_main_0.getInt("sunsetTime"));
                    String dailly_0_tempHigh = String.valueOf(dailly_main_0.getDouble("temperatureHigh"));
                    String dailly_0_tempLow = String.valueOf(dailly_main_0.getDouble("temperatureLow"));
                    String dailly_0_windDeg = String.valueOf(dailly_main_0.getDouble("windBearing"));

                    //today_sunrise
                    double bar = Double.parseDouble(dailly_0_sunrise);
                    double centi_today_bar = bar;
                    centi_today_bar = Math.round(centi_today_bar);
                    int  i_today_bar = (int) centi_today_bar;

                    long t_today_bar = i_today_bar;
                    Date date = new Date(t_today_bar * 1000L);
                    SimpleDateFormat jdf_today_bar = new SimpleDateFormat("hh:mm a");
                    jdf_today_bar.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_today_bar = jdf_today_bar.format(date);
                    t_sunrise.setText(java_dare_today_bar);
                   //today_sunset
                    double today_unix_scond = Double.parseDouble(dailly_0_sunset);
                    double centi_today_unix_scond = today_unix_scond;
                    centi_today_unix_scond = Math.round(centi_today_unix_scond);
                    int  i_today_unix_scond = (int)centi_today_unix_scond;

                    long unix_scond = i_today_unix_scond;
                    Date date_ = new Date(unix_scond * 1000L);
                    SimpleDateFormat jdf = new SimpleDateFormat("hh:mm a");
                    jdf.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare = jdf.format(date_);
                    t_sunset.setText(java_dare);

                    double temp_int_t_min = Double.parseDouble(dailly_0_tempLow);
                    double centi_t_min = temp_int_t_min;
                    centi_t_min = Math.round(centi_t_min);
                    int i_t_min = (int)centi_t_min;
                    day_today_min.setText(String.valueOf(i_t_min));

                    double temp_int_t_max = Double.parseDouble(dailly_0_tempHigh);
                    double centi_t_max = temp_int_t_max;
                    centi_t_max = Math.round(centi_t_max);
                    int i_t_max = (int)centi_t_max;
                    day_today_max.setText(String.valueOf(i_t_max));

                    //wind_deg
                    double wind_deg = Double.parseDouble(dailly_0_windDeg);
                    double centi_t_wind_deg = wind_deg;
                    centi_t_max = Math.round(centi_t_wind_deg);
                    int i_t_wind_deg = (int)centi_t_wind_deg;
                    t_wind_deg.setText(String.valueOf(i_t_wind_deg));


                    //today_bar
                    double today_unix_scond_ = Double.parseDouble(dailly_0_sunrise);
                    double centi_today_unix_scond_ = today_unix_scond_;
                    centi_today_unix_scond_= Math.round(centi_today_unix_scond_);
                    int  i_today_unix_scond_ = (int)centi_today_unix_scond_;

                    long unix_scond2 = i_today_unix_scond_;
                    Date date2 = new Date(unix_scond2 * 1000L);
                    SimpleDateFormat jdf2 = new SimpleDateFormat("EEEE");
                    jdf2.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare2 = jdf2.format(date2);
                    day_today.setText(java_dare2);

                    //1
                    String dailly_1_tempHigh = String.valueOf(dailly_main_1.getDouble("temperatureHigh"));
                    String dailly_1_tempLow = String.valueOf(dailly_main_1.getDouble("temperatureLow"));
                    String dailly_1_bar = String.valueOf(dailly_main_1.getDouble("time"));

                    //tempLow
                    double temp_int_t_min1 = Double.parseDouble(dailly_1_tempLow);
                    double centi_t_min1 = temp_int_t_min1;
                    centi_t_min = Math.round(centi_t_min1);
                    int i_t_min1 = (int)centi_t_min;
                    day_next1_min.setText(String.valueOf(i_t_min1));

                    //tempHigh
                    double temp_int_t_max1 = Double.parseDouble(dailly_1_tempHigh);
                    double centi_t_max1 = temp_int_t_max1;
                    centi_t_max1 = Math.round(centi_t_max1);
                    int i_t_max1 = (int)centi_t_max1;
                    day_next1_max.setText(String.valueOf(i_t_max1));

                    //bar_next1
                    double next1_unix_scond_ = Double.parseDouble(dailly_1_bar);
                    double centi_next1_unix_scond_ = next1_unix_scond_;
                    centi_next1_unix_scond_= Math.round(centi_next1_unix_scond_);
                    int  i_next1_unix_scond_= (int)centi_next1_unix_scond_;

                    long unix_scond_next1 = i_next1_unix_scond_;
                    Date date_next1 = new Date(unix_scond_next1 * 1000L);
                    SimpleDateFormat jdf_next1 = new SimpleDateFormat("EEEE");
                    jdf_next1.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_next1 = jdf_next1.format(date_next1);
                    t_day_next1.setText(java_dare_next1);

                    //2
                    String dailly_2_tempHigh = String.valueOf(dailly_main_2.getDouble("temperatureHigh"));
                    String dailly_2_tempLow = String.valueOf(dailly_main_2.getDouble("temperatureLow"));
                    String dailly_2_bar = String.valueOf(dailly_main_2.getDouble("time"));
                    double temp_int_t_min2 = Double.parseDouble(dailly_2_tempLow);
                    double centi_t_min2 = temp_int_t_min2;
                    centi_t_min2 = Math.round(centi_t_min2);
                    int i_t_min2 = (int)centi_t_min2;
                    day_next2_min.setText(String.valueOf(i_t_min2));

                    double temp_int_t_max2 = Double.parseDouble(dailly_2_tempHigh);
                    double centi_t_max2 = temp_int_t_max2;
                    centi_t_max2 = Math.round(centi_t_max2);
                    int i_t_max2 = (int)centi_t_max2;
                    day_next2_max.setText(String.valueOf(i_t_max2));

                    //bar_next1
                    double next2_unix_scond_ = Double.parseDouble(dailly_2_bar);
                    double centi_next2_unix_scond_ = next2_unix_scond_;
                    centi_next2_unix_scond_= Math.round(centi_next2_unix_scond_);
                    int  i_next2_unix_scond_= (int)centi_next2_unix_scond_;

                    long unix_scond_next2 = i_next2_unix_scond_;
                    Date date_next2 = new Date(unix_scond_next2 * 1000L);
                    SimpleDateFormat jdf_next2 = new SimpleDateFormat("EEEE");
                    jdf_next2.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_next2 = jdf_next2.format(date_next2);
                    t_day_next2.setText(java_dare_next2);


                    //3
                    String dailly_3_tempHigh = String.valueOf(dailly_main_3.getDouble("temperatureHigh"));
                    String dailly_3_tempLow = String.valueOf(dailly_main_3.getDouble("temperatureLow"));
                    String dailly_3_bar = String.valueOf(dailly_main_3.getDouble("time"));

                    double temp_int_t_min3 = Double.parseDouble(dailly_3_tempLow);
                    double centi_t_min3 = temp_int_t_min3;
                    centi_t_min3 = Math.round(centi_t_min3);
                    int i_t_min3 = (int)centi_t_min3;
                    day_next3_min.setText(String.valueOf(i_t_min3));

                    double temp_int_t_max3 = Double.parseDouble(dailly_3_tempHigh);
                    double centi_t_max3 = temp_int_t_max3;
                    centi_t_max3 = Math.round(centi_t_max3);
                    int i_t_max3 = (int)centi_t_max3;
                    day_next3_max.setText(String.valueOf(i_t_max3));

                    //bar_next1
                    double next3_unix_scond_ = Double.parseDouble(dailly_3_bar);
                    double centi_next3_unix_scond_ = next3_unix_scond_;
                    centi_next3_unix_scond_= Math.round(centi_next3_unix_scond_);
                    int  i_next3_unix_scond_= (int)centi_next3_unix_scond_;

                    long unix_scond_next3 = i_next3_unix_scond_;
                    Date date_next3 = new Date(unix_scond_next3 * 1000L);
                    SimpleDateFormat jdf_next3 = new SimpleDateFormat("EEEE");
                    jdf_next3.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_next3 = jdf_next3.format(date_next3);
                    t_day_next3.setText(java_dare_next3);


                    //4
                    String dailly_4_tempHigh = String.valueOf(dailly_main_4.getDouble("temperatureHigh"));
                    String dailly_4_tempLow = String.valueOf(dailly_main_4.getDouble("temperatureLow"));
                    String dailly_4_bar = String.valueOf(dailly_main_4.getDouble("time"));

                    double temp_int_t_min4 = Double.parseDouble(dailly_4_tempLow);
                    double centi_t_min4 = temp_int_t_min4;
                    centi_t_min4 = Math.round(centi_t_min4);
                    int i_t_min4 = (int)centi_t_min4;
                    day_next4_min.setText(String.valueOf(i_t_min4));

                    double temp_int_t_max4 = Double.parseDouble(dailly_4_tempHigh);
                    double centi_t_max4 = temp_int_t_max4;
                    centi_t_max4 = Math.round(centi_t_max4);
                    int i_t_max4 = (int)centi_t_max4;
                    day_next4_max.setText(String.valueOf(i_t_max4));

                    //bar_next1
                    double next4_unix_scond_ = Double.parseDouble(dailly_4_bar);
                    double centi_next4_unix_scond_ = next4_unix_scond_;
                    centi_next4_unix_scond_= Math.round(centi_next4_unix_scond_);
                    int  i_next4_unix_scond_= (int)centi_next4_unix_scond_;

                    long unix_scond_next4 = i_next4_unix_scond_;
                    Date date_next4 = new Date(unix_scond_next4 * 1000L);
                    SimpleDateFormat jdf_next4 = new SimpleDateFormat("EEEE");
                    jdf_next4.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_next4 = jdf_next4.format(date_next4);
                    t_day_next4.setText(java_dare_next4);

                    //5
                    String dailly_5_tempHigh = String.valueOf(dailly_main_5.getDouble("temperatureHigh"));
                    String dailly_5_tempLow = String.valueOf(dailly_main_5.getDouble("temperatureLow"));
                    String dailly_5_bar = String.valueOf(dailly_main_5.getDouble("time"));

                    double temp_int_t_min5 = Double.parseDouble(dailly_5_tempLow);
                    double centi_t_min5 = temp_int_t_min5;
                    centi_t_min5 = Math.round(centi_t_min5);
                    int i_t_min5 = (int)centi_t_min5;
                    day_next5_min.setText(String.valueOf(i_t_min5));

                    double temp_int_t_max5 = Double.parseDouble(dailly_5_tempHigh);
                    double centi_t_max5 = temp_int_t_max5;
                    centi_t_max5 = Math.round(centi_t_max5);
                    int i_t_max5 = (int)centi_t_max5;
                    day_next5_max.setText(String.valueOf(i_t_max5));

                    //bar_next1
                    double next5_unix_scond_ = Double.parseDouble(dailly_5_bar);
                    double centi_next5_unix_scond_ = next5_unix_scond_;
                    centi_next5_unix_scond_= Math.round(centi_next5_unix_scond_);
                    int  i_next5_unix_scond_= (int)centi_next5_unix_scond_;

                    long unix_scond_next5 = i_next5_unix_scond_;
                    Date date_next5 = new Date(unix_scond_next5 * 1000L);
                    SimpleDateFormat jdf_next5 = new SimpleDateFormat("EEEE");
                    jdf_next5.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_next5 = jdf_next5.format(date_next5);
                    t_day_next5.setText(java_dare_next5);


                    //6
                    String dailly_6_tempHigh = String.valueOf(dailly_main_6.getDouble("temperatureHigh"));
                    String dailly_6_tempLow = String.valueOf(dailly_main_6.getDouble("temperatureLow"));
                    String dailly_6_bar = String.valueOf(dailly_main_6.getDouble("time"));

                    double temp_int_t_min6 = Double.parseDouble(dailly_6_tempLow);
                    double centi_t_min6 = temp_int_t_min6;
                    centi_t_min6 = Math.round(centi_t_min6);
                    int i_t_min6 = (int)centi_t_min6;
                    day_next6_min.setText(String.valueOf(i_t_min6));

                    double temp_int_t_max6 = Double.parseDouble(dailly_6_tempHigh);
                    double centi_t_max6 = temp_int_t_max6;
                    centi_t_max6 = Math.round(centi_t_max6);
                    int i_t_max6 = (int)centi_t_max6;
                    day_next6_max.setText(String.valueOf(i_t_max6));

                    //bar_next1
                    double next6_unix_scond_ = Double.parseDouble(dailly_6_bar);
                    double centi_next6_unix_scond_ = next6_unix_scond_;
                    centi_next6_unix_scond_= Math.round(centi_next6_unix_scond_);
                    int  i_next6_unix_scond_= (int)centi_next6_unix_scond_;

                    long unix_scond_next6 = i_next6_unix_scond_;
                    Date date_next6 = new Date(unix_scond_next6 * 1000L);
                    SimpleDateFormat jdf_next6 = new SimpleDateFormat("EEEE");
                    jdf_next6.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_next6 = jdf_next6.format(date_next6);
                    t_day_next6.setText(java_dare_next6);


                    //7
                    String dailly_7_tempHigh = String.valueOf(dailly_main_7.getDouble("temperatureHigh"));
                    String dailly_7_tempLow = String.valueOf(dailly_main_7.getDouble("temperatureLow"));
                    String dailly_7_bar = String.valueOf(dailly_main_7.getDouble("time"));

                    double temp_int_t_min7 = Double.parseDouble(dailly_7_tempLow);
                    double centi_t_min7 = temp_int_t_min7;
                    centi_t_min7 = Math.round(centi_t_min7);
                    int i_t_min7 = (int)centi_t_min7;
                    day_next7_min.setText(String.valueOf(i_t_min7));

                    double temp_int_t_max7 = Double.parseDouble(dailly_7_tempHigh);
                    double centi_t_max7 = temp_int_t_max7;
                    centi_t_max7 = Math.round(centi_t_max7);
                    int i_t_max7 = (int)centi_t_max7;
                    day_next7_max.setText(String.valueOf(i_t_max7));

                    //bar_next1
                    double next7_unix_scond_ = Double.parseDouble(dailly_7_bar);
                    double centi_next7_unix_scond_ = next7_unix_scond_;
                    centi_next7_unix_scond_= Math.round(centi_next7_unix_scond_);
                    int  i_next7_unix_scond_= (int)centi_next7_unix_scond_;

                    long unix_scond_next7 = i_next7_unix_scond_;
                    Date date_next7 = new Date(unix_scond_next7 * 1000L);
                    SimpleDateFormat jdf_next7 = new SimpleDateFormat("EEEE");
                    jdf_next7.setTimeZone(TimeZone.getTimeZone("GMT+6"));
                    String java_dare_next7 = jdf_next7.format(date_next7);
                    t_day_next7.setText(java_dare_next7);
                    //Dailly_forecast

                    //top_temp
                    JSONObject main_object = response.getJSONObject("currently");

                    String temp = String.valueOf(main_object.getDouble("temperature"));
                    String t_air_humidity = String.valueOf(main_object.getDouble("humidity"));
                    String t_pressure = String.valueOf(main_object.getInt("pressure"));
                    String t_windSpeed = String.valueOf(main_object.getDouble("windSpeed"));
                    String description = String.valueOf(main_object.getString("icon"));
                    String today_rain_probability = String.valueOf(main_object.getString("precipProbability"));

                    double t_rain_probability = Double.parseDouble(today_rain_probability);
                    double centi_rain_probabity = t_rain_probability * 100;
                    centi_rain_probabity = Math.round(centi_rain_probabity);
                    int i_rain_probability = (int)centi_rain_probabity;
                    rain_probability.setText(String.valueOf(i_rain_probability));

                    t3_description.setText(description);


                    double temp_ = Double.parseDouble(temp);
                    double centi_temp_ = temp_;
                    centi_temp_ = Math.round(centi_temp_);
                    int i_temp_ = (int)centi_temp_;
                    t1_temp.setText(String.valueOf(i_temp_));


                    double temp_int = Double.parseDouble(temp);
                    double centi = temp_int;
                    centi = Math.round(centi);
                    int i = (int)centi;
                    t1_temp.setText(String.valueOf(i));

                    //today
                    double tt_air_humidity = Double.parseDouble(t_air_humidity);
                    double centi_humidity = tt_air_humidity * 100;
                    centi_humidity = Math.round(centi_humidity);
                    int i_humidity = (int)centi_humidity;
                    today_air_humidity.setText(String.valueOf(i_humidity));

                    today_wind_speed.setText(t_windSpeed);
                    today_pressure.setText(t_pressure);

                    //top_bar
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM dd ");
                    String formatted_data = sdf.format(calendar.getTime());
                    t4_date.setText(formatted_data);

                    //top_time
                    Date currentTime = Calendar.getInstance().getTime();
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm a");
                    String currentDateandTime = sdf2.format(currentTime.getTime());
                    t5_time.setText(currentDateandTime);

                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);

    }

}
