package com.example.firebase.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.firebase.BR
import com.example.firebase.R
import com.example.firebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this

        binding.recycler.adapter =
            ChatRecyclerView(mutableListOf(), this.viewModel)

    }

}