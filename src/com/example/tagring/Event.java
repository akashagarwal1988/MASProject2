package com.example.tagring;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.calendar.CalendarEventFeed;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.util.ServiceException;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Event extends ListActivity {
	@SuppressWarnings("unchecked")
	
	
	ArrayList<String> events;
	@SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event);
		Bundle extras = getIntent().getExtras();
		String username = extras.getString("username");
		String password = extras.getString("password");
		ListView lv = (ListView) findViewById(android.R.id.list);
		CalendarService myService = new CalendarService(
				"exampleCo-exampleApp-1.0");
		try {
			myService.setUserCredentials(username, password);
		} catch (com.google.gdata.util.AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URL feedUrl;
		try {
			feedUrl = new URL(
					"http://www.google.com/calendar/feeds/test.appsolute1@gmail.com/private/full");

			CalendarEventFeed myFeed = myService.getFeed(feedUrl,
					CalendarEventFeed.class);

			System.out.println("Your calendars:");
			System.out.println();
			
			events = new ArrayList<String>();
			
			setListAdapter(new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1,
					events));
			for (int i = 0; i < myFeed.getEntries().size(); i++) {
				CalendarEventEntry calendarEvent = myFeed.getEntries().get(i);
				String newItem = calendarEvent.getTitle().getPlainText();
				((ArrayAdapter<String>) getListAdapter()).add(newItem);
			}
			lv.setAdapter(getListAdapter());
			lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				public void onItemClick(AdapterView lv, View view, int pos,
						long id) {
					Intent intent = new Intent(Event.this, Set.class);
					intent.putExtra("itemTitle", events.get(pos));
					startActivity(intent);

				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View V) {
				startActivity(new Intent(Event.this, Contact.class));
			}
		});
	}
	
	
}
