package com.thoughtworks.sgdata.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Camera(
    @Json(name = "timestamp") val timestamp: Date,
    @Json(name = "image") val image: String,
    @Json(name = "location") val location: Location,
    @Json(name = "camera_id") val cameraId: String,
    @Json(name = "image_metadata") val imageMetadata: ImageMetadata
)
