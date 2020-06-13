package com.example.choreimaspassobem.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Price(
    @SerializedName("price")
    val price: Double,
    @SerializedName("type")
    val type: String
) : Parcelable