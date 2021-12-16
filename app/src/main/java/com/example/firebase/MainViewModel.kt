package com.example.firebase

import androidx.lifecycle.*
import com.example.firebase.model.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch




class MainViewModel: ViewModel(), ChatInteractionListener{

    private val repository = Repository

    val userName = MutableLiveData<String>()
    val messages = MutableLiveData<String>()

    val chat = MutableLiveData<List<User>>()


    @ExperimentalCoroutinesApi
    fun onClickSend(){
        repository.sendMessages(
                User(
                    name = userName.value.toString(),
                    message =  messages.value.toString(),

                )
            )
        viewModelScope.launch {
            repository.fetchChat().collect {
                chat.postValue(it)
            }
        }

    }


}