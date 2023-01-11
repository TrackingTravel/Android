package com.maximvs.trackingtravel.view.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maximvs.trackingtravel.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(5000) // 1

        setTheme(R.style.AppTheme) // 2

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
