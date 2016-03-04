package com.example.intoto;

import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainContent extends Activity {
	
	Context context;
		 String username ;
		InputStream is = null;
	 String final_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.like);

        TextView textView =(TextView)findViewById(R.id.textView1);
        Intent intent = getIntent();
             if(intent!= null){
            Bundle extras = intent.getExtras();
            if(extras != null){
                final_data = extras.getString("final_data");
                textView.setText(""+final_data);
            }
        }
       
			 }
		  
		
		}
		