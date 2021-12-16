package com.example.firebase.util

import android.annotation.SuppressLint
import java.util.*



@SuppressLint("SimpleDateFormat")

//fun getCurrentDateTime(): String {
//    val formatter = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
//    return formatter.format(Calendar.getInstance().time)
//
//}


fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}