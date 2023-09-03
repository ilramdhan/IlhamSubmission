package com.dicoding.ilhamsubmission


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    val name: String,
    val desc: String,
    val photo: Int
) : Parcelable
