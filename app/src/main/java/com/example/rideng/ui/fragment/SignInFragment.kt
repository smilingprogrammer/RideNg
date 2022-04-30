package com.example.rideng.ui.fragment

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rideng.R
import com.example.rideng.viewmodel.SignInViewModel
import com.example.rideng.databinding.SignInFragmentBinding
import com.example.rideng.network.ApiClient
import com.example.rideng.repository.AuthRepository
import com.example.rideng.viewmodel.ViewModelFactory

class SignInFragment : Fragment() {

    private lateinit var binding: SignInFragmentBinding
    private val viewModel: SignInViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(AuthRepository(ApiClient.retrofitService)))
            .get(SignInViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.proceed.setOnClickListener {
            if (!binding.userName.text!!.isEmpty() && !binding.password.text!!.isEmpty()){
                loginUser()
            }
        }

        viewModel.user.observe(viewLifecycleOwner, Observer {
            if (it.isSuccessful){
                val intent = Intent(context, HomeActivity::class.java)
                intent.putExtra(HomeActivity.USER_DETAILS, it.isSuccessful)
                startActivity(intent)
            }
        })

        binding.createOne.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_forgotFragment)
        }
    }

    private fun loginUser(){
        binding.apply {
            val username = userName.text.toString()
            val password = password.text.toString()

            viewModel.loginUser(username, password)
        }
    }

}