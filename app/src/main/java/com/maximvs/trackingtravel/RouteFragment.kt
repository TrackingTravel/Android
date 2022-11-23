package com.maximvs.trackingtravel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maximvs.trackingtravel.databinding.FragmentRouteBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Suppress("UNREACHABLE_CODE")
class RouteFragment : Fragment(), RouteAdapter.Listener {
    private lateinit var binding: FragmentRouteBinding
    private lateinit var routeAdapter: RouteAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRouteBinding.inflate(inflater, container, false)

        return binding.root

        routeAdapter = RouteAdapter(this)

        // Функция with позволяет выполнить несколько операций над одним объектом, не повторяя его имени.
        with(binding.recyclerView) {
            adapter = routeAdapter
            // itemAnimator = MyItemAnimator(applicationContext)
            addItemDecoration(TopSpacingItemDecoration(5))  //Применяю декоратор для отступов
        }

        // ретрофит п.1 Создаю базу для моего запроса (здесь - мин.набор: домен сервера и конвертер,
        // чтобы он под капотом парсил JSON-ответ.
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.TEST_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // ретрофит п.3 Сервис для запросов формируется вот так:
        val service = retrofit.create(RetrofitInterface::class.java)

        // ретрофит п.4 При помощи базового экземпляра Retrofit создаю из интерфейса (в котором я
        // перечислил все методы) объект, который будет отправлять запросы и получать ответы:
        service.getUsers().enqueue(object : Callback<UsersData> {
            override fun onResponse(call: Call<UsersData>, response: Response<UsersData>) {
                println("Ответ ${response.body()}")
                val result = response.body() as? UsersData
                result?.data?.let { routeAdapter?.addData(result.data) } // С ?.let все довольно просто.
                // Если результат body() не null то выполнится код в фигурных скобках. It уже будет
                // тем, что body вернул, то есть в нашем случае это UserData
            }

            override fun onFailure(call: Call<UsersData>, t: Throwable) {
                t.printStackTrace()
            }
        })


    }

    override fun onClick(way: Data) {
        TODO("Not yet implemented")
    }
}