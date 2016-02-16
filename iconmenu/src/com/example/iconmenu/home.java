package com.example.iconmenu;

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


public class home extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	 private Button Button1;
     private Button Button2;
     private Button Button3;
     private Button Button4;
     private Button Button5;
     private Button Button6;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
        //		                   WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        setContentView(R.layout.ios);
            Button1  = (Button)findViewById(R.id.button1);
            Button2 = (Button)findViewById(R.id.button2);
            Button3= (Button)findViewById(R.id.button3); 
            Button4= (Button)findViewById(R.id.button4); 
            Button5= (Button)findViewById(R.id.button5); 
            Button6= (Button)findViewById(R.id.button6); 
            Button1.setOnClickListener(this);
            Button2.setOnClickListener(this);
            Button3.setOnClickListener(this);  
            Button4.setOnClickListener(this); 
            Button5.setOnClickListener(this); 
            Button6.setOnClickListener(this); 
            
        }
     
        @Override
        public void onClick(View v) {
        	int id;
            if (Button1.isPressed()) {
            	id=1;
                Intent i = new Intent(this, url.class);
                Bundle bundle = new Bundle();
        		bundle.putInt("id", id);
        		i.putExtras(bundle);
                this.startActivity(i);
                 
            } else if (Button2.isPressed()) {
            	id=2;
                Intent i = new Intent(this, url.class);
                Bundle bundle = new Bundle();
        		bundle.putInt("id", id);
        		i.putExtras(bundle);
                this.startActivity(i);
                this.startActivity(i);
            }
            else if (Button3.isPressed()) {
            	id=3;
                Intent i = new Intent(this, url.class);
                Bundle bundle = new Bundle();
        		bundle.putInt("id", id);
        		i.putExtras(bundle);
                this.startActivity(i);
                this.startActivity(i);
            }
            else if (Button4.isPressed()) {
            	id=4;
                Intent i = new Intent(this, url.class);
                Bundle bundle = new Bundle();
        		bundle.putInt("id", id);
        		i.putExtras(bundle);
                this.startActivity(i);
                this.startActivity(i);
            }
   
            else if (Button5.isPressed()) {
            	id=5;
                Intent i = new Intent(this, url.class);
                Bundle bundle = new Bundle();
        		bundle.putInt("id", id);
        		i.putExtras(bundle);
                this.startActivity(i);
                this.startActivity(i);
            }
   
            else if (Button6.isPressed()) {
            	id=6;
                Intent i = new Intent(this, url.class);
                Bundle bundle = new Bundle();
        		bundle.putInt("id", id);
        		i.putExtras(bundle);
                this.startActivity(i);
                this.startActivity(i);
            }
   
   
       
    }
}