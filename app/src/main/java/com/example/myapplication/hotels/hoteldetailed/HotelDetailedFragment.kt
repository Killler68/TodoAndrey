package com.example.myapplication.hotels.hoteldetailed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.common.state.HotelsStateScreen
import com.example.myapplication.R
import com.example.myapplication.common.extensions.glide
import com.example.myapplication.common.flow.launchWhenViewCreated
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.string.DETAILED_KEY
import com.example.myapplication.common.string.HOTELS_URL_IMAGE
import com.example.myapplication.databinding.FragmentHotelDetailedBinding
import com.example.myapplication.hotels.hoteldetailed.model.HotelDetailed
import com.example.myapplication.hotels.hoteldetailed.viewmodel.HotelDetailedViewModel


class HotelDetailedFragment : Fragment() {

    private var _binding: FragmentHotelDetailedBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HotelDetailedViewModel by viewModels { getViewModelFactory() }

    private val detailedId by lazy {
        requireArguments().getInt(DETAILED_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHotelDetailedBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            viewModel.hotelDetailed.observe(::onDataLoadedHotelDetailed)
            viewModel.stateScreen.observe(::onDataLoadedState)
        }
        viewModel.loadHotelDetailed(detailedId, true)
    }

    private fun setupListeners() {
        binding.back.setOnClickListener {
            viewModel.toBack()
        }
        binding.includedError.btnErrorRefresh.setOnClickListener {
            viewModel.loadHotelDetailed(detailedId, true)
        }
    }

    private fun onDataLoadedHotelDetailed(hotelDetailed: HotelDetailed) {
        binding.apply {

            nameHotel.text = hotelDetailed.name
            address.text = hotelDetailed.address
            rating.rating = hotelDetailed.stars.toFloat()
            distance.text = requireContext().resources.getString(
                R.string.meter, hotelDetailed.distance.toInt().toString()
            )
            suitesAvailability.text = hotelDetailed.suitesAvailability
            glide(
                binding.imageHotelDetailed,
                requireContext(),
                HOTELS_URL_IMAGE + hotelDetailed.image,
            )
        }
    }

    private fun onDataLoadedState(hotelsStateScreen: HotelsStateScreen) {
        when (hotelsStateScreen) {
            is HotelsStateScreen.LoadingData -> onScreenLoading()
            is HotelsStateScreen.LoadedData -> onScreenLoaded()
            is HotelsStateScreen.ErrorData -> onScreenError()
        }
    }

    private fun onScreenLoading() {
        binding.group.isVisible = false
        binding.includedError.groupError.isVisible = false
        binding.includedError.progressBar.isVisible = true
        binding.includedError.root.isVisible = true
    }

    private fun onScreenLoaded() {
        binding.group.isVisible = true
        binding.includedError.groupError.isVisible = false
        binding.includedError.progressBar.isVisible = false
        binding.includedError.root.isVisible = false
    }

    private fun onScreenError() {
        binding.group.isVisible = false
        binding.includedError.progressBar.isVisible = false
        binding.includedError.groupError.isVisible = true
        binding.includedError.root.isVisible = true
    }

    companion object {
        fun newInstance(id: Int): HotelDetailedFragment {
            val fragment = HotelDetailedFragment()
            fragment.arguments = bundleOf(DETAILED_KEY to id)
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}