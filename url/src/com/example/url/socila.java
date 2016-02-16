package com.example.url;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class socila extends Activity {
	WebView webSocial;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        Bundle extras = getIntent().getExtras();
        int id = extras.getInt("id");
        webSocial = (WebView) findViewById(R.id.web_social);
        webSocial.getSettings().setJavaScriptEnabled(true);
         
       switch(id)
       {
       
	       case 1:
	    	   	  webSocial.loadUrl("http://ecampus.kgisliim.ac.in/ecampus/");
	           break;
	       
	       case 2:
	    	   	  webSocial.loadUrl("http://ecampus.kgisliim.ac.in/moodle/");
               break;
           
	       case 3:
		          webSocial.loadUrl("http://mail.kgkite.ac.in/");
	           break;
	           
	      
       }
    }
	
}
