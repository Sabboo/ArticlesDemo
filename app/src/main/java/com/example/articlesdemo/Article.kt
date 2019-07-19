package com.example.articlesdemo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    var id: String,
    var name: String,
    var imageUrl: String,
    var content: String
) : Parcelable