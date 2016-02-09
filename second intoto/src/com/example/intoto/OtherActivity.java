package com.example.intoto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OtherActivity extends ActionBarActivity {
	EditText msg;
	Button post;
	String data,username;
	Intent it;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nw_layout);
		  
		msg = (EditText) findViewById(R.id.editText3);
		
		post = (Button) findViewById(R.id.button2);
		
		post.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				data = msg.getText().toString();
				 username= getIntent().getExtras().getString("Username");
				try {
					data = URLEncoder.encode(data, "UTF-8");
					username = URLEncoder.encode(username, "UTF-8");
					String url = "http://10.100.9.171/insert.php?data="
							+ data.trim() + "&Username=" + username.trim();
					System.out.println(url);
					pass_value_to_db get = new pass_value_to_db();
					get.execute(new String[] { url });
					Intent it = new Intent(OtherActivity.this, list.class);
					
					startActivity(it);

				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

	public class pass_value_to_db extends AsyncTask<String, Void, String> {

		ProgressDialog dialog;

		@Override
		protected void onPreExecute() { // TODO Auto-generated method stub
			dialog = new ProgressDialog(OtherActivity.this);
			dialog.setTitle("Processing...");
			dialog.setMessage("Please wait.");
			dialog.setCancelable(false);
			dialog.show();
		}

		@Override
		protected String doInBackground(String... urls) {
			String result = "";
			for (String url : urls) {
				InputStream is = null;
				try {

					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httppost = new HttpPost(url);
					HttpResponse response = httpclient.execute(httppost);
					int status = response.getStatusLine().getStatusCode();
					Log.d("KG", "status=" + status);

					if (status == 200) {
						HttpEntity entity = response.getEntity();
						is = entity.getContent();
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(is, "iso-8859-1"), 8);
						String line = "";
						while ((line = reader.readLine()) != null) {
							result += line;
						}
						is.close();

						Log.v("KG", result);

					}
				} catch (Exception ex) {
					Log.e("Error", ex.toString());
				}
			}
			return result;
		}

		protected void onPostExecute(String res) {
			Log.v("KG", "output=" + res);
			res = res.trim(); //
			// Toast.makeText(getApplicationContext(), result, //
			// Toast.LENGTH_LONG).show();
			if (res.equals("0")) {

				Toast.makeText(getApplicationContext(),
						" Please try again later...", Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(getApplicationContext(), "Posted...",
						Toast.LENGTH_LONG).show();
				System.out.println("Sucess");
				

			}

			if (dialog != null)
				dialog.dismiss();

		}

	}

	// @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Intent a = new Intent(MainActivity.this, list.class);
	// startActivity(a);

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.nw_layout, container,
					false);
			return rootView;
		}
	}


