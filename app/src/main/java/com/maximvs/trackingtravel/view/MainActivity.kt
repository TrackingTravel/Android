package com.maximvs.trackingtravel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maximvs.trackingtravel.R
import com.maximvs.trackingtravel.databinding.ActivityMainBinding
import com.maximvs.trackingtravel.view.fragments.DetailsFragment
import com.maximvs.trackingtravel.view.fragments.RequestFragment
import com.maximvs.trackingtravel.view.fragments.RouteFragment
import com.maximvs.trackingtravel.view.fragments.StartFragment


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

    fun startDetailsFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, DetailsFragment())
            .addToBackStack(null)
            .commit()
    }}

