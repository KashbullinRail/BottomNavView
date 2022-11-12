package com.example.bottomnavview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.bottomnavview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webViewStart(GOOGLE_URL)

        binding.BNV.selectedItemId = R.id.google
        binding.BNV.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.google -> {webViewStart(GOOGLE_URL)}
                R.id.youTube -> {webViewStart(YouTube_URL)}
                R.id.stackOverFlow -> {webViewStart(StackOverFlow_URL)}
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun webViewStart(url: String){
        binding.wvWeb.webViewClient = WebViewClient()

            binding.wvWeb.apply {
            loadUrl(url)
            settings.javaScriptEnabled = true
            settings.loadWithOverviewMode = true
        }
    }

    override fun onBackPressed() {
        if(binding.wvWeb.canGoBack()) binding.wvWeb.goBack() else super.onBackPressed()
    }

}