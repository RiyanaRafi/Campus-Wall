package com.example.url;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	 private ImageButton Button1;
     private ImageButton Button2;
     private ImageButton Button3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
        //		                   WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        setContentView(R.layout.activity_main);
        
       
       
         
      
            Button1  = (ImageButton)findViewById(R.id.imageButton1);
            Button2 = (ImageButton)findViewById(R.id.imageButton2);
            Button3= (ImageButton)findViewById(R.id.imageButton3);  
            Button1.setOnClickListener(this);
            Button2.setOnClickListener(this);
            Button3.setOnClickListener(this);  
        }
     
        @Override
        public void onClick(View v) {
        	int id;
            if (Button1.isPressed()) {
            	id=1;
                Intent i = new Intent(this, socila.class);
                Bundle bundle = new Bundle();
        		bundle.putInt("id", id);
        		i.putExtras(bundle);
                this.startActivity(i);
                 
            } else if (Button2.isPressed()) {
            	id=2;
                Intent i = new Intent(this, socila.class);
                Bundle bundle = new Bundle();
        		bundle.putInt("id", id);
        		i.putExtras(bundle);
                this.startActivity(i);
                this.startActivity(i);
            }
            else if (Button3.isPressed()) {
            	id=3;
                Intent i = new Intent(this, socila.class);
                Bundle bundle = new Bundle();
        		bundle.putInt("id", id);
        		i.putExtras(bundle);
                this.startActivity(i);
                this.startActivity(i);
            }
   
       
    }
}