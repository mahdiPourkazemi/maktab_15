package com.pourkazemi.mahdi.mymaktab_hw15.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.pourkazemi.mahdi.mymaktab_hw15.R
import com.pourkazemi.mahdi.mymaktab_hw15.databinding.ModelBinding
import com.pourkazemi.mahdi.mymaktab_hw15.model.City

class RecycleViewAdapter :
    RecyclerView.Adapter<RecycleViewAdapter.MyModelViewHolder>() {

//private lateinit var bind: ModelBinding
    var mList: List<City> = emptyList()
        private set
    fun setListCity(fList:List<City>){
        mList=fList
    }

    var tracker: SelectionTracker<Long>? = null

    inner class MyModelViewHolder(private var binding: ModelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //////////////////////////////////////////
        fun funBinding(city: City ) {
            binding.textView.text = city.name
            binding.textView.isSelected=city.selected
            tracker?.let {
                if (it.isSelected(city.id)) {
                    binding.textView.setBackgroundColor(
                        ContextCompat.getColor(binding.textView.context, R.color.purple_200))
                } else {
                    binding.textView.background = null
                }
            }
        }

        fun getItem(): ItemDetailsLookup.ItemDetails<Long> =

            object : ItemDetailsLookup.ItemDetails<Long>() {

                override fun getPosition(): Int = bindingAdapterPosition

                override fun getSelectionKey(): Long = mList[bindingAdapterPosition].id
            }

        fun getViewHolderItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int =  bindingAdapterPosition
                override fun getSelectionKey(): Long = mList[bindingAdapterPosition].id
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
        holder.funBinding(mList[onBindPosition])
    }

    override fun getItemCount() = mList.size
}