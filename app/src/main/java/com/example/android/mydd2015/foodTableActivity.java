package com.example.android.mydd2015;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class foodTableActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_table);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food_table, menu);
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

    public void getExpiringFoodActivity(View view){



        Context context=getApplicationContext();
        LayoutInflater inflater=getLayoutInflater();

        View customToastroot =inflater.inflate(R.layout.pushnotification, null);

        Toast customtoast=new Toast(context);

        customtoast.setView(customToastroot);
        customtoast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,0, 0);
        customtoast.setDuration(Toast.LENGTH_SHORT);
        customtoast.show();


        Intent launchDetailActivity=new Intent(this, expiringFoodActivity.class);///Intent(getActivity(), HomePageActivity.class);//.putExtra(Intent.EXTRA_TEXT,forecast);
        startActivity(launchDetailActivity);
    }

    public void getBananaDetailActivity(View view){
        Intent launchDetailActivity=new Intent(this, bananaDetailActivity.class);///Intent(getActivity(), HomePageActivity.class);//.putExtra(Intent.EXTRA_TEXT,forecast);
        startActivity(launchDetailActivity);
    }
    public void getOrderSummary(View view){
        Intent launchDetailActivity=new Intent(this, orderSummaryActivity.class);///Intent(getActivity(), HomePageActivity.class);//.putExtra(Intent.EXTRA_TEXT,forecast);
        startActivity(launchDetailActivity);
    }
}
