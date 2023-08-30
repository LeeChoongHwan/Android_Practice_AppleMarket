package com.example.android_practice_applamarket

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice_applamarket.data.Product
import com.example.android_practice_applamarket.databinding.ActivityDetailContentBinding
import java.text.DecimalFormat

class DetailContentActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productData : Product? = intent.getParcelableExtra("product")

        setData(productData)
        initView()
    }

    private fun initView() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    // Intent로 받은 데이터로 Text 설정
    @SuppressLint("SetTextI18n")
    private fun setData(productData: Product?) {
        val decimalFormat = DecimalFormat("#,###")

        productData?.let {binding.productImage.setImageResource(it.imageResource)}
        binding.profileName.text = productData?.owner
        binding.profileLocation.text = productData?.location
        binding.itemTitle.text = productData?.productName
        binding.itemContent.text = productData?.description
        binding.priceText.text = decimalFormat.format(productData?.price) + "원"
    }
}