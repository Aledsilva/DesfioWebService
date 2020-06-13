package com.example.choreimaspassobem.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Url(
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
) : Parcelable