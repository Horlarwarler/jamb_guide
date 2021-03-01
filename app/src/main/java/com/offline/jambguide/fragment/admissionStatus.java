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


public class admissionStatus extends Fragment {

    //FragmentAdmissionStatusBinding FragmentAdmissionStatusBinding;
    public WebView myWebview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_admission_status, container, false);
        myWebview = (WebView) v.findViewById(R.id.admission_page);
        // FRAGMENT IS POINTING TO A NULL POINTER

        myWebview.loadUrl("https://www.jamb.gov.ng/Efacility");

        // Enable Javascript
        WebSettings webSettings = myWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        myWebview.setWebViewClient(new WebViewClient());

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