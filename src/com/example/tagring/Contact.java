package com.example.tagring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.TableLayout.LayoutParams;

public class Contact extends ListActivity {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		
		ArrayList<String> listItems=new ArrayList<String>();
	    ArrayAdapter<String> adapter;
	    adapter=new ArrayAdapter<String>(this,
	            android.R.layout.simple_list_item_1,
	            listItems);
	    setListAdapter(adapter);

        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (cur.getCount() > 0) {
        	while (cur.moveToNext()) {
        		String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    System.out.println("name : " + name + ", ID : " + id);
                    
                    listItems.add(name);
        	        adapter.notifyDataSetChanged();
        	        
                    // get the phone number
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                                           ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
                                           new String[]{id}, null);
                    while (pCur.moveToNext()) {
                          String phone = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                          System.out.println("phone" + phone);
                    }
                    pCur.close();
                }
            }
        	
        }
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener(){
			public void onClick(View V){
				startActivity(new Intent(Contact.this, Set.class));
			}
		});
	}
}
