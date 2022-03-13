package com.pourkazemi.mahdi.mymaktab_hw15.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pourkazemi.mahdi.mymaktab_hw15.databinding.ModelBinding
import com.pourkazemi.mahdi.mymaktab_hw15.model.City

class RecycleViewAdapter
    : ListAdapter<City, RecycleViewAdapter.MyModelViewHolder>(StringDiffCallback()) {


    inner class MyModelViewHolder(private var binding: ModelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun funBinding(bCity: City) {
            binding.city = bCity
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyModelViewHolder {
        val view = ModelBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyModelViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MyModelViewHolder,
        onBindPosition: Int
    ) {
        holder.funBinding(getItem(onBindPosition))
    }

}

class StringDiffCallback : DiffUtil.ItemCallback<City>() {

    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        Log.d("main", "$newItem")
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        Log.d("main", "$newItem")
        return oldItem == newItem
    }

}