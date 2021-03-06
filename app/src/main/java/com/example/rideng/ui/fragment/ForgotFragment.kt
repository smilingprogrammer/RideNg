package com.example.rideng.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rideng.viewmodel.ForgotViewModel
import com.example.rideng.R

class ForgotFragment : Fragment() {

    companion object {
        fun newInstance() = ForgotFragment()
    }

    private lateinit var viewModel: ForgotViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.forgot_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ForgotViewModel::class.java)
        // TODO: Use the ViewModel
    }

}