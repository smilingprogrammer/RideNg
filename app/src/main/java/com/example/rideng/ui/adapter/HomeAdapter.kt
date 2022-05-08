package com.example.rideng.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rideng.databinding.ListHomeBinding
import com.example.rideng.model.getvehicle.GetVehicleData

class HomeAdapter(private val listener: (GetVehicleData) -> Unit)
    : ListAdapter<GetVehicleData, HomeAdapter.HomeViewHolder>(ItemCallback()) {

    private class ItemCallback: DiffUtil.ItemCallback<GetVehicleData>() {
        override fun areItemsTheSame(oldItem: GetVehicleData, newItem: GetVehicleData): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: GetVehicleData, newItem: GetVehicleData): Boolean {
            return oldItem == newItem
        }
    }

    inner class HomeViewHolder(private val binding: ListHomeBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(data: GetVehicleData){
            binding.image.load(data.images[2])
            binding.location.text = data.location.city
            binding.model.text = data.model
            binding.allHome.setOnClickListener {
                listener.invoke(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ListHomeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}