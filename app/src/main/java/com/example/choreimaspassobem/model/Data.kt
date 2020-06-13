package com.example.choreimaspassobem.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Data(
    @SerializedName("count") val count: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("results") val results: MutableSet<Results>,
    @SerializedName("total") val total: Int
) : Parcelable