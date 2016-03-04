package com.example.intoto;


import android.app.TabActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
@SuppressWarnings({ "deprecation", "unused" })
public class MyActivity extends TabActivity {
	String username;
	TabHost tabHost;
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r_layout);
        username= getIntent().getExtras().getString("Username");
        TabHost tabHost = getTabHost();
    //    tabHost.setOnTabChangedListener(this);
        
        TabSpec photospec = tabHost.newTabSpec("HOME");
        photospec.setIndicator("HOME", getResources().getDrawable(R.drawable.abc_ic_clear_disabled));
        Intent photosIntent = new Intent(this, EventActiviy.class);
        photosIntent.putExtra("Username", username);
        photospec.setContent(photosIntent);
        
         
        // Tab for Songs
        TabSpec songspec = tabHost.newTabSpec("POST");        
        songspec.setIndicator("POST", getResources().getDrawable(R.drawable.ic_launcher));
        Intent songsIntent = new Intent(this, OtherActivity.class);
        songsIntent.putExtra("Username", username);
        songspec.setContent(songsIntent);
        
         
        // Tab for Videos
        TabSpec videospec = tabHost.newTabSpec("UPDATES");
       videospec.setIndicator("UPDATE", getResources().getDrawable(R.drawable.ic_launcher));
        Intent videosIntent = new Intent(this, list.class);
        videosIntent.putExtra("Username", username);
        videospec.setContent(videosIntent);
        
         
        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
        tabHost.addTab(videospec);// Adding videos tab
      /*  for(int i=0;i&lt;tabHost.getTabWidget().getChildCount();i++)
        {
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#8A4117"));
        }
        tabHost.getTabWidget().setCurrentTab(1);
        tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#C35817"));
     }
        
        
 
	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		
		 for(int i=0;i&lt;tabHost.getTabWidget().getChildCount();i++)
	        {
	            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#8A4117"));
	        }
	 
	        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#C35817"));
	    
		
	}*/
}
}
