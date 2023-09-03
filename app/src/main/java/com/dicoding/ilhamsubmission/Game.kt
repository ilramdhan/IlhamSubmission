@file:Suppress("DEPRECATED_ANNOTATION")

package com.dicoding.ilhamsubmission


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Game(
    val name: String,
    val desc: String,
    val photo: Int
) : Parcelable
