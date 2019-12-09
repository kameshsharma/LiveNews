package com.example.livenews;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        String weburl = getIntent().getStringExtra("webdata");
        WebView webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        getSupportActionBar().hide();
        webView.loadUrl(weburl);
        webSettings.setGeolocationEnabled(true);
        webSettings.setSupportMultipleWindows(true);


        webView.setWebViewClient(new WebViewClient(){

            public void onPageFinished(WebView view,String url){
                ProgressBar progressbar = (ProgressBar) findViewById(R.id.progress_bar);
                progressbar.setVisibility(View.GONE);
            }
        });


    }
}
