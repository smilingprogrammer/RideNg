package com.example.rideng.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rideng.databinding.ListHomeBinding
import com.example.rideng.model.getvehicle.Data

class HomeAdapter(): ListAdapter<Data, HomeAdapter.HomeViewHolder>(ItemCallback()) {

    private class ItemCallback: DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    inner class HomeViewHolder(private val binding: ListHomeBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(data: Data){
            binding.image.load(data.images[2])
            binding.text.text = data.fuel_type
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