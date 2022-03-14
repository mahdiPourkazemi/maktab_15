package com.pourkazemi.mahdi.mymaktab_hw15.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pourkazemi.mahdi.mymaktab_hw15.R
import com.pourkazemi.mahdi.mymaktab_hw15.databinding.ModelBinding
import com.pourkazemi.mahdi.mymaktab_hw15.model.City

class RecycleViewAdapter :
    ListAdapter<City, RecycleViewAdapter.MyModelViewHolder>(StringDiffCallback()) {

    var tracker: SelectionTracker<Long>? = null
    init {
        setHasStableIds(true)
    }


    class MyModelViewHolder(private var binding: ModelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun funBinding(bCity: City, isActivated: Boolean = false) {
            binding.city = bCity
            itemView.isActivated = isActivated
            binding.executePendingBindings()
        }
        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int =bindingAdapterPosition
                override fun getSelectionKey(): Long = itemId
            }
        companion object {
            fun from(parent: ViewGroup): MyModelViewHolder {
                val binding = ModelBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return MyModelViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyModelViewHolder {
        return MyModelViewHolder.from(parent)
    }

    override fun onBindViewHolder(
        holder: MyModelViewHolder,
        onBindPosition: Int
    ) {
        holder.funBinding(getItem(onBindPosition))
        tracker?.let {
            holder.funBinding(getItem(onBindPosition), it.isSelected(onBindPosition.toLong()))
        }
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