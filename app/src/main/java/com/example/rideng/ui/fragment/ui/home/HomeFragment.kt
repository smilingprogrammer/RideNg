package com.example.rideng.ui.fragment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rideng.databinding.FragmentHomeBinding
import com.example.rideng.network.ApiClient
import com.example.rideng.repository.SignUpRepository
import com.example.rideng.ui.adapter.HomeAdapter
import com.example.rideng.viewmodel.ViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val homeAdapter = HomeAdapter()
        binding.home.apply {
            this.adapter = homeAdapter
            layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        }

        viewModel.getVehicleLiveData.observe(viewLifecycleOwner) {
            homeAdapter.submitList(it)
        }

    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}