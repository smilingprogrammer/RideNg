package com.example.rideng.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rideng.R
import com.example.rideng.viewmodel.SignInViewModel
import com.example.rideng.databinding.SignInFragmentBinding

class SignInFragment : Fragment() {

    private lateinit var binding: SignInFragmentBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createOne.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_forgotFragment)
        }
    }

}