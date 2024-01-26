package com.example.myapplication.common.state

sealed class HotelsStateScreen {

    object LoadingData : HotelsStateScreen()
    object LoadedData : HotelsStateScreen()
    object ErrorData : HotelsStateScreen()
}