package com.yoAbhi.hclcdc;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Wvclient extends WebViewClient {
	
	public boolean shouldOverridrUrlLoading(WebView v,String url){
		
		v.loadUrl(url);
		return true;
		
	}

}
