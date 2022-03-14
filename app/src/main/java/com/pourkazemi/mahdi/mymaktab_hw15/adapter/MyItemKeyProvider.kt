package com.pourkazemi.mahdi.mymaktab_hw15.adapter

import androidx.recyclerview.selection.ItemKeyProvider

class MyItemKeyProvider(private val adapter: RecycleViewAdapter) :
    ItemKeyProvider<Long>(SCOPE_CACHED) {

    override fun getKey(position: Int): Long =
        adapter.getItemId(position)

    //adapter.items[position].id

    override fun getPosition(key: Long): Int =
        adapter.getItemId(key.toInt()).toInt()
    //get indexOfFirst { it.id == key }
}