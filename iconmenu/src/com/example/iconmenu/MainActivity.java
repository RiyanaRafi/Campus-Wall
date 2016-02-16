package com.example.iconmenu;
 
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
 

public class MainActivity extends Activity{
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.start);
	setTitle("INTOTO");
	TextView textElement = (TextView) findViewById(R.id.textView2);
//	textElement.setTextColor(0000);//this is green color
	Button button=(Button)findViewById(R.id.button1);
	 Button b = (Button) findViewById(R.id.button1);
     b.setOnClickListener(new OnClickListener() 
     {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getBaseContext(),start.class);
			startActivity(i);	
		}
    	 
     });
	
}
}
    