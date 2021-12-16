package com.example.firebase.ui.activity

import com.example.firebase.R
import com.example.firebase.model.User
import com.example.firebase.ui.base.BaseInteractionListener
import com.example.firebase.ui.base.BaseRecyclerAdapter


class ChatRecyclerView(cartItems: List<User>, listener: ChatInteractionListener)
    : BaseRecyclerAdapter<User>(cartItems, listener) {

    override val layoutId: Int = R.layout.item_message

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>,
    ) =
        getItems()[oldItemPosition] == (newItems[newItemPosition] as User)

}

interface ChatInteractionListener : BaseInteractionListener { }