package com.example.firebase

import com.example.firebase.model.User


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