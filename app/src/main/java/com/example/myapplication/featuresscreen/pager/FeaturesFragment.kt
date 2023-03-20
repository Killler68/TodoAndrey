package com.example.myapplication.featuresscreen.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.myapplication.common.flow.launchWhenViewCreated
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.string.FEATURES_ID_KEY
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.databinding.FragmentFeaturesBinding
import com.example.myapplication.featuresscreen.pager.model.FeaturesData
import com.example.myapplication.featuresscreen.pager.viewmodel.FeaturesViewModel


class FeaturesFragment : Fragment() {

    private var _binding: FragmentFeaturesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FeaturesViewModel by viewModels { getViewModelFactory() }

    private val userId by lazy {
        requireArguments().getInt(USER_ID_KEY)
    }

    private val featuresIdKey by lazy {
        requireArguments().getInt(FEATURES_ID_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentFeaturesBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            viewModel.feature.observe(::onDataLoaded)
        }
        viewModel.loadFeature(userId, featuresIdKey)
    }

    private fun onDataLoaded(featuresData: FeaturesData) {
        binding.title.text = featuresData.title
        binding.description.text = featuresData.description

        Glide
            .with(requireView())
            .load(featuresData.image)
            .into(binding.imageFeature)
    }

    private fun setupListeners() {
        binding.imageFeature.setOnClickListener {
            viewModel.toFeature(userId, featuresIdKey)
        }
    }

    companion object {
        fun create(id: Int): FeaturesFragment {
            val fragment = FeaturesFragment()
            fragment.arguments = bundleOf(FEATURES_ID_KEY to id)
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}