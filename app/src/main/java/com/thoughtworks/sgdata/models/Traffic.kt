package com.thoughtworks.sgdata.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Traffic(
    @Json(name = "items") val items: List<Item>,
    @Json(name = "api_info") val apiInfo: ApiInfo
)
