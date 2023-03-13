package com.example.myapplication.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.databinding.FragmentWelcomeBinding
import com.example.myapplication.welcome.viewmodel.WelcomeViewModel


class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WelcomeViewModel by viewModels { getViewModelFactory() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentWelcomeBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnStart.setOnClickListener {
            viewModel.navigateToRegistration()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}