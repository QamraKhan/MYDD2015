package com.example.android.mydd2015;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HomePageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        // updateM2XURL();
        M2XURLClass m2XURLClass = new M2XURLClass();

        m2XURLClass.execute();
       // TextView textviewUrlPathTemp = (TextView) findViewById(R.id.m2xUrlPathTextView);
       // String urlPathTemp = "https://api-m2x.att.com/v2/devices/02h280h4j05536hh19k5il21i085997i/streams/temperature/values?start=2014-10-01T12:00:00Z&end=2014-10-03T12:00:00Z&limit=3&pretty%22%20-H%20%22X-M2X-KEY:%207611hg8391k834829gkff640j8j990i2%22";
        //textviewUrlPathTemp.setText(urlPathTemp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
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

    public void updateM2XURL() {
        //M2XURLClass m2XURLClass=new M2XURLClass(this,"123");
        //String test="beep beep";


    }


    public class M2XURLClass extends AsyncTask<Void, Void, String> {

        public final String LOG_TAG = M2XURLClass.class.getSimpleName();
        String deviceID = "6bec26ba156fd09ae9b376a78896938f";
        String APIKey = "00d2226f3f7c30a7caeaa0fe4e59965e";
        String baseURL = "https://api-m2x.att.com/v2/devices/6bec26ba156fd09ae9b376a78896938f/streams/speed/values";  //or values?
        String sb2;

        @Override
        protected String doInBackground(Void... params) {

            // If there's no zip code, there's nothing to look up.  Verify size of params.
            //  if (params.length == 0) {
            //     return null;
            // }

            HttpClient httpclient = new DefaultHttpClient();

            //httpclient = new DefaultHttpClient();
            // HttpGet get = new HttpGet(baseURL);
            //get.setHeader("Content-Type", "application/json");
            // get.setHeader("X-M2X-KEY", "00d2226f3f7c30a7caeaa0fe4e59965e");


            // These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            //String sb="";

            // Will contain the raw JSON response as a string.
            String forecastJsonStr = null;
            String line2= null;

            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast

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
                // return line2;


/*
                final String FORECAST_BASE_URL = "https://api-m2x.att.com/v2/devices/02h280h4j05536hh19k5il21i085997i/streams/temperature/values?start=2014-10-01T12:00:00Z&end=2014-10-03T12:00:00Z&limit=3&pretty%22%20-H%20%22X-M2X-KEY:%207611hg8391k834829gkff640j8j990i2%22";
                // "http://api.openweathermap.org/data/2.5/forecast/daily?";
                // final String QUERY_PARAM = "q";
                // final String FORMAT_PARAM = "mode";
                // final String UNITS_PARAM = "units";
                // final String DAYS_PARAM = "cnt";

                Uri builtUri = Uri.parse(FORECAST_BASE_URL);//.build(); //Uri.parse(FORECAST_BASE_URL).buildUpon()
                // .appendQueryParameter(QUERY_PARAM, params[0])
                //.appendQueryParameter(FORMAT_PARAM, format)
                // .appendQueryParameter(UNITS_PARAM, units)
                // .appendQueryParameter(DAYS_PARAM, Integer.toString(numDays))
                //.build();

                URL url = new URL(builtUri.toString());

                Log.v(LOG_TAG, "Built URI " + builtUri.toString());

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                forecastJsonStr = buffer.toString();

                Log.v(LOG_TAG, "Forecast string: " + forecastJsonStr);
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }
            }


            return forecastJsonStr;


        }*/

               @Override
                protected void onPostExecute(String result){
                    TextView textview = (TextView) findViewById(R.id.m2xUrlTextView);
                    textview.setText(result);
                }

            }

        }
