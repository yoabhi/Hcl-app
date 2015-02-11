package com.yoAbhi.hclcdc;


import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Enquiry extends Activity implements OnItemSelectedListener,OnClickListener{

	private ProgressDialog pDialog;
	
	EditText inputname,inputemail,inputmob,inputques;
	Button submit,cancel;
	Spinner spinstate,spincity,spincourse;
	String[] strstate,strcity,strcourse;
	
	JSONParser jsonParser = new JSONParser();
	
	
	// url to create new product
	
    private static String url_upload = "http://10.0.2.2/android_connect/upload.php";
   
	private static final String TAG_SUCCESS = "success";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sendquery);
		
		// EditTexts...
		
		inputname=(EditText)findViewById(R.id.edname);
		inputemail=(EditText)findViewById(R.id.edemail);
		inputmob=(EditText)findViewById(R.id.edmob);
		inputques=(EditText)findViewById(R.id.edques);
		
		
		//Spinners..
		
		spinstate=(Spinner)findViewById(R.id.statespin);
		spincity=(Spinner)findViewById(R.id.cityspin);
		spincourse=(Spinner)findViewById(R.id.spincourse);
		
		//buttons
		
		submit=(Button)findViewById(R.id.submit);
		cancel=(Button)findViewById(R.id.cancel);
		
		strstate=getResources().getStringArray(R.array.statearray);
		strcourse=getResources().getStringArray(R.array.courses);
		
		ArrayAdapter<String> ad= new ArrayAdapter<String>(Enquiry.this,android.R.layout.simple_spinner_dropdown_item,strstate);
		
		spinstate.setAdapter(ad);
		spinstate.setOnItemSelectedListener(this);
		
		ArrayAdapter<String> adcourse = new ArrayAdapter<String>(Enquiry.this,android.R.layout.simple_spinner_dropdown_item,strcourse);
		spincourse.setAdapter(adcourse);
		
		submit.setOnClickListener(this);
		
		}
	
	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int pos,
			long id) {
		switch(pos){
			case 0:
		    case 1:
		    	String[] strandhra;
		    	strandhra =getResources().getStringArray(R.array.andhraarray);
		    	ArrayAdapter<String> ad1 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item, strandhra);
				spincity.setAdapter(ad1);
		    	break;
		    case 2:	
		    	String[] strasam;
		    	strasam =getResources().getStringArray(R.array.asamarray);
		    	ArrayAdapter<String> ad2 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item, strasam);
				spincity.setAdapter(ad2);
		    	break;
		    case 3:
		    	String[] strbihar;
		    	strbihar =getResources().getStringArray(R.array.bihararray);
		    	ArrayAdapter<String> ad3 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item,strbihar);
				spincity.setAdapter(ad3);
		    	break;
		    case 4:
		    	String[] strchandi;
		    	strchandi =getResources().getStringArray(R.array.chandiarray);
		    	ArrayAdapter<String> ad4 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item,strchandi);
				spincity.setAdapter(ad4);
		    	break;
		    case 5:
		    	String[] strdelhi;
		    	strdelhi =getResources().getStringArray(R.array.delhiarray);
		    	ArrayAdapter<String> ad5 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item, strdelhi);
				spincity.setAdapter(ad5);
		    	break;
		    case 6:
		    	String[] strguj;
		    	strguj =getResources().getStringArray(R.array.gujarray);
		    	ArrayAdapter<String> ad6 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item, strguj);
				spincity.setAdapter(ad6);
		    	break;
		    case 7:
		    	String[] strhary;
		    	strhary =getResources().getStringArray(R.array.haryaarray);
		    	ArrayAdapter<String> ad7 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item,strhary);
				spincity.setAdapter(ad7);
		    	break;	
		    case 8:
		    	String[] strjhar;
		    	strjhar =getResources().getStringArray(R.array.jhararray);
		    	ArrayAdapter<String> ad8 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item, strjhar);
				spincity.setAdapter(ad8);
		    	break;
		   
		    case 9:
		    	String[] strmp;
		    	strmp =getResources().getStringArray(R.array.mparray);
		    	ArrayAdapter<String> ad10 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item,strmp);
				spincity.setAdapter(ad10);
		    	break;	
		    
		    case 10:	
		    	String[] strmaha;
		    	strmaha =getResources().getStringArray(R.array.mahaarray);
		    	ArrayAdapter<String> ad9 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item,strmaha);
				spincity.setAdapter(ad9);
		    	break;
		  
		    case 11:
		    	String[] strori;
		    	strori =getResources().getStringArray(R.array.orrisaarray);
		    	ArrayAdapter<String> ad11 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item, strori);
				spincity.setAdapter(ad11);
		    	break;
		    case 12:
		    	String[] strpj;
		    	strpj =getResources().getStringArray(R.array.punjabarray);
		    	ArrayAdapter<String> ad12 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item,strpj);
				spincity.setAdapter(ad12);
		    	break;
		    case 13:
		    	String[] strrj;
		    	strrj =getResources().getStringArray(R.array.rajarray);
		    	ArrayAdapter<String> ad13 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item, strrj);
				spincity.setAdapter(ad13);
		    	 break;
		    case 14:
		    	String[] strtam;
		    	strtam =getResources().getStringArray(R.array.tamilarray);
		    	ArrayAdapter<String> ad14 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item, strtam);
				spincity.setAdapter(ad14);
		    	 break;
		    case 15:
		    	String[] strup;
		    	strup =getResources().getStringArray(R.array.uparray);
		    	ArrayAdapter<String> ad15 = new ArrayAdapter<String>(Enquiry.this, android.R.layout.simple_spinner_dropdown_item,strup);
				spincity.setAdapter(ad15);
		    	break;
		    	
			default:
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onClick(View arg0) {
		
		new CreateNew().execute();
		
		
	}
	
  class CreateNew extends AsyncTask<String, String, String>{

	  @Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(Enquiry.this);
			pDialog.setMessage("Uploading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
			
		}

	  
	@Override
	protected String doInBackground(String... arg0) {
		
		String name=inputname.getText().toString();
	    String email=inputemail.getText().toString();
	    String mob=inputmob.getText().toString();
	    String ques=inputques.getText().toString();
	    String sel_course=spincourse.getSelectedItem().toString();
	    String state=spinstate.getSelectedItem().toString();
		String city=spincity.getSelectedItem().toString();
		
		List<NameValuePair> params =new ArrayList<NameValuePair>();
		 params.add(new BasicNameValuePair("name",name));
         params.add(new BasicNameValuePair("email",email));
         params.add(new BasicNameValuePair("mob",mob));
         params.add(new BasicNameValuePair("sel_course",sel_course));
         params.add(new BasicNameValuePair("ques", ques));
         params.add(new BasicNameValuePair("state",state));
         params.add(new BasicNameValuePair("city",city));
         
         
         // Note that create product url accepts POST method
         JSONObject json = jsonParser.makeHttpRequest(url_upload,
                 "POST", params);
        
        
         Toast.makeText(getApplicationContext(), "Upload Successful",Toast.LENGTH_LONG).show();

        
      // check log cat fro response
         Log.d("Create Response", json.toString());
         
      // check for success tag
        try {
        	
             int success = json.getInt(TAG_SUCCESS);

             if (success == 1) {
                 // successfully created product
           Toast.makeText(getApplicationContext(), "Upload Successful",Toast.LENGTH_SHORT).show();

                 // closing this screen
                 Intent i = new Intent(Enquiry.this,Main.class);
                 startActivity(i);
             } else {
                 // failed to create product
             }
         } catch (JSONException e) {
             e.printStackTrace();
         }

         return null;
	}
	  
	@Override
	protected void onPostExecute(String file_url) {
		// dismiss the dialog once done
		pDialog.dismiss();
	  
  }
}

}