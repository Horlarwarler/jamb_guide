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

import com.offline.jambguide.databinding.FragmentCutOffMarkBinding;


public class cutOffMark extends Fragment {
    public String urllink = "https://youwin.org.ng/jamb-cut-off-mark-for-all-schools-universities-polytechnics/";




    FragmentCutOffMarkBinding FragmentCutOffMarkBinding;
    public  WebView myWebview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cut_off_mark, container, false);
        myWebview = (WebView) v.findViewById(R.id.cutoffmark_page);
        // FRAGMENT IS POINTING TO A NULL POINTER
        //myWebview = FragmentCutOffMarkBinding.cutoffmarkPage;
        myWebview.loadUrl(urllink);

        // Enable Javascript
        WebSettings webSettings =myWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // Open Link In browser
        myWebview.setWebViewClient(new WebViewClient());

        return v;
    }

    public void onBackPressed() {
        if(myWebview.canGoBack()) {
            myWebview.goBack();
        } else {
            super.requireActivity().onBackPressed();
        }
    }
}