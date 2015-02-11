package com.yoAbhi.hclcdc;


import com.yoAbhi.semiWidget.SemiMenu;
import com.yoAbhi.semiWidget.SemiMenuItem;

import com.yoAbhi.semiWidget.SemiMenuItem.OnSemiMenuPressed;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity  {
     TextView tv;
     Button bcourse,bcareer,bfind,bmystatus;
     String[] to={"hclcdc@gmail.com"};
     private SemiMenu mMenu;
 	private SemiMenuItem mexit, mcontact, mInfo, mbrowser, memail;

     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Menu Items....
		mexit = new SemiMenuItem("exit", getResources().getDrawable(R.drawable.exit), "Thank you!");
		mcontact = new SemiMenuItem("call", getResources().getDrawable(R.drawable.contact), "Call");
		mInfo = new SemiMenuItem("info", getResources().getDrawable(R.drawable.info), "Info");
		mbrowser = new SemiMenuItem("mbrowser", getResources().getDrawable(R.drawable.browser), "Internet");
		memail = new SemiMenuItem("search", getResources().getDrawable(R.drawable.e_mail), "Email");
		
		mMenu = (SemiMenu) findViewById(R.id.radial_menu);
		mMenu.addMenuItem(mexit.getMenuID(), mexit);
		mMenu.addMenuItem(mcontact.getMenuID(), mcontact);
		mMenu.addMenuItem(mInfo.getMenuID(), mInfo);
		mMenu.addMenuItem(mbrowser.getMenuID(), mbrowser);
		mMenu.addMenuItem(memail.getMenuID(), memail);
		
		// add PhoneStateListener
		PhoneCallListener phoneListener = new PhoneCallListener();
		TelephonyManager telephonyManager = (TelephonyManager) this
			.getSystemService(Context.TELEPHONY_SERVICE);
		telephonyManager.listen(phoneListener,PhoneStateListener.LISTEN_CALL_STATE);
		
		// end of phone call.. 
		
		mexit.setOnSemiMenuPressed(new OnSemiMenuPressed() {
			public void onMenuItemPressed() {
				Toast.makeText(Main.this, mexit.getText(), Toast.LENGTH_SHORT).show();
				finish();
			}
		});
		
		mcontact.setOnSemiMenuPressed(new OnSemiMenuPressed() {
			@Override
			public void onMenuItemPressed() {
				
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:18601801425"));
				startActivity(callIntent);
			}
		});
		
		mInfo.setOnSemiMenuPressed(new OnSemiMenuPressed() {
			@Override
			public void onMenuItemPressed() {
				Intent i =new Intent(Main.this,Aboutus.class);
				startActivity(i);
			}
		});
		
		mbrowser.setOnSemiMenuPressed(new OnSemiMenuPressed() {
			@Override
			public void onMenuItemPressed() {
				Intent i =new Intent(Main.this,MyBrowser.class);
				startActivity(i);
			}
		});
		
		memail.setOnSemiMenuPressed(new OnSemiMenuPressed() {
			@Override
			public void onMenuItemPressed() {
				Intent emailIntent=new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,to);
				emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Enquiry about Admission");
				emailIntent.putExtra(Intent.EXTRA_TEXT,"");
				emailIntent.setType("text/plain");
				startActivity(Intent.createChooser(emailIntent, "choose Email client"));
				mMenu.dismissMenu();
			}
		});
		
		
		
		//end of menu items..
		
		tv=(TextView) findViewById(R.id.header);
		bcourse=(Button)findViewById(R.id.courses);
		bcareer=(Button)findViewById(R.id.career);
		bfind=(Button)findViewById(R.id.bfind);
		bmystatus=(Button)findViewById(R.id.bmystatus);
		
		bcourse.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent icourse = new Intent(Main.this,Course.class);
				
				startActivity(icourse);
			}
		});
		
		
			bmystatus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent imystatus = new Intent(Main.this,Mystatus.class);
				
				startActivity(imystatus);
			}
		});

		bcareer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent icareer=new Intent(Main.this,Career.class);
				
				startActivity(icareer);
				
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		MenuInflater menuUp=getMenuInflater();
		menuUp.inflate(R.menu.coolmenu, menu);
		return true;
	}

	

	//monitor phone call activities
	private class PhoneCallListener extends PhoneStateListener {
 
		private boolean isPhoneCalling = false;
 
		String LOG_TAG = "LOGGING 123";
 
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
 
			if (TelephonyManager.CALL_STATE_RINGING == state) {
				// phone ringing
				Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
			}
 
			if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
				// active
				Log.i(LOG_TAG, "OFFHOOK");
 
				isPhoneCalling = true;
			}
 
			if (TelephonyManager.CALL_STATE_IDLE == state) {
				// run when class initial and phone call ended, 
				// need detect flag from CALL_STATE_OFFHOOK
				Log.i(LOG_TAG, "IDLE");
 
				if (isPhoneCalling) {
 
					Log.i(LOG_TAG, "restart app");
 
					// restart app
					Intent i = getBaseContext().getPackageManager()
						.getLaunchIntentForPackage(
							getBaseContext().getPackageName());
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
 
					isPhoneCalling = false;
				}
 
			}
		}
	}

	}


