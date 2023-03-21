package com.example.myapplication.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.common.extensions.TIME_FORMAT
import com.example.myapplication.common.extensions.dateFormatPreview
import com.example.myapplication.common.flow.launchWhenViewCreated
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.databinding.FragmentWeatherBinding
import com.example.myapplication.weather.model.WeatherPreviewData
import com.example.myapplication.weather.viewmodel.WeatherViewModel


class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WeatherViewModel by viewModels { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentWeatherBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservables()
        viewModel.loadWeatherPreview()
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            viewModel.weatherPreview.observe(viewLifecycleOwner, ::onDataLoadedPreview)
        }
    }

    private fun onDataLoadedPreview(weatherPreviewData: List<WeatherPreviewData>?) {
        binding.apply {
            if (weatherPreviewData != null) {
                val dtTimes = weatherPreviewData.first().dt.times(TIME_FORMAT)
                date.text = dtTimes.dateFormatPreview()
                temperature.text = resources.getString(
                    R.string.temp,
                    weatherPreviewData.first().temp.toInt().toString()
                )
                descriptionWeather.text = weatherPreviewData.first().description
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}