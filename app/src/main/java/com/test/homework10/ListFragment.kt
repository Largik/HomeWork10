package com.test.homework10

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.homework10.Common.Common
import com.test.homework10.Interface.RetrofitServices
import com.test.homework10.Models.Fish
import com.test.homework10.databinding.FragmentListItemsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment: Fragment() {
    private lateinit var binding: FragmentListItemsBinding
    lateinit var fishService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: FishAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fishService = Common.retrofitService
        recycler = view.findViewById(R.id.items_list)
        recycler.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(requireContext())
        recycler.layoutManager = layoutManager

        getFishes()
    }

    private fun getFishes(){
            fishService.getMovieList().enqueue(object : Callback<MutableList<Fish>> {
                override fun onFailure(call: Call<MutableList<Fish>>, t: Throwable) {

                }

                override fun onResponse(call: Call<MutableList<Fish>>, response: Response<MutableList<Fish>>) {
                    adapter = FishAdapter(response.body() as MutableList<Fish>)
                    recycler.adapter = adapter
                }
            })

    }
}