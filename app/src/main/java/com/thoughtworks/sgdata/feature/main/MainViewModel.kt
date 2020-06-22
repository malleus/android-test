package com.thoughtworks.sgdata.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.thoughtworks.sgdata.core.network.APIClient
import com.thoughtworks.sgdata.core.network.Resource
import com.thoughtworks.sgdata.models.Traffic
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val apiClient: APIClient) : ViewModel() {
    val trafficData: LiveData<Traffic> = liveData(Dispatchers.IO) {
        val data = apiClient.apiInterface.fetchTraffic()
        emit(data)
    }

    fun fetchTrafficData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiClient.apiInterface.fetchTraffic()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Network Error"))
        }
    }
}
