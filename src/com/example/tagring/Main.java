package com.example.tagring;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final String username = "Test.AppSolute1";
        final String password = "testappsolute";
        ConnectivityManager conman = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
       final NetworkInfo netInfo = conman.getActiveNetworkInfo();
        final TextView tv = (TextView) findViewById(R.id.textView1);
        final EditText et1 = (EditText) findViewById(R.id.editText1);
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener(){
        	public void onClick(View V){
        		Log.d("Akash","before if");
        		if(netInfo != null && netInfo.isConnectedOrConnecting()){
        			Log.d("Akash","in internet if");
                	tv.setText("");
                	Intent intent = new Intent(Main.this,Event.class);
            		intent.putExtra("username",username);
            		Log.d("Akash","put1");
            		intent.putExtra("password",password);
            		Log.d("Akash","put2");
					startActivity(intent);
				}
        		else{
        			Toast.makeText(Main.this, "Internet Service Required", Toast.LENGTH_LONG).show();
        		}
        	}
        	
        	});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}
