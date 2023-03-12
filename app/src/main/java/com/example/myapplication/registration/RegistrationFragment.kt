package com.example.myapplication.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.common.flow.launchWhenViewCreated
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.databinding.FragmentRegistrationBinding
import com.example.myapplication.registration.viewmodel.RegistrationViewModel

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegistrationViewModel by viewModels { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentRegistrationBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

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

    private fun setupListeners() {
        binding.btnCreateUser.setOnClickListener {
            if (binding.editNameRegistration.text.toString().isNotBlank())
                viewModel.createUser(
                    binding.editNameRegistration.text.toString()
                )
        }

    }
}