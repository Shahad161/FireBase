package com.example.firebase.ui.sing_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.firebase.ui.sing_in.SingInViewModel
import com.example.firebase.*


class SingUpActivity : AppCompatActivity() {

    lateinit var binding: SingUpActivityBinding
    private val viewModel: SingInViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sing_in)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        setUp()
    }

    private fun setUp(){ }

}