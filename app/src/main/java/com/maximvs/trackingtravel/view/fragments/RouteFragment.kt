package com.maximvs.trackingtravel.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.maximvs.trackingtravel.R
import com.maximvs.trackingtravel.data.entity.Route
import com.maximvs.trackingtravel.databinding.FragmentRouteBinding
import com.maximvs.trackingtravel.view.MainActivity
import com.maximvs.trackingtravel.view.RouteListRecyclerAdapter
import com.maximvs.trackingtravel.view.TopSpacingItemDecoration
import com.maximvs.trackingtravel.viewmodel.RouteFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class RouteFragment : Fragment() {
    private val routeFragmentViewModel: RouteFragmentViewModel by viewModels()
    private lateinit var routesAdapter: RouteListRecyclerAdapter
    private lateinit var binding: FragmentRouteBinding
    private var routesDataBase = listOf<Route>()
        //Используем backing field
        set(value) {
            //Если придет такое же значение то мы выходим из метода
            if (field == value) return
            //Если пришло другое значение, то кладем его в переменную
            field = value
            //Обновляем RV адаптер
            routesAdapter.addItems(field)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRouteBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSearchView()

        initRecyckler()
        routeFragmentViewModel.routesListLiveData.observe(
            viewLifecycleOwner,
            Observer<List<Route>> {
                routesDataBase = it
            })

        initNavigation()

    }

    private fun initSearchView() {
        binding.search.setOnClickListener {
            binding.search.isIconified = false
        }
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    routesAdapter.addItems(routesDataBase)
                    return true
                }
                val result = routesDataBase.filter {
                    it.title.lowercase(Locale.getDefault())
                        .contains(newText.lowercase(Locale.getDefault()))
                }
                routesAdapter.addItems(result)
                return true
            }
        })
    }

    private fun initRecyckler() {
        binding.recyclerView.apply {
            routesAdapter =
                RouteListRecyclerAdapter(object : RouteListRecyclerAdapter.OnItemClickListener {
                    override fun click(route: Route) {
                        (requireActivity() as MainActivity).launchDetailsFragment(route)
                    }
                })
            adapter = routesAdapter
            addItemDecoration(TopSpacingItemDecoration(5))  //Применяю декоратор для отступов
            layoutManager = LinearLayoutManager(requireContext())

        }
    }

    private fun initNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.route -> {
                    val tag = "route"
                    val fragment = checkFragmentExistence(tag)
                    //В первом параметре, если фрагмент не найден и метод вернул null, то с помощью
                    //элвиса мы вызываем создание нвого фрагмента
                    changeFragment(fragment ?: RouteFragment(), tag)
                    true
                }
                R.id.settings -> {
                    val tag = "settings"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: SettingsFragment(), tag)
                    true
                }
                else -> false
            }
        }
    }

    //Ищем фрагмент по тэгу, если он есть то возвращаем его, если нет - то null
    private fun checkFragmentExistence(tag: String): Fragment? =
        childFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment, tag)
            .addToBackStack(null)
            .commit()

    }
}
