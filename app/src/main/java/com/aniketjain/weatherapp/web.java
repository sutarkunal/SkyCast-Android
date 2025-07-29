package com.aniketjain.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web extends AppCompatActivity {


    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        wv1=(WebView)findViewById(R.id.webView);
        wv1.setWebViewClient(new WebViewClient());



        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        Intent intent = getIntent();
        String lat = intent.getStringExtra("latitude");
        String lon = intent.getStringExtra("longitude");
        String url = "https://openweathermap.org/weathermap?basemap=map&cities=true&layer=temperature&lat="+lat+"&lon="+lon+"&zoom=100";
        wv1.loadUrl(url);
            };



    private class mybrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}