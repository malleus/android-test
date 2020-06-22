package com.thoughtworks.sgdata.feature.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thoughtworks.sgdata.R
import com.thoughtworks.sgdata.models.Camera
import com.thoughtworks.sgdata.models.Traffic
import kotlinx.android.synthetic.main.layout_traffic.view.*

class TrafficAdapter :
    RecyclerView.Adapter<TrafficAdapter.DataViewHolder>() {

    private var traffic: Traffic? = null

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(camera: Camera) {
            itemView.text_camera_id.text = camera.cameraId
            itemView.text_timestamp.text = camera.timestamp.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_traffic, parent, false)
        )

    override fun getItemCount(): Int {
        traffic?.let {
            return it.items[0].cameras.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        traffic?.let {
            holder.bind(it.items[0].cameras[position])
        }
    }

    fun update(traffic: Traffic) {
        this.traffic = traffic
        notifyDataSetChanged()
    }
}
