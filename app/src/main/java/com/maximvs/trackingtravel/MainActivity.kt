package com.maximvs.trackingtravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.maximvs.trackingtravel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, ActivityRequest::class.java)
            startActivity(intent)
        })
    }
}