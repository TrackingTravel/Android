package com.maximvs.trackingtravel

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.maximvs.trackingtravel.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, StartFragment())
                .addToBackStack(null)
                .commit()
    }

    fun startRequestFragment (){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, RequestFragment())
            .addToBackStack(null)
            .commit()
    }

    fun startRouteFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, RouteFragment())
            .addToBackStack(null)
            .commit()
    }
}