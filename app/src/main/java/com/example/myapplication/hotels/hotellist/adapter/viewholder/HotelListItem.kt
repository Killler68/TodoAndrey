package com.example.myapplication.hotels.hotellist.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.hotels.hotellist.model.HotelsAndDetailed
import com.example.myapplication.R
import com.example.myapplication.common.extensions.glide
import com.example.myapplication.common.string.DEFAULT_SUM
import com.example.myapplication.common.string.HOTELS_URL_IMAGE
import com.example.myapplication.common.string.INDEX_STEP
import com.example.myapplication.common.string.SPLIT
import com.example.myapplication.databinding.RecyclerItemHotelListBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class HotelListItem(
    private val hotelsAndDetailed: HotelsAndDetailed,
    private val onClick: (Int) -> Unit
) : AbstractBindingItem<RecyclerItemHotelListBinding>() {

    override var identifier: Long = hotelsAndDetailed.hashCode().toLong()

    override fun bindView(binding: RecyclerItemHotelListBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        with(binding) {
            hotelName.text = hotelsAndDetailed.name
            address.text = hotelsAndDetailed.address
            rating.rating = hotelsAndDetailed.stars.toFloat()

            backgroundItemHotelList.setOnClickListener {
                onClick(hotelsAndDetailed.id)
            }
            container.setOnClickListener {
                onClick(hotelsAndDetailed.id)
            }
        }

        val suitesAvailability = hotelsAndDetailed.suitesAvailability
        val numbersWithoutColons = suitesAvailability.split(SPLIT)
        var sumSuites = DEFAULT_SUM
        for (number in numbersWithoutColons)
            if (number.isNotEmpty()) sumSuites += INDEX_STEP

        binding.suitesAvailability.text = sumSuites.toString()
        glide(
            binding.imageHotels,
            binding.root.context,
            HOTELS_URL_IMAGE + hotelsAndDetailed.image,
        )
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemHotelListBinding = RecyclerItemHotelListBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_item_hotel_list
}