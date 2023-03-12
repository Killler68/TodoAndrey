package com.example.myapplication.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.authorization.viewmodel.AuthorizationViewModel
import com.example.myapplication.common.flow.launchWhenViewCreated
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.databinding.FragmentAuthorizationBinding

private const val INPUT_ERROR = "Неверные данные"

class FragmentAuthorization : Fragment() {

    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AuthorizationViewModel by viewModels { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            viewModel.navCommand.observe(::onDataLoaded)
        }
    }

    private fun onDataLoaded(navCommand: NavCommand) {
        findNavController().navigate(navCommand.action, navCommand.command)
    }

    private fun setupListeners() {}
}