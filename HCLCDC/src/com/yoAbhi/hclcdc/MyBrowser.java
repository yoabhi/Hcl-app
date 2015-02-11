package com.yoAbhi.hclcdc;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MyBrowser extends Activity implements OnClickListener{

	Button go,goback,gofor,refresh,bexit;
	EditText edurl;
	WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mybrowser);
		
		wv=(WebView) findViewById(R.id.wvWeb);
		
		try{
		wv.loadUrl("http://www.hcllearning.com");
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		// some settings..
		wv.setWebViewClient(new Wvclient());
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setLoadWithOverviewMode(true);
		wv.getSettings().setUseWideViewPort(true);
		
		
		edurl=(EditText)findViewById(R.id.edurl);
		
		go=(Button)findViewById(R.id.go);
		goback=(Button)findViewById(R.id.back);
		gofor=(Button)findViewById(R.id.forward);
		refresh=(Button)findViewById(R.id.refresh);
		bexit=(Button)findViewById(R.id.bexit);
		
		go.setOnClickListener(this);
		goback.setOnClickListener(this);
		gofor.setOnClickListener(this);
		refresh.setOnClickListener(this);
		bexit.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
	
		switch(v.getId()){
		case R.id.go:
			String website=edurl.getText().toString();
			wv.loadUrl(website);
			
			// Hiding... KeyBoard after Go input
			InputMethodManager im=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			im.hideSoftInputFromInputMethod(edurl.getWindowToken(),0);
			
			
			break;
		case R.id.back:
			if(wv.canGoBack())
				wv.goBack();
			break;	
		case R.id.forward:
			if(wv.canGoForward())
				wv.goForward();
			break;
		case R.id.refresh:
				wv.reload();
			break;
		case R.id.bexit:
			finish();
			break;
		
		}
			
		
	}

}
