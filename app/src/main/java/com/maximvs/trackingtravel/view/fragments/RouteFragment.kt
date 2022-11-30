package com.maximvs.trackingtravel.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.maximvs.trackingtravel.view.TopSpacingItemDecoration
import com.maximvs.trackingtravel.databinding.FragmentRouteBinding
import com.maximvs.trackingtravel.domain.Route
import com.maximvs.trackingtravel.view.MainActivity
import com.maximvs.trackingtravel.view.RouteListRecyclerAdapter
import com.maximvs.trackingtravel.viewmodel.RouteFragmentViewModel
import kotlinx.android.synthetic.main.fragment_route.*
import androidx.appcompat.widget.SearchView
import java.util.*


class RouteFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(RouteFragmentViewModel::class.java)
    }
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
        //Кладем нашу БД в RV
        viewModel.routesListLiveData.observe(viewLifecycleOwner, Observer<List<Route>> {
            routesDataBase = it
        })

    }


    private fun initSearchView() {
        binding.search.setOnClickListener {
            search.isIconified = false
        }
        //Подключаем слушателя изменений введенного текста в поиска
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String): Boolean {
                //Если ввод пуст то вставляем в адаптер всю БД
                if (newText.isEmpty()) {
                    routesAdapter.addItems(routesDataBase)
                    return true
                }
                //Фильтруем список на поискк подходящих сочетаний
                val result = routesDataBase.filter {
                    //Чтобы все работало правильно, нужно и запроси и имя фильма приводить к нижнему регистру
                    it.title.lowercase(Locale.getDefault())
                        .contains(newText.lowercase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                routesAdapter.addItems(result)
                return true
            }
        })
    }


    private fun initRecyckler() {
        recycler_view.apply {
            routesAdapter =
                RouteListRecyclerAdapter(object : RouteListRecyclerAdapter.OnItemClickListener {
                    override fun click(route: Route) {
                        (requireActivity() as MainActivity).launchDetailsFragment(route)
                    }
                })
            //Присваиваем адаптер
            adapter = routesAdapter
            addItemDecoration(TopSpacingItemDecoration(5))  //Применяю декоратор для отступов
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())

        }
    }

}
