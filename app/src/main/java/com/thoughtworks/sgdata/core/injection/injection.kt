package com.thoughtworks.sgdata.core.injection

import com.thoughtworks.sgdata.core.network.APIClient
import com.thoughtworks.sgdata.feature.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val apiModule: Module = module {
    single { APIClient() }
}

val viewModelModule: Module = module {
    viewModel { MainViewModel(get()) }
}
