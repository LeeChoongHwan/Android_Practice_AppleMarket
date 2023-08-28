package com.example.android_practice_applamarket.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val image : String,
    val source : Int,
    val name : String,
    val description : String,
    val owner : String,
    val price : Int,
    val location : String,
    val like : Int,
    val reply : Int
) : Parcelable
