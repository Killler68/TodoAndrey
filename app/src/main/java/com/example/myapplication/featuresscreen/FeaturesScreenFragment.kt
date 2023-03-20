package com.example.myapplication.featuresscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.common.flow.launchWhenViewStarted
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.databinding.FragmentFeaturesScreenBinding
import com.example.myapplication.databinding.HeaderDrawerBinding
import com.example.myapplication.featuresscreen.pager.adapter.FeaturesAdapter
import com.example.myapplication.featuresscreen.pager.model.FeaturesData
import com.example.myapplication.featuresscreen.viewmodel.FeaturesScreenViewModel


class FeaturesScreenFragment : Fragment() {

    private var _binding: FragmentFeaturesScreenBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FeaturesScreenViewModel by viewModels { getViewModelFactory() }

    private val userId by lazy {
        requireArguments().getInt(USER_ID_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentFeaturesScreenBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
        onBackPressedFinishActivity()
        viewModel.getUser(userId)
        viewModel.loadFeatures(userId)
    }

    private fun setupObservables() {
        launchWhenViewStarted {
            viewModel.user.observe(::onDataLoadedUser)
            viewModel.user.observe(::setupDrawer)
            viewModel.features.observe(::setOnBoardingFeaturesItems)
        }
    }

    private fun onDataLoadedUser(user: User) {
        binding.nameUser.text = user.name
    }

    private fun setOnBoardingFeaturesItems(featuresData: List<FeaturesData>) {
        binding.pagerFeatures.adapter = FeaturesAdapter(featuresData.map { it.id }, this)
    }

    private fun setupListeners() {
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.settings_drawer -> viewModel.navigateToSettings(userId)
            }
            true
        }
    }


    private fun setupDrawer(user: User) {
        val header = binding.navView.getHeaderView(0)
        val bindDrawer = HeaderDrawerBinding.bind(header)
        bindDrawer.nicknameHeader.text = user.name

        bindDrawer.imageHeader.setOnClickListener {
            viewModel.navigateToProfile(userId)
        }
        binding.menu.setOnClickListener {
            binding.featuresScreenDrawer.openDrawer(GravityCompat.START)
        }
    }


    private fun onBackPressedFinishActivity() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finishAffinity()
                }
            })
    }

    companion object {
        fun newInstance(user: User): FeaturesScreenFragment {
            val fragment = FeaturesScreenFragment()
            fragment.arguments = bundleOf(USER_ID_KEY to user.id)
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}