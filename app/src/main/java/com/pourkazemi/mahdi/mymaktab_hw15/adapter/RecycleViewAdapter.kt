package com.pourkazemi.mahdi.mymaktab_hw15.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pourkazemi.mahdi.mymaktab_hw15.R
import com.pourkazemi.mahdi.mymaktab_hw15.databinding.ModelBinding
import com.pourkazemi.mahdi.mymaktab_hw15.model.City

class RecycleViewAdapter(private val callback:(City)->Unit,private val bView:(View)->Unit)
    : ListAdapter<City, RecycleViewAdapter.MyModelViewHolder>(StringDiffCallback()) {


    class MyModelViewHolder(private var binding: ModelBinding,private val postion:(Int)->Unit) :
        RecyclerView.ViewHolder(binding.root) {

        fun funBinding(bCity: City) {
            postion(bindingAdapterPosition)
            binding.city = bCity
            binding.executePendingBindings()
        }
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyModelViewHolder {
        val view = ModelBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyModelViewHolder(view){ postion->
            view.textView.setOnClickListener {
                callback(getItem(postion))
               // it.setBackgroundColor(R.color.purple_200)
            }
        }
    }

    override fun onBindViewHolder(
        holder: MyModelViewHolder,
        onBindPosition: Int
    ) {
        holder.funBinding(getItem(onBindPosition))
        bView(holder.itemView)
       //holder.itemView.setBackgroundColor()

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