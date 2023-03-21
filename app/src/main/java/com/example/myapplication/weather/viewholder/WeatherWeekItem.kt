package com.example.myapplication.weather.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.common.extensions.dateFormatDays
import com.example.myapplication.databinding.RecyclerItemWeatherWeekBinding
import com.example.myapplication.weather.model.WeatherData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class WeatherWeekItem(
    private val weatherWeek: WeatherData
) : AbstractBindingItem<RecyclerItemWeatherWeekBinding>() {


    override fun bindView(binding: RecyclerItemWeatherWeekBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        binding.dateWeek.text = weatherWeek.dt.dateFormatDays()

        binding.temperatureMax.text =
            binding.root.resources.getString(R.string.temp, weatherWeek.temp_max.toInt().toString())

        binding.temperatureMin.text =
            binding.root.resources.getString(R.string.temp, weatherWeek.temp_min.toInt().toString())
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemWeatherWeekBinding =
        RecyclerItemWeatherWeekBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_item_weather_week
}