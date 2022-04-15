package com.test.homework10.Models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Fish(
    @Json(name = "Species Name")
    val speciesName: String? = null,
    @Json(name = "Calories")
    val calories: String? = null,
    @Json(name = "Biology")
    val biology: String? = null,
    @Json(name = "Location")
    val location: String? = null,
    @Json(name = "Availability")
    val availability: String? = null,
    @Json(name = "Habitat")
    val habitat: String? = null,
    @Json(name = "Species Illustration Photo")
    val speciesIllustration: Photo? = null
)

