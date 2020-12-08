package com.mahendra.intentapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val produk : String,
    val berat : String,
    val detail : String
) : Parcelable