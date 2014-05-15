package itsmap.khaledsaied.handin2;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class Activity_A extends ActionBarActivity {
	
	private final static String TAG = "Activity_A";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"OnCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_);
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	private BroadcastReceiver br = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getExtras() != null) {
				long secondsLeft = intent.getLongExtra("countdown", 0);
				Toast toast = Toast.makeText(getApplicationContext(), "seconds left: "+secondsLeft,  Toast.LENGTH_SHORT);
		        toast.show();
			}		
		}
	};
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.d(TAG,"OnStop");
		super.onStop();
		try {
			unregisterReceiver(br);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG,"OnDestroy");
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Log.d(TAG,"OnPause");
		// TODO Auto-generated method stub
		super.onPause();
		unregisterReceiver(br);
	}
	@Override
	protected void onResume() {
		Log.d(TAG,"OnResume");
		// TODO Auto-generated method stub
		super.onResume();
		registerReceiver(br,new IntentFilter(AlarmService.COUNTDOWN_BR));
	}


	@Override
	protected void onRestart() {
		Log.d(TAG,"OnRestart");
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void startService (View v) {
		// send time
		int i = 5;
		EditText edit_text = (EditText)findViewById(R.id.editText1);
		if(!edit_text.getText().toString().equals("") && edit_text.getText().toString().length() > 0 ) {
			i = Integer.parseInt(edit_text.getText().toString());
		} 
			
		Intent intent = new Intent(getBaseContext(), AlarmService.class);
		intent.putExtra("the_time", i);

		startService(intent);	
	}
	


	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_activity_,
					container, false);
			return rootView;
		}
	}

}
