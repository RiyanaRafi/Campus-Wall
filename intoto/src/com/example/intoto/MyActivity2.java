package com.example.intoto;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MyActivity2 extends TabActivity {
			String username;
		
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.r2_layout);
	        username= getIntent().getExtras().getString("Username");
	        TabHost tabHost = getTabHost();
	        
	        // Tab for Photos
	        TabSpec photospec = tabHost.newTabSpec("HOME");
	        photospec.setIndicator("HOME", getResources().getDrawable(R.drawable.abc_ic_clear_disabled));
	        Intent photosIntent = new Intent(this, EventActiviy.class);
	        photosIntent.putExtra("Username", username);
	        photospec.setContent(photosIntent);
	        
	         
	        
	         
	        // Tab for Videos
	        TabSpec videospec = tabHost.newTabSpec("UPDATES");
	       videospec.setIndicator("UPDATE", getResources().getDrawable(R.drawable.ic_launcher));
	        Intent videosIntent = new Intent(this, list.class);
	        videosIntent.putExtra("Username", username);
	        videospec.setContent(videosIntent);
	        
	         
	        // Adding all TabSpec to TabHost
	        tabHost.addTab(photospec); // Adding photos tab
	        
	        tabHost.addTab(videospec); // Adding videos tab
	        
	       
	    }
	}
