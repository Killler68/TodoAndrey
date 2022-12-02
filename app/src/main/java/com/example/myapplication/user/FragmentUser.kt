package com.example.myapplication.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.databinding.FragmentUserBinding
import com.example.myapplication.user.pager.adapter.FeaturesAdapter
import com.example.myapplication.user.pager.model.FeaturesData
import com.example.myapplication.user.viemodel.UserViewModel


class FragmentUser : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserViewModel by viewModels { getViewModelFactory() }

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
    }

    private fun setupObservables() {
        viewModel.navCommand.observe(viewLifecycleOwner, ::onDataLoadedNavigate)
        viewModel.features.observe(viewLifecycleOwner, ::setOnBoardingFeaturesItems)
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