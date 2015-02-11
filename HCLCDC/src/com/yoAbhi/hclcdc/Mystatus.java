package com.yoAbhi.hclcdc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Mystatus extends Activity {

	Button bsearch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mystatus);
		
		bsearch=(Button)findViewById(R.id.bsearch);
		
		bsearch.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				
				Intent i= new Intent(Mystatus.this,Certificate.class);
				startActivity(i);
				
				
			}
		});
	}

	
}
