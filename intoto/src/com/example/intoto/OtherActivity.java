package com.example.intoto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Contacts.Intents.UI;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OtherActivity extends Activity {
	EditText msg;
	Button button, up;
	String data,username;
	Intent intent; 
	
	
	
		TextView text;
		    @SuppressLint("NewApi") @Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.nw_layout);
		        final StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		        Button button = (Button) findViewById(R.id.button2);
		        button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						String result = null;
		        	   	InputStream is = null;
		        	   	EditText editText = (EditText)findViewById(R.id.editText3);
		        	   	String data = editText.getText().toString();
		        	   	username= getIntent().getExtras().getString("Username");
		        	   	
		        	   	/*ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		        	  
		        	   	nameValuePairs.add(new BasicNameValuePair("data",data));
		        	   	nameValuePairs.add(new BasicNameValuePair("Username",username));*/

		        	   	StrictMode.setThreadPolicy(policy); 


		    	//http post
		    	try{
		    		username = URLEncoder.encode(username, "UTF-8");
					data = URLEncoder.encode(data, "UTF-8");
					String url = "http://10.100.9.184/insert.php?Username="
							+ username.trim() + "&data=" + data.trim();
		    	        HttpClient httpclient = new DefaultHttpClient();
		    	        HttpPost httppost = new HttpPost(url);
		    	        //httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		    	        HttpResponse response = httpclient.execute(httppost); 
		    	        HttpEntity entity = response.getEntity();
		    	        is = entity.getContent();

		    	        Log.e("log_tag", "connection success ");
		    	        Toast.makeText(getApplicationContext(), "Posted Sucessfully", Toast.LENGTH_SHORT).show();
		    	   }
		    	
		    	
		    	catch(Exception e)
		    	{
		    	        Log.e("log_tag", "Error in http connection "+e.toString());
		    	        Toast.makeText(getApplicationContext(), "Connection fail", Toast.LENGTH_SHORT).show();

		    	}
		    	//convert response to string
		    	try{
		    		 BufferedReader reader = new BufferedReader(new InputStreamReader(
		                    is, "UTF-8"), 8);
		    	        StringBuilder sb = new StringBuilder();
		    	        String line = null;
		    	        while ((line = reader.readLine()) != null) 
		    	        {
		    	                sb.append(line + "\n");
		    	                Intent intent = new Intent(getBaseContext(),list.class);
		    	                startActivity(intent);
		    	        }
		    	        is.close();

		    	        result=sb.toString();
		    	}
		    	catch(Exception e)
		    	{
		    	       Log.e("log_tag", "Error converting result "+e.toString());
		       	}


		    	try{
		    		
		    					JSONObject json_data = new JSONObject(result);

		    	                CharSequence w= (CharSequence) json_data.get("re");
		    	              
		    	                Toast.makeText(getApplicationContext(), w, Toast.LENGTH_SHORT).show();

		    	      
		    	     }
		    	catch(JSONException e)
		    	   {
		    	        Log.e("log_tag", "Error parsing data "+e.toString());
		    	        Toast.makeText(getApplicationContext(), "JsonArray fail", Toast.LENGTH_SHORT).show();
		    	    }

		    	

		   }
		   });
		    
		        Button up = (Button) findViewById(R.id.uploadButton);
		        up.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent it = new Intent(OtherActivity.this,MainActivity.class);
						it.putExtra("Username", username);
						startActivity(it);
						
					}
		        });}
		    }	
		
