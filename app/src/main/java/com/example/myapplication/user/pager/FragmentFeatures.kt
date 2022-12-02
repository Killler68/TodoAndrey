package com.example.myapplication.user.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.databinding.FragmentFeaturesBinding
import com.example.myapplication.user.pager.model.FeaturesData
import com.example.myapplication.user.viemodel.UserViewModel

const val FEATURES_ID_KEY = "FEATURES_ID_KEY"

class FragmentFeatures : Fragment() {

    private var _binding: FragmentFeaturesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserViewModel by viewModels { getViewModelFactory() }

    private val featuresIdKey by lazy {
        arguments?.getInt(FEATURES_ID_KEY)!!
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
        viewModel.loadFeature(featuresIdKey)
    }

    private fun setupObservables() {
        viewModel.feature.observe(viewLifecycleOwner, ::onDataLoaded)
    }

    private fun onDataLoaded(featuresData: FeaturesData) {
        binding.textTitleFeature.text = featuresData.title
        binding.textDescriptionFeature.text = featuresData.description

        Glide
            .with(requireView())
            .load(featuresData.image)
            .into(binding.imageFeature)
    }

    companion object {
        fun create(id: Int): FragmentFeatures {
            val fragment = FragmentFeatures()
            fragment.arguments = bundleOf(FEATURES_ID_KEY to id)
            return fragment
        }
    }
}