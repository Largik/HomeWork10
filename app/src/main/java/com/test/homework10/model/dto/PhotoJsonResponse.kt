package com.test.homework10.model.dto

import com.squareup.moshi.JsonClass
import com.test.homework10.domain.Photo

@JsonClass(generateAdapter = true)
data class PhotoJsonResponse(
    val src: String?,
    val alt: String?,
    val title: String?
) {
    fun toPhoto(): Photo = Photo(
        src = src,
        alt = alt,
        title = title
    )
}