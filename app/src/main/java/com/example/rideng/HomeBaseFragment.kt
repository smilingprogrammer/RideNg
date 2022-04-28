package com.example.rideng

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.rideng.databinding.HomeBaseFragmentBinding
import com.google.android.material.navigation.NavigationView


class HomeFragment : Fragment() {

    private var _binding: HomeBaseFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = HomeBaseFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}