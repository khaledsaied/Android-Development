package itsmap.khaledsaied.handin2;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import android.widget.EditText;

public class AlarmService extends Service {
	public static final String COUNTDOWN_BR = "itsmap.khaledsaied.handin2.countdown_br";
	private final static String TAG = "AlarmService";

	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG,"OnBind");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onRebind(Intent intent) {
		Log.d(TAG,"OnRebind");
		// TODO Auto-generated method stub
		super.onRebind(intent);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d(TAG,"OnUnbind");
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		Log.d(TAG,"OnCreate");
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Log.d(TAG,"OnDestroy");
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand");
		// TODO Auto-generated method stub
				
		startAlarm(intent);
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	Intent bi = new Intent(COUNTDOWN_BR);
	/* SETUP ALARM */
	public void startAlarm(Intent mintent) {
		int time = mintent.getIntExtra("the_time", 0);
		
		Intent intent = new Intent(this, AlarmReceiver.class);
		PendingIntent pintent = PendingIntent.getBroadcast(this, 0, intent, 0);
		AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, time);
		
		alarm.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pintent);
		
		new CountDownTimer(time*1000,1000) {

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTick(long arg0) {
				
				// TODO Auto-generated method stub
				long timeLeft = arg0/1000;
				
				bi.putExtra("countdown",timeLeft);
				sendBroadcast(bi);
				
			}
			
		}.start();
		
	}
	
	
}
