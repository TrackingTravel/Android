package com.maximvs.trackingtravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maximvs.trackingtravel.databinding.ActivityMainBinding


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

    fun startRequestFragment (){
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

    fun startDetailsFragment() {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.to_left_in,
                R.anim.to_left_out,
                R.anim.to_right_in,
                R.anim.to_right_out
            )
            .replace(R.id.fragment_container, DetailsFragment())
            .addToBackStack(null)
            .commit()
    }
}


