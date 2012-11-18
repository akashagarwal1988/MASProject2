package com.example.tagring;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Set extends Activity{
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);
        int taskleft = 4;
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(taskleft+"Event Left");
        
        
       
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
