package com.example.intoto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {
	 
    // Splash screen timer
    //private static int SPLASH_TIME_OUT = 3000;
 Button lg1, lg2;
 
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        lg1 = (Button) findViewById(R.id.button);
        lg2 = (Button) findViewById(R.id.button2);
        
		lg1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent it = new Intent(MainActivity.this, loginactivity.class);
				
				startActivity(it);
 
            
			}
			}
		);
		lg2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent it = new Intent(MainActivity.this, loginactivity2.class);
				
				startActivity(it);
 
            
			}
			});
		}
    }