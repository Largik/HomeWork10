package com.test.homework10.model.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.test.homework10.domain.Fish

@JsonClass(generateAdapter = true)
data class FishJsonResponse(
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
    val speciesIllustration: PhotoJsonResponse? = null
){
    fun toFish(): Fish = Fish(
        speciesName = speciesName,
        biology = biology,
        location = location,
        availability = availability,
        calories = calories,
        habitat = habitat,
        speciesIllustration = speciesIllustration?.toPhoto()
    )
}

