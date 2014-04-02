package com.example.helloworld11638;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    
    boolean checkIfPressed = true;
    public void PressMe_Onclick(View v)
    {    	
    	if(checkIfPressed) {
    		//View View = mInflater.inflate(R.layout.gridelement, null);

    		Button mButton=(Button)findViewById(R.id.button1);
    	    mButton.setText("RESET");
    	    
    		TextView tv = (TextView)findViewById(R.id.helloworld);
        	tv.setText("Hello Jesper :D");
        	this.setTitle("Khaled Saieds App");
        	
        	checkIfPressed = false;
    	}
    	else if (checkIfPressed == false) {
    		Button mButton=(Button)findViewById(R.id.button1);
    	    mButton.setText("PRESS ME!");
    		
    		TextView tv = (TextView)findViewById(R.id.helloworld);
        	tv.setText("Hello World!");
        	this.setTitle("HelloWorld 11638");
        	
        	checkIfPressed = true;    		    		
    	}
    		
    	
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
