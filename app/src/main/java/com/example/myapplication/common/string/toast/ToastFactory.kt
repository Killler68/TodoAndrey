package com.example.myapplication.common.string.toast

interface ToastFactory {

    suspend fun show(text: String)
}