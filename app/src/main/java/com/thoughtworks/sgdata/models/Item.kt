package com.thoughtworks.sgdata.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "timestamp") val timestamp: Date,
    @Json(name = "cameras") val cameras: List<Camera>
)
