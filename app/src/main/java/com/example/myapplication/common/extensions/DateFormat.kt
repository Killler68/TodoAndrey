package com.example.myapplication.common.extensions

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT = "dd"
const val DATE_FORMAT_HOURS = "H:mm "
const val DATE_FORMAT_PREVIEW = "Сегодня, d MMM EEE"
const val DATE_FORMAT_DAYS = "d MMM EEE"
const val LANGUAGE = "ru"
const val TIME_FORMAT = 1000

@SuppressLint("SimpleDateFormat")
val dateFormat = SimpleDateFormat(DATE_FORMAT)

@SuppressLint("SimpleDateFormat")
val dataFormatHours = SimpleDateFormat(DATE_FORMAT_HOURS)

val dateFormatPreview = SimpleDateFormat(DATE_FORMAT_PREVIEW, Locale(LANGUAGE))
val dateFormatDays = SimpleDateFormat(DATE_FORMAT_DAYS, Locale(LANGUAGE))

fun Long.dateFormatUnixTime(): String {
    return dateFormat.format(this * TIME_FORMAT)
}

fun Long.dateFormatUnixTimePreview(): String {
    return dateFormat.format(this)
}

fun Long.dateFormatDays(): String {
    return dateFormatDays.format(this)
}

fun Long.dateFormatPreview(): String {
    return dateFormatPreview.format(this)
}

fun Long.dateFormatHours(): String {
    return dataFormatHours.format(this)
}
