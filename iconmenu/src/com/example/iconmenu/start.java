package com.example.iconmenu;
 
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
@SuppressWarnings("deprecation")
public class start extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
        TabHost tabHost = getTabHost();
         
        // Tab for Photos
        TabSpec photospec = tabHost.newTabSpec("HOME");
        // setting Title and Icon for the Tab
       photospec.setIndicator("HOME", getResources().getDrawable(R.drawable.abc_ic_clear_disabled));
        Intent photosIntent = new Intent(this, home.class);
        photospec.setContent(photosIntent);
         
        // Tab for Songs
        TabSpec songspec = tabHost.newTabSpec("POST");        
        songspec.setIndicator("POST", getResources().getDrawable(R.drawable.ic_launcher));
        Intent songsIntent = new Intent(this, post.class);
        songspec.setContent(songsIntent);
         
        // Tab for Videos
        TabSpec videospec = tabHost.newTabSpec("UPDATES");
       videospec.setIndicator("UPDATE", getResources().getDrawable(R.drawable.ic_launcher));
        Intent videosIntent = new Intent(this, updates.class);
        videospec.setContent(videosIntent);
         
        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
        tabHost.addTab(videospec); // Adding videos tab
        
    }
}
