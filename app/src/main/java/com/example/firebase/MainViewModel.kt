package com.example.firebase

import android.util.Log
import androidx.lifecycle.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.ktx.database


class MainViewModel: ViewModel(){

    val myRef = Firebase
        .database
        .reference

    val massage = MutableLiveData<String>()


    fun onClickSend(){
        Log.i("kkk", massage.value.toString())
        myRef.child("name").setValue(massage.value.toString())
    }

}