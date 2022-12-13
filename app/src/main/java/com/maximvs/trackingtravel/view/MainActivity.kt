package com.maximvs.trackingtravel.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maximvs.trackingtravel.DescriptionFragment
import com.maximvs.trackingtravel.R
import com.maximvs.trackingtravel.data.entity.Route
import com.maximvs.trackingtravel.databinding.ActivityMainBinding
import com.maximvs.trackingtravel.view.fragments.DetailsFragment
import com.maximvs.trackingtravel.view.fragments.RequestFragment
import com.maximvs.trackingtravel.view.fragments.RouteFragment
import com.maximvs.trackingtravel.view.fragments.StartFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
            .commit()
    }

    fun startRequestFragment() {
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

    fun launchDetailsFragment(route: Route) {
        val bundle = Bundle()
        bundle.putParcelable("route", route)
        val fragment = DetailsFragment()
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun startDescriptionFragment(description: String) {
        val bundle = Bundle()
        bundle.putString("input", description)
        val frag2 = DescriptionFragment()
        frag2.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, frag2)
            .addToBackStack(null)
            .commit()
    }

    fun removeDetailsFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, RouteFragment())
            .addToBackStack(null)
            .commit()
    }
}



