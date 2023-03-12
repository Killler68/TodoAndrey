package com.example.myapplication.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.common.flow.launchWhenViewStarted
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.databinding.FragmentUserBinding
import com.example.myapplication.user.pager.adapter.FeaturesAdapter
import com.example.myapplication.user.pager.model.FeaturesData
import com.example.myapplication.user.viemodel.UserViewModel


class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserViewModel by viewModels { getViewModelFactory() }

    private val userId by lazy {
        requireArguments().getInt(USER_ID_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentUserBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
        viewModel.loadFeatures()
        viewModel.getUser(userId)
    }

    private fun setupObservables() {
        launchWhenViewStarted {
            viewModel.user.observe(::onDataLoadedUser)
            viewModel.features.observe(::setOnBoardingFeaturesItems)
            viewModel.navCommand.observe(::onDataLoadedNavigate)
        }
    }

    private fun onDataLoadedUser(user: User) {
        binding.textNameUser.text = user.name
    }

    private fun onDataLoadedNavigate(navCommand: NavCommand) {
        findNavController().navigate(navCommand.action, navCommand.command)

    }

    private fun setupListeners() {
        binding.pagerItems.setOnClickListener {
            viewModel.navigateToNotes()
        }
    }

    private fun setOnBoardingFeaturesItems(featuresData: List<FeaturesData>) {
        val hotSalesOnBoardingAdapter = FeaturesAdapter(this)
        hotSalesOnBoardingAdapter.setItems(featuresData.map { it.id })
        binding.pagerItems.adapter = hotSalesOnBoardingAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}