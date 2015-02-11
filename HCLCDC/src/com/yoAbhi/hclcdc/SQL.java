package com.yoAbhi.hclcdc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SQL extends Activity implements OnClickListener{

	Button send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sql);
		send.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View arg0) {
		Intent i = new Intent(SQL.this,Enquiry.class);
		startActivity(i);
	}

}