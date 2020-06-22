package com.thoughtworks.sgdata.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.thoughtworks.sgdata.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val vm: MainViewModel by viewModel()
    private lateinit var adapter: TrafficAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TrafficAdapter()
        recyclerview_traffic.layoutManager = LinearLayoutManager(this)
        recyclerview_traffic.adapter = adapter

        vm.trafficData.observe(this, Observer {
            adapter.update(it)
        })
    }
}
