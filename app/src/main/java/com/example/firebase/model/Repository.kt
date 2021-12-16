package com.example.firebase.model

import com.google.firebase.database.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.callbackFlow


object Repository {

    private val myRef = FirebaseDatabase.getInstance().reference

    fun sendMessages(user: User) {
        val ref = FirebaseDatabase.getInstance().reference
            .child("Chat").push()
        ref.child("name").setValue(user.name)
        ref.child("message").setValue(user.message)
        ref.child("date").setValue(user.date)
    }



    @ExperimentalCoroutinesApi
    fun fetchChat() = callbackFlow{

        val listener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val items = dataSnapshot.children.map { ds ->
                    ds.getValue(User::class.java)
                }
                this@callbackFlow.sendBlocking(items.filterNotNull())
            }
        }

        myRef.child("Chat")
            .addValueEventListener(listener)

        awaitClose {
            myRef.child("Chat")
                .removeEventListener(listener)
        }

    }


}