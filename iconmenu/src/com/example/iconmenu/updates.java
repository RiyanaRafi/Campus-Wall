package com.example.iconmenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class updates extends Activity
{
	
	
	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

	
	
	 public void onCreate(Bundle savedInstanceState)
	 
	 {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.update);
     setTitle("Updates");
	        StrictMode.setThreadPolicy(policy);
	       // Button button = (Button) findViewById(R.id.button2);

	        connect();
	      
	    
	 }
	    private void connect() {
	    String data;
	    List<String> r = new ArrayList<String>();
	    ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,r);
	    ListView list=(ListView)findViewById(R.id.listView1);
	        try {
	            DefaultHttpClient client = new DefaultHttpClient();
	            HttpGet request = new HttpGet("http://10.100.9.172/selectall.php");
	            HttpResponse response = client.execute(request);
	            HttpEntity entity=response.getEntity();
	            data=EntityUtils.toString(entity);
	            Log.e("STRING", data);
	            try {
	            
	    JSONArray json=new JSONArray(data);
	    for(int i=0;i<json.length(); i++)
	    {
	    JSONObject obj=json.getJSONObject(i);
	    String name=obj.getString("data");
	  //  String year=obj.getString("year");
	   // String age=obj.getString("age");
	    Log.e("STRING", data);
	    //text.settec
	    r.add(name);
	    
	   
	    list.setAdapter(adapter);
	    
	    }
	    
	    } catch (JSONException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    }
	         
	        } catch (ClientProtocolException e) {
	            Log.d("HTTPCLIENT", e.getLocalizedMessage());
	        } catch (IOException e) {
	            Log.d("HTTPCLIENT", e.getLocalizedMessage());
	        }
	     
	     
	 }
	 
	

}
