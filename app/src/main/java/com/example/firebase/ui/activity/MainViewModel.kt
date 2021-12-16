package com.example.firebase.ui.activity

import androidx.lifecycle.*
import com.example.firebase.model.*
import com.example.firebase.util.getCurrentDateTime
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch



@ExperimentalCoroutinesApi
class MainViewModel: ViewModel(), ChatInteractionListener {

    private val repository = Repository

    val userName = MutableLiveData<String>()
    val messages = MutableLiveData<String>()

    val chat = MutableLiveData<List<User>>()


    init {
        viewModelScope.launch {
            repository.fetchChat().collect {
                chat.postValue(it)
            }
        }
    }


    fun onClickSend(){
        if (!messages.value.isNullOrEmpty()){
            repository.sendMessages(
                User(
                    name = userName.value.toString(),
                    message = messages.value.toString(),
                    date = getCurrentDateTime()
                )
            )
            messages.postValue("")
        }
    }


}