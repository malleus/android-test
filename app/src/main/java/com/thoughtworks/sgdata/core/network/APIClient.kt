package com.thoughtworks.sgdata.core.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.thoughtworks.sgdata.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

class APIClient {
    var apiInterface: APIInterface

    init {
        val httpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addInterceptor(loggingInterceptor)
        }
        val httpClient = httpClientBuilder.build()

        val moshi = Moshi.Builder()
            .add(
                Date::class.java, Rfc3339DateJsonAdapter().nullSafe()
            )
            .build()

        val apiClient = Retrofit.Builder()
            .baseUrl("https://api.data.gov.sg")
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        apiInterface = apiClient.create(APIInterface::class.java)
    }
}
