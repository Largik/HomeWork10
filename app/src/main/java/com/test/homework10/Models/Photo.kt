package com.test.homework10.Models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Photo(
    val src: String?,
    val alt: String?,
    val title: String?
)