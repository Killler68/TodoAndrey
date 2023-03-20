package com.example.myapplication.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.databinding.FragmentSettingsBinding
import com.example.myapplication.settings.viewmodel.SettingsViewModel

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SettingsViewModel by viewModels { getViewModelFactory() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSettingsBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        binding.imageBackSettings.setOnClickListener {
            viewModel.back()
        }
    }

    companion object {
        fun newInstance(userId: Int): SettingsFragment {
            val fragment = SettingsFragment()
            fragment.arguments = bundleOf(USER_ID_KEY to userId)
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}