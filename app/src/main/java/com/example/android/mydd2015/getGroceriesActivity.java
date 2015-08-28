package com.example.android.mydd2015;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class getGroceriesActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_groceries);
        M2XURLClassGroceries m2XURLClass2 = new M2XURLClassGroceries();
        m2XURLClass2.execute();
        M2XURLClassDaysToExpiry m2XURLClass3 = new M2XURLClassDaysToExpiry();
        m2XURLClass3.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_groceries, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

        public class M2XURLClassGroceries extends AsyncTask<Void, Void, String> {

            public final String LOG_TAG = M2XURLClassGroceries.class.getSimpleName();
            String deviceID = "6bec26ba156fd09ae9b376a78896938f";
            String APIKey = "00d2226f3f7c30a7caeaa0fe4e59965e";
            String baseURL = "https://api-m2x.att.com/v2/devices/6bec26ba156fd09ae9b376a78896938f/streams/groceries2/values";  //or values?
            String sb2;

            @Override
            protected String doInBackground(Void... params) {

                // If there's no zip code, there's nothing to look up.  Verify size of params.
                //  if (params.length == 0) {
                //     return null;
                // }

                HttpClient httpclient = new DefaultHttpClient();


                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                //String sb="";

                String forecastJsonStr = null;
                String line2= null;

                try {

                    //new one
                    URL url2 = new URL(baseURL);
                    HttpURLConnection urlConnection2 = (HttpURLConnection) url2.openConnection();
                    urlConnection2.setRequestProperty("Content-Type", "application/json");
                    urlConnection2.setRequestProperty("X-M2X-KEY", "00d2226f3f7c30a7caeaa0fe4e59965e");
                    urlConnection2.setRequestMethod("GET");
                    urlConnection2.connect();
                    int status = urlConnection2.getResponseCode();
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection2.getInputStream()));
                    //end of new one
                    StringBuilder sb = new StringBuilder();
                    StringBuffer buffer = new StringBuffer();
                    while ((line2 = br.readLine()) != null) {
                        sb=sb.append(line2);// + "\n");
                        buffer.append(line2 + "\n");
                    }
                    if (buffer.length() == 0) {
                        // Stream was empty.  No point in parsing.
                        return null;
                    }
                    line2 = buffer.toString();


                    // sb2=sb.toString();
                    br.close();
                } catch (IOException e) {
                    Log.e(LOG_TAG, "Error ", e);
                    return null;
                } finally {
                    try {
                        final String VALUE_STRING = "values";
                        JSONObject jsonObject1 = new JSONObject(line2);
                        Log.v("blah",jsonObject1.toString());
                        JSONArray jsonArray1 = jsonObject1.getJSONArray(VALUE_STRING);
                        JSONObject jsonObject2 = jsonArray1.getJSONObject(0);
                        line2=jsonObject2.toString();
                        Log.v("blah",jsonArray1.toString());
                        int gTest;
                        gTest=1;
                    }catch (JSONException eJSONcatcher) {
                        int dTest;
                        dTest=1;
                    }
                }
                return line2;

            }

            @Override
            protected void onPostExecute(String result){
                TextView textview = (TextView) findViewById(R.id.m2xUrlTextViewGroceries);
                textview.setText(result);
            }

        }
    public class M2XURLClassDaysToExpiry extends AsyncTask<Void, Void, String> {

        public final String LOG_TAG = M2XURLClassGroceries.class.getSimpleName();
        String deviceID = "6bec26ba156fd09ae9b376a78896938f";
        String APIKey = "00d2226f3f7c30a7caeaa0fe4e59965e";
        String baseURL = "https://api-m2x.att.com/v2/devices/6bec26ba156fd09ae9b376a78896938f/streams/groceries4/values";  //or values?
        String sb2;

        @Override
        protected String doInBackground(Void... params) {



            HttpClient httpclient = new DefaultHttpClient();


            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            //String sb="";

            String forecastJsonStr = null;
            String line2= null;

            try {

                //new one
                URL url2 = new URL(baseURL);
                HttpURLConnection urlConnection2 = (HttpURLConnection) url2.openConnection();
                urlConnection2.setRequestProperty("Content-Type", "application/json");
                urlConnection2.setRequestProperty("X-M2X-KEY", "00d2226f3f7c30a7caeaa0fe4e59965e");
                urlConnection2.setRequestMethod("GET");
                urlConnection2.connect();
                int status = urlConnection2.getResponseCode();
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection2.getInputStream()));
                //end of new one
                StringBuilder sb = new StringBuilder();
                StringBuffer buffer = new StringBuffer();
                while ((line2 = br.readLine()) != null) {
                    sb=sb.append(line2);// + "\n");
                    buffer.append(line2 + "\n");
                }
                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                line2 = buffer.toString();


                // sb2=sb.toString();
                br.close();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error ", e);
                return null;
            } finally {
                try {
                    final String VALUE_STRING = "values";
                    JSONObject jsonObject1 = new JSONObject(line2);
                    Log.v("blah",jsonObject1.toString());
                    JSONArray jsonArray1 = jsonObject1.getJSONArray(VALUE_STRING);
                    JSONObject jsonObject2 = jsonArray1.getJSONObject(0);
                    line2=jsonObject2.toString();
                    Log.v("blah",jsonArray1.toString());
                    int gTest;
                    gTest=1;
                }catch (JSONException eJSONcatcher2) {
                    int dTest;
                    dTest=1;
                }
            }
            return line2;

        }

        @Override
        protected void onPostExecute(String result){
            TextView textview = (TextView) findViewById(R.id.m2xUrlTextViewDaysToExpiry);
            textview.setText(result);
        }

    }
}
