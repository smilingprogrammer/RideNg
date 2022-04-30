package com.example.rideng.ui.fragment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rideng.R
import com.example.rideng.databinding.FragmentHomeBinding
import com.example.rideng.model.getvehicle.Data
import com.example.rideng.ui.adapter.HomeAdapter

class HomeFragment : Fragment(), (Data) -> Unit {

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

        val homeAdapter = HomeAdapter(this)
        binding.home.apply {
            this.adapter = homeAdapter
            layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        }

        viewModel.getVehicleLiveData.observe(viewLifecycleOwner) {
            homeAdapter.submitList(it)
        }
    }

    override fun invoke(data: Data) {
        findNavController().navigate(
            R.id.action_homeFragment_to_homeDetailFragment, bundleOf("homeData" to data)
        )
    }

}