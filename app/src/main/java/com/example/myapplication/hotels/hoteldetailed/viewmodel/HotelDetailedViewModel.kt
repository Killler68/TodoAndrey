package com.example.myapplication.hotels.hoteldetailed.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.flow.createSharedFlow
import com.example.myapplication.common.state.HotelsStateScreen
import com.example.myapplication.hotels.hoteldetailed.model.HotelDetailed
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

private val emptyHotelDetailed = HotelDetailed(0, "", "", 0.0, 0.0, "","")

class HotelDetailedViewModel(
    private val getHotelDetailed: HotelDetailedUseCase,
    private val backNavigator: BackNavigatorUseCase
) : ViewModel() {

    private val _hotelDetailed: MutableStateFlow<HotelDetailed> =
        MutableStateFlow(emptyHotelDetailed)
    val hotelDetailed: StateFlow<HotelDetailed> get() = _hotelDetailed.asStateFlow()

    private var _stateScreen: MutableSharedFlow<HotelsStateScreen> = createSharedFlow()
    val stateScreen: SharedFlow<HotelsStateScreen> get() = _stateScreen.asSharedFlow()

    fun loadHotelDetailed(id: Int, showProgress: Boolean) {
        viewModelScope.launch {
            try {
                if (showProgress) _stateScreen.tryEmit(HotelsStateScreen.LoadingData)
                _hotelDetailed.tryEmit(getHotelDetailed(id))
                _stateScreen.tryEmit(HotelsStateScreen.LoadedData)

            } catch (e: Exception) {
                _stateScreen.tryEmit(HotelsStateScreen.ErrorData)
            }
        }
    }

    fun toBack() = backNavigator()
}