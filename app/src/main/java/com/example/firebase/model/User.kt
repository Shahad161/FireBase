package com.example.firebase.model

import com.example.firebase.util.getCurrentDateTime
import java.util.*


data class User(
    val name: String = "",
    val message: String = "",
    val date: Date = getCurrentDateTime()
)
