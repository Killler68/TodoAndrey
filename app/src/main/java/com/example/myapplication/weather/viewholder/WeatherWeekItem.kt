package com.example.myapplication.weather.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.common.extensions.TIME_FORMAT
import com.example.myapplication.common.extensions.dateFormatDays
import com.example.myapplication.common.extensions.imageWeatherExtension
import com.example.myapplication.databinding.RecyclerItemWeatherWeekBinding
import com.example.myapplication.weather.model.WeatherData
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class WeatherWeekItem(
    private val weatherWeek: WeatherData
) : AbstractBindingItem<RecyclerItemWeatherWeekBinding>() {


    private val hourlyItemAdapter = ItemAdapter<WeatherHourlyItem>()
    private val hourlyFastAdapter = GenericFastAdapter.with(listOf(hourlyItemAdapter))
    override fun bindView(binding: RecyclerItemWeatherWeekBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        val dtTimes = weatherWeek.dt.times(TIME_FORMAT)
        binding.dateWeek.text = dtTimes.dateFormatDays()

        binding.temperatureMax.text =
            binding.root.resources.getString(R.string.temp, weatherWeek.temp_max.toInt().toString())

        binding.temperatureMin.text =
            binding.root.resources.getString(R.string.temp, weatherWeek.temp_min.toInt().toString())

        Glide
            .with(binding.root)
            .load(weatherWeek.icon.imageWeatherExtension())
            .into(binding.weatherWeek)

        onDataLoadedHourly()
        with(binding.recyclerWeatherHourly) {
            adapter = hourlyFastAdapter
            itemAnimator = null
        }
    }

    private fun onDataLoadedHourly() {
        FastAdapterDiffUtil[hourlyItemAdapter] = weatherWeek.listWeek.map {
            WeatherHourlyItem(it)
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemWeatherWeekBinding =
        RecyclerItemWeatherWeekBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_item_weather_week
}