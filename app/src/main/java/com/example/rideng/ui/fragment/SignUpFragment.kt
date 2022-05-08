package com.example.rideng.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rideng.R
import com.example.rideng.viewmodel.SignUpViewModel
import com.example.rideng.databinding.SignUpFragmentBinding
import com.example.rideng.model.registerUser.NewUser

class SignUpFragment : Fragment() {

    private lateinit var binding: SignUpFragmentBinding
    private val viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        viewModel.newUserResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful){
                Toast.makeText(context, "User Added to database", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Failed to create user", Toast.LENGTH_SHORT).show()
            }
        })

        binding.proceed.setOnClickListener {
            newUser()
        }
    }

    private fun newUser() {
        val user = NewUser(binding.email.text.toString(),
        binding.name.text.toString(),
        binding.password.text.toString(),
        binding.userName.text.toString())

        viewModel.registerUser(user)
    }
}