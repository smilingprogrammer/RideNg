package com.example.rideng.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rideng.R
import com.example.rideng.viewmodel.SignUpViewModel
import com.example.rideng.databinding.SignUpFragmentBinding
import com.example.rideng.model.registerUser.NewUser

class SignUpFragment : Fragment() {

    private lateinit var binding: SignUpFragmentBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignUpFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }

    private fun newUser() {
        val user = NewUser(binding.userName.toString(),
            binding.name.toString(),
            binding.email.toString(),
            binding.password.toString())
    }

}