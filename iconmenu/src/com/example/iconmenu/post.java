package com.example.iconmenu;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
public class post extends Activity {
TextView text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        final StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String result = null;
        	   	InputStream is = null;
        	   	EditText editText = (EditText)findViewById(R.id.editText1);
        	   	String data = editText.getText().toString();
        	   
        	   	
        	   	ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        	  
        	   	nameValuePairs.add(new BasicNameValuePair("data",data));
        	 

        	   	StrictMode.setThreadPolicy(policy); 


    	//http post
    	try{
    	        HttpClient httpclient = new DefaultHttpClient();
    	        HttpPost httppost = new HttpPost("http://10.100.9.172/insertphp.php");
    	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
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
    	                Intent i = new Intent(getBaseContext(),updates.class);
    	                startActivity(i);
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
    
    

}
}



            	   