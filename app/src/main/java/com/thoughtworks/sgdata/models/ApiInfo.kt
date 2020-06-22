package com.thoughtworks.sgdata.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiInfo(
    @Json(name = "status") val status: String
)
