package com.example.rideng.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rideng.R
import com.example.rideng.databinding.AddVehicleFragmentBinding

class AddVehicleFragment : Fragment(R.layout.add_vehicle_fragment) {

    private lateinit var viewModel: AddVehicleViewModel
    private lateinit var binding: AddVehicleFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = AddVehicleFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(AddVehicleViewModel::class.java)
    }

    private fun addVehicle(){

    }
}