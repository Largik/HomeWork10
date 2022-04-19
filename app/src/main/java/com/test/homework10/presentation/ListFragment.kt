package com.test.homework10.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.homework10.FishAdapter
import com.test.homework10.databinding.FragmentListItemsBinding

class ListFragment: Fragment() {
    private var _binding: FragmentListItemsBinding? = null
    private val binding get() = _binding!!

    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: FishAdapter
    private lateinit var recycler: RecyclerView

    private val vm: FishViewModel by lazy {
        ViewModelProvider(
            this,
            FishViewModelFactory(requireContext())
        ).get(
            FishViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.fishList.observe(viewLifecycleOwner){
            recycler = binding.itemsList
            recycler.setHasFixedSize(true)
            adapter = FishAdapter(it, vm)
            recycler.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
            recycler.layoutManager = layoutManager
        }
    }
}