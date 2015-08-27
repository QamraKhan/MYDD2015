package com.example.android.mydd2015;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
//BEEP BEEP
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void login(View view){
        EditText username = (EditText)findViewById(R.id.loginUsername);
        EditText password = (EditText)findViewById(R.id.loginPassword);
        String usernameString=username.getText().toString();
        String userPasswordString= password .getText().toString();

        if(usernameString.equalsIgnoreCase("admin") && userPasswordString.equalsIgnoreCase("admin")){
//go to another page
            //correcct password
            Intent launchDetailActivity=new Intent(this, foodTableActivity.class);///Intent(getActivity(), HomePageActivity.class);//.putExtra(Intent.EXTRA_TEXT,forecast);
            startActivity(launchDetailActivity);

        }else{
            //wrong password--toast
            Context context = getApplicationContext();
            CharSequence text = "Wrong password, try again DICKHEAD!!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void testM2x(View view){

//go to another page
            //correcct password
            Intent launchDetailActivity=new Intent(this, HomePageActivity.class);///Intent(getActivity(), HomePageActivity.class);//.putExtra(Intent.EXTRA_TEXT,forecast);
            startActivity(launchDetailActivity);


    }
}
