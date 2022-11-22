package com.maximvs.trackingtravel.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.maximvs.trackingtravel.databinding.FragmentRouteBinding
import com.maximvs.trackingtravel.domain.Route
import com.maximvs.trackingtravel.viewmodel.RouteFragmentViewModel


class RouteFragment : Fragment() {
        private val viewModel by lazy {
            ViewModelProvider.NewInstanceFactory().create(RouteFragmentViewModel::class.java)
        }


    private lateinit var binding: FragmentRouteBinding
    private var tracksDataBase = listOf<Route>()
        set(value) {
            if (field == value) return
            field = value
           // tracksAdapter.addItems(field)
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRouteBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //initSearchView()

        //находим наш RV
        //initRecyckler()
        //Кладем нашу БД в RV
        viewModel.tracksListLiveData.observe(viewLifecycleOwner, Observer<List<Route>> {
            tracksDataBase = it
        })

    }
}