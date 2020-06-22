package com.thoughtworks.sgdata.core.network

import com.thoughtworks.sgdata.models.Traffic
import retrofit2.http.GET

interface APIInterface {
    @GET("/v1/transport/traffic-images")
    suspend fun fetchTraffic(): Traffic
}
