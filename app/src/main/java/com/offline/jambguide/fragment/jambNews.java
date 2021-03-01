package com.offline.jambguide.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.offline.jambguide.R;


public class jambNews extends Fragment {
    public String jambnews = "https://www.jamb.gov.ng/news";
    public WebView myWebview;
    public String whatsapp = "http://bit.ly/3e14QuJ";
    public String email = "http://bit.ly/jambemail";
    String buttonClicked;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_jamb_news, container, false);

        myWebview = (WebView) v.findViewById(R.id.jambnews_page);


        buttonClicked = getArguments().getString("type");


        switch (buttonClicked) {
            case "phone":
                myWebview.loadUrl(whatsapp);
                break;
            case "email":
                myWebview.loadUrl(email);
                break;
            default:
                myWebview.loadUrl(jambnews);
                // Force links and redirects to open in the WebView instead of in a browser
                myWebview.setWebViewClient(new WebViewClient());

        }


        //myWebview.loadUrl(jambnews);

        // Enable Javascript
        WebSettings webSettings = myWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);


        return v;
    }


    public void onBackPressed() {
        if (myWebview.canGoBack()) {
            myWebview.goBack();
        } else {
            super.requireActivity().onBackPressed();
        }
    }
}