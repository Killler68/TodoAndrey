package com.example.myapplication.hotels.hotellist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.common.resources.ResourceManagerImpl
import com.example.myapplication.R
import com.example.myapplication.common.flow.launchWhenViewCreated
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.state.HotelsStateScreen
import com.example.myapplication.common.string.DEFAULT_SUM
import com.example.myapplication.common.string.INDEX_STEP
import com.example.myapplication.common.string.SPLIT
import com.example.myapplication.databinding.FragmentHotelListBinding
import com.example.myapplication.hotels.hotellist.adapter.LastItemDecorator
import com.example.myapplication.hotels.hotellist.adapter.viewholder.HotelListItem
import com.example.myapplication.hotels.hotellist.model.HotelsAndDetailed
import com.example.myapplication.hotels.hotellist.viewmodel.HotelListViewModel
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

private const val RECYCLER_LAST_ITEM_MARGIN = 40

class HotelListFragment : Fragment() {

    private var _binding: FragmentHotelListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HotelListViewModel by viewModels { getViewModelFactory() }

    private val hotelListItemAdapter = ItemAdapter<HotelListItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(hotelListItemAdapter))

    private val resManager by lazy { ResourceManagerImpl(requireContext()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHotelListBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
        setupDecoration()
        setupFastAdapter()
        onBackPressedFinishActivity()
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            viewModel.hotelsAndDetailed.observe(::onDataLoadedHotelList)
            viewModel.stateScreen.observe(::onDataLoadedState)
        }
        viewModel.loadHotelsAndDetailed(true)
    }

    private fun setupListeners() {
        binding.includedError.btnErrorRefresh.setOnClickListener {
            viewModel.loadHotelsAndDetailed(true)
        }
    }

    private fun onDataLoadedHotelList(hotelsAndDetailed: List<HotelsAndDetailed>) {

        onDataLoadedHotels(hotelsAndDetailed)

        binding.spinnerFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (parent.getItemAtPosition(position).toString()) {
                    resManager.getString(R.string.spinner_default) -> onDataLoadedHotels(
                        hotelsAndDetailed
                    )
                    resManager.getString(R.string.spinner_distance) -> sortedByDistance(
                        hotelsAndDetailed
                    )
                    resManager.getString(R.string.spinner_availability) -> sortedByAvailability(
                        hotelsAndDetailed
                    )
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun onDataLoadedHotels(hotelsAndDetailed: List<HotelsAndDetailed>) {
        FastAdapterDiffUtil[hotelListItemAdapter] = hotelsAndDetailed.map {
            HotelListItem(
                it,
                viewModel::navigateToHotelDetailed
            )
        }
    }

    private fun sortedByAvailability(hotelsAndDetailed: List<HotelsAndDetailed>) {
        val sortedLists = hotelsAndDetailed.sortedByDescending {
            val suitesAvailability = it.suitesAvailability
            val numbersWithoutColons = suitesAvailability.split(SPLIT)
            var sumSuites = DEFAULT_SUM
            for (number in numbersWithoutColons)
                if (number.isNotEmpty()) sumSuites += INDEX_STEP
            sumSuites
        }
        FastAdapterDiffUtil[hotelListItemAdapter] = sortedLists.map {
            HotelListItem(
                it,
                viewModel::navigateToHotelDetailed
            )
        }
    }

    private fun sortedByDistance(hotelsAndDetailed: List<HotelsAndDetailed>) {
        val sortedByDistance = hotelsAndDetailed.sortedBy { it.distance }
        FastAdapterDiffUtil[hotelListItemAdapter] = sortedByDistance.map {
            HotelListItem(
                it,
                viewModel::navigateToHotelDetailed
            )
        }
    }

    private fun setupDecoration() {
        val decorator = LastItemDecorator(RECYCLER_LAST_ITEM_MARGIN)
        binding.recyclerHotelList.addItemDecoration(decorator)
    }

    private fun onDataLoadedState(hotelsStateScreen: HotelsStateScreen) {
        when (hotelsStateScreen) {
            is HotelsStateScreen.LoadingData -> onScreenLoading()
            is HotelsStateScreen.LoadedData -> onScreenLoaded()
            is HotelsStateScreen.ErrorData -> onScreenError()
        }
    }

    private fun onScreenLoading() {
        binding.recyclerHotelList.isVisible = false
        binding.includedError.groupError.isVisible = false
        binding.includedError.progressBar.isVisible = true
        binding.includedError.root.isVisible = true
    }

    private fun onScreenLoaded() {
        binding.recyclerHotelList.isVisible = true
        binding.includedError.groupError.isVisible = false
        binding.includedError.progressBar.isVisible = false
        binding.includedError.root.isVisible = false
    }

    private fun onScreenError() {
        binding.recyclerHotelList.isVisible = false
        binding.includedError.progressBar.isVisible = false
        binding.includedError.groupError.isVisible = true
        binding.includedError.root.isVisible = true
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

    private fun setupFastAdapter() {
        with(binding.recyclerHotelList) {
            adapter = fastAdapter
            itemAnimator = null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}