package com.yoAbhi.hclcdc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Certificate extends Activity {

	TextView s_name,f_name,s_centre,cert_no,c_name,dob;
	
	String certno,name, fname,cname ,scentre ,Sdob;
	
	// Progress Dialog
		private ProgressDialog pDialog;
		// Creating JSON Parser object
		JSONParser jParser = new JSONParser();
		
		ArrayList<HashMap<String, String>> productsList;
		
		// url to get all products list
		private static String url_detail = "http://10.0.2.2/Hclcdc_Database/CertificateDetail.php";

		// JSON Node names
		private static final String TAG_SUCCESS = "success";
		private static final String TAG_DETAIL = "detail";
		private static final String TAG_CERT_NO = "cert_no";
		private static final String TAG_S_NAME = "s_name";
		private static final String TAG_F_NAME = "f_name";
		private static final String TAG_S_CENTRE = "s_centre";
		private static final String TAG_C_NAME = "c_name";
		private static final String TAG_DOB = "dob";
		
		// products JSONArray
		JSONArray detail = null;
		
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.certificate_status);
		
		s_name=(TextView) findViewById(R.id.stName);
		s_name=(TextView) findViewById(R.id.stName2);
		f_name=(TextView) findViewById(R.id.stfather);
		s_centre=(TextView) findViewById(R.id.stCenter);
		cert_no=(TextView) findViewById(R.id.stCertiNo);
		c_name=(TextView) findViewById(R.id.c_name);
		dob=(TextView) findViewById(R.id.stDOB);
		cert_no=(TextView) findViewById(R.id.certiNo);
		
	/*	// Hashmap for ListView
				productsList = new ArrayList<HashMap<String, String>>();

				// Loading products in Background Thread
				new LoadAllProducts().execute();
		
	}
	class LoadAllProducts extends AsyncTask<String, String, String> {

	
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(Certificate.this);
			pDialog.setMessage("Loading products. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		
		protected String doInBackground(String... args) {
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// getting JSON string from URL
			JSONObject json = jParser.makeHttpRequest(url_detail, "GET", params);
			
			// Check your log cat for JSON reponse
			Log.d("All Products: ", json.toString());

			try {
				// Checking for SUCCESS TAG
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// products found
					// Getting Array of Products
					detail= json.getJSONArray(TAG_DETAIL);

					// looping through All Products
					for (int i = 0; i < detail.length(); i++) {
						JSONObject c = detail.getJSONObject(i);

						// Storing each json item in variable
						certno = c.getString(TAG_CERT_NO);
						Log.d("Abhiiiii", certno);
						name = c.getString(TAG_S_NAME);
						Log.d("Abhiiiii", name);
						fname = c.getString(TAG_F_NAME);
						Log.d("Abhiiiii", fname);
					    cname = c.getString(TAG_C_NAME);
					    scentre = c.getString(TAG_S_CENTRE);
						Sdob = c.getString(TAG_DOB);

						
					}
										
				} else {
					// no products found
					// Launch Add New product Activity
					Intent i = new Intent(getApplicationContext(),
							Main.class);
					// Closing all previous activities
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		protected void onPostExecute(String file_url) {
			// dismiss the dialog after getting all products
			pDialog.dismiss();
			// updating UI from Background Thread
			
			s_name.setText(name);
			f_name.setText(fname);
			c_name.setText(cname);
			s_centre.setText(scentre);
			dob.setText(Sdob);
			cert_no.setText(certno);
		}

	*/
	}
	

}
