package com.example.bottomnavview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val wvWeb: WebView by lazy { findViewById(R.id.wvWeb) }
    private val bNV: BottomNavigationView by lazy { findViewById(R.id.BNV) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       webViewStart(GOOGLE_URL)

        bNV.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.google -> {
                    webViewStart(GOOGLE_URL)
                }
                R.id.youTube -> {
                    webViewStart(YouTube_URL)
                }
                R.id.stackOverFlow -> {
                    webViewStart(StackOverFlow_URL)
                }
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun webViewStart(url: String) {
        wvWeb.webViewClient = WebViewClient()

        wvWeb.apply {
            loadUrl(url)
            settings.javaScriptEnabled = true
            settings.loadWithOverviewMode = true
        }
    }

    override fun onBackPressed() {
        if (wvWeb.canGoBack()) wvWeb.goBack() else super.onBackPressed()
    }

}