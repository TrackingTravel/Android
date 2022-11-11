package com.maximvs.trackingtravel.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maximvs.trackingtravel.R
import com.maximvs.trackingtravel.view.fragments.RequestFragment
import com.maximvs.trackingtravel.databinding.ActivityMainBinding
import com.maximvs.trackingtravel.view.fragments.RouteFragment
import com.maximvs.trackingtravel.view.fragments.StartFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.to_left_in,
                R.anim.to_left_out,
                R.anim.to_right_in,
                R.anim.to_right_out
            )
            .add(R.id.fragment_container, StartFragment())
            .addToBackStack(null)
            .commit()


    }

    fun startRequestFragment() {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.to_left_in,
                R.anim.to_left_out,
                R.anim.to_right_in,
                R.anim.to_right_out
            )
            .replace(R.id.fragment_container, RequestFragment())
            .addToBackStack(null)
            .commit()
    }

    fun startRouteFragment() {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.to_left_in,
                R.anim.to_left_out,
                R.anim.to_right_in,
                R.anim.to_right_out
            )
            .replace(R.id.fragment_container, RouteFragment())
            .addToBackStack(null)
            .commit()
    }
}