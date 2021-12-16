package com.example.firebase.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*



@SuppressLint("SimpleDateFormat")
fun getCurrentDateTime(): String {
    val formatter = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
    return formatter.format(Calendar.getInstance().time)
}