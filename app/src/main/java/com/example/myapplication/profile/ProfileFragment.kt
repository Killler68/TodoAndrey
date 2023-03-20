package com.example.myapplication.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.common.flow.launchWhenViewCreated
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.databinding.FragmentProfileBinding
import com.example.myapplication.profile.viewmodel.ProfileViewModel


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProfileViewModel by viewModels { getViewModelFactory() }

    private val userId by lazy {
        requireArguments().getInt(USER_ID_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentProfileBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
        viewModel.getUser(userId)
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            viewModel.user.observe(::onDataLoadedUser)
        }
    }

    private fun setupListeners() {
        binding.back.setOnClickListener {
            viewModel.back()
        }
        binding.menu.setOnClickListener {
            showPopup(binding.menu)
        }
    }

    private fun onDataLoadedUser(user: User) {
        binding.nickname.text = user.name
    }

    private fun showPopup(view: View) {
        val popup = PopupMenu(requireContext(), view)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_profile, popup.menu)
        popup.show()
        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.refactor -> {}
                R.id.exit -> {
                    viewModel.exit()
                }
            }
            true
        }
    }


    companion object {
        fun newInstance(userId: Int): ProfileFragment {
            val fragment = ProfileFragment()
            fragment.arguments = bundleOf(USER_ID_KEY to userId)
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}