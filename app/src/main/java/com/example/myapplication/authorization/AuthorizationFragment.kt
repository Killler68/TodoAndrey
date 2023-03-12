package com.example.myapplication.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.authorization.viewmodel.AuthorizationViewModel
import com.example.myapplication.common.extensions.clickableText
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {

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

        setupListeners()
    }

    private fun setupListeners() {
        authorizationAccount()
        onClick()
    }

    private fun onClick() {
        clickableText(
            "Нет учетной записи? Зарегистрироваться",
            "Зарегистрироваться",
            viewModel::navigateToNotes,
            binding.navigateRegistration
        )
    }

    private fun authorizationAccount() {
        binding.signIn.setOnClickListener {
            if (binding.editLogin.text.toString().isNotBlank() &&
                binding.editPassword.text.toString().isNotBlank()
            ) {
                viewModel.getUseByNameAndPassword(
                    binding.editLogin.text.toString(),
                    binding.editPassword.text.toString()
                )
            }
        }
    }
}