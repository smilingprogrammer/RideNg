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
import com.example.rideng.model.registerUser.NewUserResponse

class SignUpFragment : Fragment() {

    private lateinit var binding: SignUpFragmentBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpFragmentBinding.inflate(layoutInflater, container, false)
//        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        initViewModel()

        binding.proceed.setOnClickListener {
            newUser()
        }
    }

    private fun newUser() {
        val user = NewUser(binding.firstName.toString(),
        binding.lastName.toString(),
        binding.email.toString(),
        binding.password.toString(),
        binding.bvn.toString(),
        binding.phone.toString())

        viewModel.registerUser(user)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        viewModel.getNewUserObserver().observe(viewLifecycleOwner, Observer <NewUserResponse>{

            if (it == null){
                Toast.makeText(context, "Failed to create user", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Successfully created user", Toast.LENGTH_LONG).show()
            }
        })
    }

}