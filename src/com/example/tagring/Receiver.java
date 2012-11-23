package com.example.tagring;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		try {
			Bundle bundle = intent.getExtras();
			String message = bundle.getString("alarm_message");
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			AudioManager audio = (AudioManager) context
					.getSystemService(Context.AUDIO_SERVICE);
			if (message.equals("set")) {

				audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			} else {

				audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			}

		} catch (Exception e) {

		}

	}

}
