package com.example.intoto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends ActionBarActivity {
Intent intent;
String username;

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.r_layout);
	    final String username= getIntent().getExtras().getString("Username");
	     
	    GridView gridview = (GridView) findViewById(R.id.gridView1);
	    gridview.setAdapter(new adapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(MyActivity.this, "Loading" + position,
	                    Toast.LENGTH_SHORT).show();
	        if(position==0)
	        {
	        	intent=new Intent(getApplicationContext(),OtherActivity.class);
	        }
	        if(position==1)
	        {
	        	intent=new Intent(getApplicationContext(),EventActiviy.class);
	        }
	        if(position==2)
	        {
	        	intent=new Intent(getApplicationContext(),GrpActivity3.class);
	        }
	        if(position==3)
	        {
	        	intent=new Intent(getApplicationContext(),AnonceActivity4.class);
	        }
	        intent.putExtra("Username", username);
	        startActivity(intent);
	        
	        
	       }
	    });
	}
}