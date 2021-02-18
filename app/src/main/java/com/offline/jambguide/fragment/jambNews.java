package com.offline.jambguide.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.offline.jambguide.R;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.offline.jambguide.databinding.FragmentJambNewsBinding;


public class jambNews extends Fragment {
    public  String jambnews = "https://www.jamb.gov.ng/news";

    FragmentJambNewsBinding FragmentJambNews;
    public  WebView myWebview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // FragmentJambNews = FragmentJambNewsBinding.inflate(inflater,container,false);
        // return FragmentJambNews.getRoot();
        View v = inflater.inflate(R.layout.fragment_jamb_news, container, false);

        myWebview = (WebView) v.findViewById(R.id.jambnews_page);
      // FRAGMENT IS POINTING TO A NULL POINTER
       // myWebview = FragmentJambNewsBinding.jambnewsPage;
        myWebview.loadUrl(jambnews);

        // Enable Javascript
        WebSettings webSettings =myWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        myWebview.setWebViewClient(new WebViewClient());

        return v;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        myWebview = FragmentJambNews.jambnewsPage;
//        WebSettings webSettings = myWebview.getSettings();
//        myWebview.setWebViewClient(new WebViewClient());
//    }

    public void onBackPressed() {
        if(myWebview.canGoBack()) {
            myWebview.goBack();
        } else {
            super.requireActivity().onBackPressed();
        }
    }
}