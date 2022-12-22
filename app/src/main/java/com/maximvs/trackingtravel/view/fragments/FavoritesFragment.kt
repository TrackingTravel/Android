package com.maximvs.trackingtravel.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.maximvs.trackingtravel.data.entity.Route
import com.maximvs.trackingtravel.databinding.FragmentFavoritesBinding
import com.maximvs.trackingtravel.view.MainActivity
import com.maximvs.trackingtravel.view.TopSpacingItemDecoration
import com.maximvs.trackingtravel.view.adapters.RouteListRecyclerAdapter

class FavoritesFragment : Fragment() {
    private lateinit var routesAdapter: RouteListRecyclerAdapter
    private lateinit var binding: FragmentFavoritesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favoritesList: List<Route> = emptyList()


        binding.favoritesRecycler.apply {
            routesAdapter = RouteListRecyclerAdapter(object : RouteListRecyclerAdapter.OnItemClickListener {
                override fun click(route: Route) {
                    (requireActivity() as MainActivity).launchDetailsFragment(route)
                }
            })
            adapter = routesAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(5)
            addItemDecoration(decorator)
        }
        routesAdapter.addItems(favoritesList)
    }
}
