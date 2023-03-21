package com.example.myapplication.weather.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.common.extensions.TIME_FORMAT
import com.example.myapplication.common.extensions.dateFormatHours
import com.example.myapplication.databinding.RecyclerItemWeatherHourlyBinding
import com.example.myapplication.weather.model.WeatherWeek
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class WeatherHourlyItem(
    private val weatherHourly: WeatherWeek
) : AbstractBindingItem<RecyclerItemWeatherHourlyBinding>() {

    override fun bindView(binding: RecyclerItemWeatherHourlyBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        val dtTimes = weatherHourly.dt.times(TIME_FORMAT)
        binding.time.text = dtTimes.dateFormatHours()

        binding.temperature.text =
            binding.root.resources.getString(R.string.temp, weatherHourly.temp.toInt().toString())
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemWeatherHourlyBinding =
        RecyclerItemWeatherHourlyBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_item_weather_hourly
}