package com.maximvs.trackingtravel.view.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.maximvs.trackingtravel.R
import com.maximvs.trackingtravel.databinding.ActivityMainBinding
import com.maximvs.trackingtravel.databinding.ActivityStartBinding
import com.maximvs.trackingtravel.view.MainActivity


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //makeFullScreen()

        val binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_start)


        binding.btnBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@StartActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        })


       /* binding.btnBtn.setOnClickListener{
            val intent = Intent(this@StartActivity, MainActivity::class.java)
            startActivity(intent)
        } */

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity:: class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, com.maximvs.trackingtravel.Constants.SPLASH_SCREEN_TIMING.toLong())
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
