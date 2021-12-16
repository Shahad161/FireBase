package com.example.firebase.ui.activity

import android.util.Log
import androidx.lifecycle.*
import com.example.firebase.model.Repository
import com.example.firebase.model.User
import com.example.firebase.util.getCurrentDateTime
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch




class MainViewModel: ViewModel(), ChatInteractionListener {

    private val repository = Repository

    val userName = MutableLiveData<String>()
    val messages = MutableLiveData<String>()

    val chat = MutableLiveData<List<User>>()


    @ExperimentalCoroutinesApi
    fun onClickSend(){
        repository.sendMessages(
            User(
                name = userName.value.toString(),
                message = messages.value.toString(),
                date = getCurrentDateTime()
                )
        )
        viewModelScope.launch {
            repository.fetchChat().collect {
                chat.postValue(it)
            }
        }

    }


}