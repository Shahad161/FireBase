package com.example.firebase.model

import com.example.firebase.util.getCurrentDateTime


data class User(
    val name: String = "",
    val message: String = "",
    val date: Long = getCurrentDateTime()
)
