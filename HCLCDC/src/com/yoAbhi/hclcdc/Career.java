package com.yoAbhi.hclcdc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Career extends Activity implements OnItemSelectedListener{

	EditText edCname,edCemail,edCmobile;
	Spinner courseCspin,stateCspin,centreCspin;
	Button sub;
	String[] strstate,strcity,strcourses;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_career);
		
		edCname=(EditText)findViewById(R.id.edCname);
		edCemail=(EditText)findViewById(R.id.edCname);
		edCmobile=(EditText)findViewById(R.id.edCmobile);
		courseCspin=(Spinner) findViewById(R.id.courseCspin);
		stateCspin=(Spinner) findViewById(R.id.stateCspin);
		centreCspin=(Spinner) findViewById(R.id.centreCspin);
		
		sub=(Button)findViewById(R.id.Csubmit);
		
		// String arrays
		
		strstate=getResources().getStringArray(R.array.statearray);
		strcourses=getResources().getStringArray(R.array.courses);
		
		//course adapter
		ArrayAdapter<String> adc =new ArrayAdapter<String>(Career.this,android.R.layout.simple_spinner_dropdown_item,strcourses);
		courseCspin.setAdapter(adc);
		
		// state array
		ArrayAdapter<String> ad =new ArrayAdapter<String>(Career.this,android.R.layout.simple_spinner_dropdown_item,strstate);
		stateCspin.setAdapter(ad);
		stateCspin.setOnItemSelectedListener(this);
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int pos,
			long id) {
		switch(pos){
			case 0:
		    case 1:
		    	String[] strandhra;
		    	strandhra =getResources().getStringArray(R.array.andhraarray);
		    	ArrayAdapter<String> ad1 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item, strandhra);
				centreCspin.setAdapter(ad1);
		    	break;
		    case 2:	
		    	String[] strasam;
		    	strasam =getResources().getStringArray(R.array.asamarray);
		    	ArrayAdapter<String> ad2 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item, strasam);
		    	centreCspin.setAdapter(ad2);
		    	break;
		    case 3:
		    	String[] strbihar;
		    	strbihar =getResources().getStringArray(R.array.bihararray);
		    	ArrayAdapter<String> ad3 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item,strbihar);
		    	centreCspin.setAdapter(ad3);
		    	break;
		    case 4:
		    	String[] strchandi;
		    	strchandi =getResources().getStringArray(R.array.chandiarray);
		    	ArrayAdapter<String> ad4 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item,strchandi);
		    	centreCspin.setAdapter(ad4);
		    	break;
		    case 5:
		    	String[] strdelhi;
		    	strdelhi =getResources().getStringArray(R.array.delhiarray);
		    	ArrayAdapter<String> ad5 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item, strdelhi);
		    	centreCspin.setAdapter(ad5);
		    	break;
		    case 6:
		    	String[] strguj;
		    	strguj =getResources().getStringArray(R.array.gujarray);
		    	ArrayAdapter<String> ad6 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item, strguj);
		    	centreCspin.setAdapter(ad6);
		    	break;
		    case 7:
		    	String[] strhary;
		    	strhary =getResources().getStringArray(R.array.haryaarray);
		    	ArrayAdapter<String> ad7 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item,strhary);
		    	centreCspin.setAdapter(ad7);
		    	break;	
		    case 8:
		    	String[] strjhar;
		    	strjhar =getResources().getStringArray(R.array.jhararray);
		    	ArrayAdapter<String> ad8 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item, strjhar);
		    	centreCspin.setAdapter(ad8);
		    	break;
		    	
		    case 9:
		    	String[] strmp;
		    	strmp =getResources().getStringArray(R.array.mparray);
		    	ArrayAdapter<String> ad10 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item,strmp);
		    	centreCspin.setAdapter(ad10);
		    	break;
		    case 10:	
		    	String[] strmaha;
		    	strmaha =getResources().getStringArray(R.array.mahaarray);
		    	ArrayAdapter<String> ad9 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item,strmaha);
		    	centreCspin.setAdapter(ad9);
		    	break;
		   
		    case 11:
		    	String[] strori;
		    	strori =getResources().getStringArray(R.array.orrisaarray);
		    	ArrayAdapter<String> ad11 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item, strori);
		    	centreCspin.setAdapter(ad11);
		    	break;
		    case 12:
		    	String[] strpj;
		    	strpj =getResources().getStringArray(R.array.punjabarray);
		    	ArrayAdapter<String> ad12 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item,strpj);
		    	centreCspin.setAdapter(ad12);
		    	break;
		    case 13:
		    	String[] strrj;
		    	strrj =getResources().getStringArray(R.array.rajarray);
		    	ArrayAdapter<String> ad13 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item, strrj);
		    	centreCspin.setAdapter(ad13);
		    	 break;
		    case 14:
		    	String[] strtam;
		    	strtam =getResources().getStringArray(R.array.tamilarray);
		    	ArrayAdapter<String> ad14 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item, strtam);
		    	centreCspin.setAdapter(ad14);
		    	 break;
		    case 15:
		    	String[] strup;
		    	strup =getResources().getStringArray(R.array.uparray);
		    	ArrayAdapter<String> ad15 = new ArrayAdapter<String>(Career.this, android.R.layout.simple_spinner_dropdown_item,strup);
		    	centreCspin.setAdapter(ad15);
		    	break;
		    	
			default:
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
