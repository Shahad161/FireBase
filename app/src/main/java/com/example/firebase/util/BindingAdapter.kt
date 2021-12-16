package com.example.firebase.util


import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.ui.base.BaseRecyclerAdapter



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

