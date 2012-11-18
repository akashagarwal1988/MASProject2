package com.example.tagring;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.util.ServiceException;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;



public class Event extends ListActivity {
	@SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");
        String password = extras.getString("password");
        CalendarService myService = new CalendarService("exampleCo-exampleApp-1.0");
        try {
			myService.setUserCredentials(username, password);
		} catch (com.google.gdata.util.AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        URL feedUrl;
		try {
			feedUrl = new URL("http://www.google.com/calendar/feeds/default/allcalendars/full");
		
        CalendarFeed resultFeed;
		
			resultFeed = myService.getFeed(feedUrl, CalendarFeed.class);
		

        System.out.println("Your calendars:");
        System.out.println();
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 ,new ArrayList<String>()));
        for (int i = 0; i < resultFeed.getEntries().size(); i++) {
          CalendarEntry entry = resultFeed.getEntries().get(i);
          String newItem =  entry.getTitle().getPlainText();
          ((ArrayAdapter<String>)getListAdapter()).add(newItem);
          
        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Button b = (Button) findViewById(R.id.button1);
         b.setOnClickListener(new OnClickListener(){
        	public void onClick(View V){
            	startActivity(new Intent(Event.this, Contact.class));
        	}
        });
	}
}
