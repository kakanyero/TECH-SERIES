package com.example.codeimpact.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

import androidx.fragment.app.Fragment

import com.example.codeimpact.R


class CohortsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_cohorts,container,false)
    }
    //implementing webview in the application
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val mywebview: WebView = view.findViewById(R.id.cohortswebview)
        mywebview.webViewClient= object: WebViewClient(){
           override fun shouldOverrideUrlLoading(
                view: WebView,
                url:String
            ): Boolean {

                view.loadUrl(url)
                return true
            }
        }
        mywebview.loadUrl("https://codeimpact.co/cohorts/")
        mywebview.settings.javaScriptEnabled
        mywebview.settings.allowContentAccess=true
        mywebview.settings.useWideViewPort=true
        mywebview.settings.domStorageEnabled=true
    }

}