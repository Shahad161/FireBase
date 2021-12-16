package com.example.firebase.util

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.ui.base.BaseRecyclerAdapter


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    Log.i("kkk", items.toString())
    items?.let { listItems ->
        (view.adapter as BaseRecyclerAdapter<T>?)
            ?.setItems(listItems)
    }
}