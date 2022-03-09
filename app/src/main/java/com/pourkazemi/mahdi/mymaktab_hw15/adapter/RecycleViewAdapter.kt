package com.pourkazemi.mahdi.mymaktab_hw15.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pourkazemi.mahdi.mymaktab_hw15.databinding.ModelBinding
import com.pourkazemi.mahdi.mymaktab_hw15.model.City
import com.pourkazemi.mahdi.mymaktab_hw15.viewmodel.SharedViewModel

class RecycleViewAdapter
    :ListAdapter<City, RecycleViewAdapter.MyModelViewHolder>(StringDiffCallback()){

    lateinit var bind:ModelBinding

    inner class MyModelViewHolder(private var binding:ModelBinding):
        RecyclerView.ViewHolder(bind.root){
        //////////////////////////////////////////
            fun funBinding(vm : SharedViewModel){
                binding.sharedVM=vm
            }
        fun getItem(): ItemDetailsLookup.ItemDetails<Long> =

            object : ItemDetailsLookup.ItemDetails<Long>() {

                override fun getPosition(): Int = bindingAdapterPosition

                override fun getSelectionKey(): Long = mList[bindingAdapterPosition].id
            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyModelViewHolder {
        //*val mInflater=LayoutInflater.from(parent.context)
        //val view = CustomModelBinding.bind(parent.rootView)
        val view=ModelBinding.inflate(LayoutInflater.from(parent.context)
            ,parent,false)
        return MyModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyModelViewHolder,
                                  onBindPosition: Int) {
        holder.funBinding(onBindPosition)
    }

    override fun getItemCount()=mList.size

}
class StringDiffCallback: DiffUtil.ItemCallback<City>(){

    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        Log.d("main","$newItem")
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        Log.d("main","$newItem")
        return oldItem==newItem
    }

}