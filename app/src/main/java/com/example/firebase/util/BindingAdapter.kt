package com.example.firebase.util


import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.model.User
import com.example.firebase.ui.activity.ChatRecyclerView
import com.example.firebase.ui.base.BaseRecyclerAdapter
import com.google.android.material.card.MaterialCardView
import java.text.SimpleDateFormat


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if (!items.isNullOrEmpty()){
        items?.let { listItems ->
            (view.adapter as BaseRecyclerAdapter<T>?).apply {
                this?.setItems(listItems)
                view.smoothScrollToPosition(this?.itemCount!! -1)
            }
        }
    }
}


@SuppressLint("SimpleDateFormat")
@BindingAdapter(value = ["app:formatString"])
fun formatString(textView: TextView, time : Long) {
    val formatter = SimpleDateFormat("HH:mm")
    textView.text = formatter.format(time).toString()
}


@BindingAdapter(value = ["app:sender"])
fun sender(view: View, user : String) {
    view.isVisible = user == "Shahad"
}

@BindingAdapter(value = ["app:receiver"])
fun receiver(view: View, user : String) {
    view.isVisible = user != "Shahad"
}


@BindingAdapter(value = ["app:loading"])
fun loading(view: View, list : List<User>?) {
    view.isVisible = list.isNullOrEmpty()
}

