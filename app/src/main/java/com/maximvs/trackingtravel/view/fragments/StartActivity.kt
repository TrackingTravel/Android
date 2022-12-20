package com.maximvs.trackingtravel.view.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.maximvs.trackingtravel.R
import com.maximvs.trackingtravel.view.MainActivity


class StartActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeFullScreen()

        setContentView(R.layout.fragment_start)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity:: class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        },
    com.maximvs.trackingtravel.Constants.SPLASH_SCREEN_TIMING.toLong())
    }

    private fun makeFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN

        )
        supportActionBar?.hide()
    }

}
