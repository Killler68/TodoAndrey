package com.example.myapplication.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.common.extensions.clickableText
import com.example.myapplication.common.fragment.getViewModelFactory
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

        createUser()
        setupListeners()
    }

    private fun setupListeners() {
        clickableText(
            "Уже есть учетная запись?\nВойти",
            "\nВойти",
            viewModel::navigateToAuthorization,
            binding.navigateAuthorization
        )
    }


    private fun createUser() {
        binding.btnCreateUser.setOnClickListener {
            if (binding.editName.text.toString().isNotBlank() &&
                binding.editPassword.text.toString().isNotBlank()
            )
                viewModel.createUser(
                    binding.editName.text.toString(),
                    binding.editPassword.text.toString()
                )
        }
    }
}