package com.example.myapplication.hotels.hotellist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.flow.createSharedFlow
import com.example.myapplication.common.state.HotelsStateScreen
import com.example.myapplication.hotels.hotellist.model.HotelsAndDetailed
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HotelListViewModel(
    private val getHotelsAndDetailed: HotelsAndDetailedUseCase,
    private val navigatorToHotelDetailed: HotelDetailedNavigatorUseCase
) : ViewModel() {

    private val _hotelsAndDetailed: MutableStateFlow<List<HotelsAndDetailed>> =
        MutableStateFlow(emptyList())
    val hotelsAndDetailed: StateFlow<List<HotelsAndDetailed>> get() = _hotelsAndDetailed.asStateFlow()

    private var _stateScreen: MutableSharedFlow<HotelsStateScreen> = createSharedFlow()
    val stateScreen: SharedFlow<HotelsStateScreen> get() = _stateScreen.asSharedFlow()

    fun loadHotelsAndDetailed(showProgress: Boolean) {
        viewModelScope.launch {
            try {
                if (showProgress) _stateScreen.tryEmit(HotelsStateScreen.LoadingData)
                _hotelsAndDetailed.tryEmit(getHotelsAndDetailed())
                _stateScreen.tryEmit(HotelsStateScreen.LoadedData)

            } catch (e: Exception) {
                _stateScreen.tryEmit(HotelsStateScreen.ErrorData)
            }
        }
    }

    fun navigateToHotelDetailed(id: Int) = navigatorToHotelDetailed(id)
}