package com.thoughtworks.sgdata.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageMetadata(
    @Json(name = "height") val height: Int,
    @Json(name = "width") val width: Int,
    @Json(name = "md5") val md5: String
)
