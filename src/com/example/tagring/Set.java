package com.example.tagring;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Set extends Activity{
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);
        Bundle extras = getIntent().getExtras();
        String item = extras.getString("itemTitle");
        
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(item);
        
        Calendar cal = Calendar.getInstance();
        // add 5 minutes to the calendar object
        cal.add(Calendar.SECOND, 5);
        Intent intentSet = new Intent(this, Receiver.class);
        intentSet.putExtra("alarm_message", "set");
        // In reality, you would want to have a static variable for the request code instead of 192837
        PendingIntent sender1 = PendingIntent.getBroadcast(this, 192837, intentSet, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender1);
        
        
        cal.add(Calendar.SECOND, 10);

        Intent intentRemove = new Intent(this, Receiver.class);
        intentRemove.putExtra("alarm_message", "remove");
        // In reality, you would want to have a static variable for the request code instead of 192837
        PendingIntent sender2 = PendingIntent.getBroadcast(this, 192838, intentRemove, PendingIntent.FLAG_UPDATE_CURRENT);

        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender2);
        
        
        Toast.makeText(this, "Alarm in 1 minute", Toast.LENGTH_SHORT).show();
       
        /*final AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        Button normal = (Button) findViewById(R.id.button1);
        normal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			}
        });
        Button vibrate = (Button) findViewById(R.id.button2);
        vibrate.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				audio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
			}
        });
        Button silent = (Button) findViewById(R.id.button3);
        silent.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			}
        });*/
    }
}
