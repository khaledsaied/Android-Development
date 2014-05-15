package itsmap.khaledsaied.handin2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver{

	private final static String TAG = "AlarmReceiver";
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onReceive");
		Intent i = new Intent();
		i.setClassName("itsmap.khaledsaied.handin2", "itsmap.khaledsaied.handin2.Activity_B");
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		arg0.startActivity(i);
	}

	
}
