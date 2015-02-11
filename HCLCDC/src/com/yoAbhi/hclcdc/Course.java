 package com.yoAbhi.hclcdc;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Course extends Activity implements OnItemSelectedListener{
		
		Spinner spinsoftware,spinhardware,spinindust,spinother;
		
		String Industclass[]={"","Indust"};
		
		String Otherclass[]={"","Other"};
		
		String Swclass[]={"","AdvJava","AndJava","Android","ASP","C","CJava","CPP","Database","DotNet","Java","Lamp","Moffice","PHP","SQL","VB"};
	
		String Hwclass[]={"","HWdesktop","HWelectronics","HWhcl","HWlinux","HWmicrosoft","HWnetworking","HWnewAdd","HWredHat","HWwin"};
		
		String[] strsoftware,strhardware,strindust,strother;
		
	
		
		@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_courses);
		
		
		
		spinsoftware=(Spinner)findViewById(R.id.spinsoftware);
		spinhardware=(Spinner)findViewById(R.id.spinhardware);
		spinindust=(Spinner)findViewById(R.id.spinindust);
		spinother=(Spinner)findViewById(R.id.spinother);
		
		strsoftware=getResources().getStringArray(R.array.softwarecourse);
		strhardware=getResources().getStringArray(R.array.hardwarecourse);
		strindust=getResources().getStringArray(R.array.industcourse);
		strother=getResources().getStringArray(R.array.othercourse);
		
		//other...
		
		Myadapter4 adother=new Myadapter4(Course.this,android.R.layout.simple_spinner_dropdown_item,R.id.tvswwithflag,strother);
		
		adother.setDropDownViewResource(R.layout.course_list);
		spinother.setAdapter(adother);
		
		spinother.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int position, long id) {
					if(position==0){
					
				}
				else{
				String currother=Otherclass[position];				
				try{
					
					Class myother=Class.forName("com.yoAbhi.hclcdc."+currother);
					Intent Otherintent = new Intent(Course.this,myother);
					startActivity(Otherintent);
					}
				catch(ClassNotFoundException e){
					e.printStackTrace();
				}
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// Industrial...
		
		Myadapter3 adindust=new Myadapter3(Course.this,android.R.layout.simple_spinner_dropdown_item,R.id.tvswwithflag,strindust);
		
		adindust.setDropDownViewResource(R.layout.course_list);
		spinindust.setAdapter(adindust);
		
		spinindust.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int position, long id) {
				if(position==0){
					
				}
				else{
				String currindust=Industclass[position];				
				try{
					
					Class myindust=Class.forName("com.yoAbhi.hclcdc."+currindust);
					Intent Industintent = new Intent(Course.this,myindust);
					startActivity(Industintent);
					}
				catch(ClassNotFoundException e){
					e.printStackTrace();
				}
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//Software...
		
		Myadapter adsoft=new Myadapter(Course.this,android.R.layout.simple_spinner_dropdown_item,R.id.tvswwithflag,strsoftware);
		
		adsoft.setDropDownViewResource(R.layout.course_list);
		spinsoftware.setAdapter(adsoft);
		
		spinsoftware.setOnItemSelectedListener(this);
		
		//hardware.....
		Myadapter2 adhard=new Myadapter2(Course.this,android.R.layout.simple_spinner_dropdown_item,R.id.tvswwithflag,strhardware);
		
		adhard.setDropDownViewResource(R.layout.course_list);
		spinhardware.setAdapter(adhard);
		spinhardware.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int position, long id) {
				if(position==0){
					
				}
				else{
				String currHw=Hwclass[position];				
				try{
					
					Class myhardware=Class.forName("com.yoAbhi.hclcdc."+currHw);
					Intent hardintent = new Intent(Course.this,myhardware);
					startActivity(hardintent);
					}
				catch(ClassNotFoundException e){
					e.printStackTrace();
				}
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
		
		//software.....
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			
		if(position==0){
			
		}
		else{	
			String currSw=Swclass[position];
			
			try{
				Class mysoft=Class.forName("com.yoAbhi.hclcdc."+currSw);
				
				Intent softintent = new Intent(Course.this,mysoft);
				startActivity(softintent);
				}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
		}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
		// class Myadapter for SW........
		private class Myadapter extends ArrayAdapter<String>{

			public Myadapter(Context context, int resource,
					int textViewResourceId, String[] strsoftware) {
				super(context, resource, textViewResourceId, strsoftware);
				// TODO Auto-generated constructor stub
			}
			
			@Override
		     public View getDropDownView(int position, View convertView,ViewGroup parent) {
		        return getCustomView(position, convertView, parent);
		     }

		    @Override
		    public View getView(int position, View convertView, ViewGroup parent) {
		        return getCustomView(position, convertView, parent);
		    }
			
		
		public View getCustomView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			View row=inflater.inflate(R.layout.course_list, parent,false);  
			
			String[] items=getResources().getStringArray(R.array.softwarecourse);
			ImageView ivflagsw=(ImageView)row.findViewById(R.id.ivflagsw);
			TextView tv=(TextView)row.findViewById(R.id.tvswwithflag);
			
			tv.setText(items[position]);
			
              if(items[position].equals("Select One")){
				
				
			}
			else if(items[position].equals("Adv. Java")){
				
				ivflagsw.setImageResource(R.drawable.ajava);
			}
			else if(items[position].equals("Android with Java")){
				
				ivflagsw.setImageResource(R.drawable.javawithandroid);
			}
			else if(items[position].equals("Android")){
				
				ivflagsw.setImageResource(R.drawable.android);
			}	
			else if(items[position].equals("ASP.NET")){
				
				ivflagsw.setImageResource(R.drawable.aspnet);
			}	
			else if(items[position].equals("C")){
				
				ivflagsw.setImageResource(R.drawable.c);
			}		
			else if(items[position].equals("CJava")){
				
				ivflagsw.setImageResource(R.drawable.cjava);
			}
			else if(items[position].equals("C++")){
				
				ivflagsw.setImageResource(R.drawable.cplus);
			}
			else if(items[position].equals("Database")){
				
				ivflagsw.setImageResource(R.drawable.database);
			}
			else if(items[position].equals("DotNET")){
				
				ivflagsw.setImageResource(R.drawable.net);
			}
			else if(items[position].equals("Java")){
			
				ivflagsw.setImageResource(R.drawable.java);
			}
			else if(items[position].equals("Lamp")){
				
				ivflagsw.setImageResource(R.drawable.lamp);
			}
			else if(items[position].equals("MS Office")){
				
				ivflagsw.setImageResource(R.drawable.msoffice);
			}
			else if(items[position].equals("PHP")){
				
				ivflagsw.setImageResource(R.drawable.php);
			}
			else if(items[position].equals("SQL")){
				
				ivflagsw.setImageResource(R.drawable.sql);
			}
			else if(items[position].equals("VB.NET")){
				
				ivflagsw.setImageResource(R.drawable.vbnet);
			}
			return row;
		}	
			
	}
		// for hard
		private class Myadapter2 extends ArrayAdapter<String>{

			public Myadapter2(Context context, int resource,
					int textViewResourceId, String[] strhardware) {
				super(context, resource, textViewResourceId,strhardware );
				// TODO Auto-generated constructor stub
			}
			
			@Override
		     public View getDropDownView(int position, View convertView,ViewGroup parent) {
		        return getCustomView(position, convertView, parent);
		     }

		    @Override
		    public View getView(int position, View convertView, ViewGroup parent) {
		        return getCustomView(position, convertView, parent);
		    }
			
		
		public View getCustomView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			View row=inflater.inflate(R.layout.course_list, parent,false);  
			
			String[] items=getResources().getStringArray(R.array.hardwarecourse);
			ImageView ivflagsw=(ImageView)row.findViewById(R.id.ivflagsw);
			TextView tv=(TextView)row.findViewById(R.id.tvswwithflag);
			
			tv.setText(items[position]);
			
              if(items[position].equals("Select One")){
				
				
			}
			else if(items[position].equals("Desktop")){
				
				ivflagsw.setImageResource(R.drawable.desktop);
			}
			else if(items[position].equals("Electronics")){
				
				ivflagsw.setImageResource(R.drawable.electronic);
			}
			else if(items[position].equals("HCL-Certified")){
				
				ivflagsw.setImageResource(R.drawable.hclcertified);
			}	
			else if(items[position].equals("Linux/Administration")){
				
				ivflagsw.setImageResource(R.drawable.linuxadmin);
			}	
			else if(items[position].equals("Microsoft")){
				
				ivflagsw.setImageResource(R.drawable.microsoft);
			}		
			else if(items[position].equals("Networking")){
				
				ivflagsw.setImageResource(R.drawable.networking);
			}
			else if(items[position].equals("New Additions")){
				
				ivflagsw.setImageResource(R.drawable.newaddition);
			}
			else if(items[position].equals("Red Hat")){
				
				ivflagsw.setImageResource(R.drawable.redhat);
			}
			else if(items[position].equals("Windows")){
				
				ivflagsw.setImageResource(R.drawable.windows);
			}
              return row;	
		}

	}
		private class Myadapter3 extends ArrayAdapter<String>{

			public Myadapter3(Context context, int resource,
					int textViewResourceId, String[] strindust) {
				super(context, resource, textViewResourceId,strindust );
				// TODO Auto-generated constructor stub
			}
			
			@Override
		     public View getDropDownView(int position, View convertView,ViewGroup parent) {
		        return getCustomView(position, convertView, parent);
		     }

		    @Override
		    public View getView(int position, View convertView, ViewGroup parent) {
		        return getCustomView(position, convertView, parent);
		    }
			
		
		public View getCustomView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			View row=inflater.inflate(R.layout.course_list, parent,false);  
			
			String[] items=getResources().getStringArray(R.array.industcourse);
			ImageView ivflagsw=(ImageView)row.findViewById(R.id.ivflagsw);
			TextView tv=(TextView)row.findViewById(R.id.tvswwithflag);
			
			tv.setText(items[position]);
			
              if(items[position].equals("Select One")){
				
				
			}
			else if(items[position].equals("Non IT")){
				
				ivflagsw.setImageResource(R.drawable.industrialtraining);
			}
              return row;
}
		}
		
		private class Myadapter4 extends ArrayAdapter<String>{

			public Myadapter4(Context context, int resource,
					int textViewResourceId, String[] strother) {
				super(context, resource, textViewResourceId,strother );
				// TODO Auto-generated constructor stub
			}
			
			@Override
		     public View getDropDownView(int position, View convertView,ViewGroup parent) {
		        return getCustomView(position, convertView, parent);
		     }

		    @Override
		    public View getView(int position, View convertView, ViewGroup parent) {
		        return getCustomView(position, convertView, parent);
		    }
			
		
		public View getCustomView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			View row=inflater.inflate(R.layout.course_list, parent,false);  
			
			String[] items=getResources().getStringArray(R.array.othercourse);
			ImageView ivflagsw=(ImageView)row.findViewById(R.id.ivflagsw);
			TextView tv=(TextView)row.findViewById(R.id.tvswwithflag);
			
			tv.setText(items[position]);
			
              if(items[position].equals("Select One")){
				
				
			}
			else if(items[position].equals("Project Training")){
				
				ivflagsw.setImageResource(R.drawable.nonit);
			}
              return row;
}
		}
}
		


