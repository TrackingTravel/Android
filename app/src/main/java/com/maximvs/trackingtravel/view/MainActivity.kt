package com.maximvs.trackingtravel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.maximvs.trackingtravel.*
import com.maximvs.trackingtravel.databinding.ActivityMainBinding
import com.maximvs.trackingtravel.domain.Route
import com.maximvs.trackingtravel.view.fragments.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Инициализируем объект
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Передаем его в метод
        setContentView(binding.root)

        //initNavigation()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, StartFragment())
            .addToBackStack(null)
            .commit()
    }

   /* fun startRequestFragment (){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, RequestFragment())
            .addToBackStack(null)
            .commit()
    }

    */

    fun startRouteFragment() {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, RouteFragment())
            .addToBackStack(null)
            .commit()
    }

    fun launchDetailsFragment(route: Route) {
        val bundle = Bundle()
        bundle.putParcelable("route", route)
        val fragment = DetailsFragment()
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun checkFragmentExistence(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment, tag)
            .addToBackStack(null)
            .commit()
    }
}

