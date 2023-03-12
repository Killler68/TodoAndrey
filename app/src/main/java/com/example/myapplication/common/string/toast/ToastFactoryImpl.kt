package com.example.myapplication.common.string.toast

import android.content.Context
import android.widget.Toast
import com.example.myapplication.common.string.toast.ToastFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToastFactoryImpl(
    private val context: Context
) : ToastFactory {

    override suspend fun show(text: String) = withContext(Dispatchers.Main) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }
}