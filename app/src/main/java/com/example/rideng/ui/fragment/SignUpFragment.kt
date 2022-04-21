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
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        viewModel.newUserResponse.observe(viewLifecycleOwner, Observer { res->
            Toast.makeText(context, "User $res added to database", Toast.LENGTH_SHORT).show()
        })
        viewModel.error.observe(viewLifecycleOwner, Observer { err->
            Toast.makeText(context, err, Toast.LENGTH_SHORT).show()
        })

        binding.proceed.setOnClickListener {
            newUser()
        }
    }

    private fun newUser() {
        val user = NewUser(binding.email.toString(),
        binding.name.toString(),
        binding.password.toString(),
        binding.userName.toString())

        viewModel.registerUser(user)
    }

}