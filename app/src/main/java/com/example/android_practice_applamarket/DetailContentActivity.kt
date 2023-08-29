package com.example.android_practice_applamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice_applamarket.databinding.ActivityDetailContentBinding

class DetailContentActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }
}