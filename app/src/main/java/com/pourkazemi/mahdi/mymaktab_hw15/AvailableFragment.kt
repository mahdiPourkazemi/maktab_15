package com.pourkazemi.mahdi.mymaktab_hw15

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pourkazemi.mahdi.mymaktab_hw15.adapter.MyItemDetailsLookup
import com.pourkazemi.mahdi.mymaktab_hw15.adapter.RecycleViewAdapter
import com.pourkazemi.mahdi.mymaktab_hw15.databinding.FragmentAvailableBinding
import com.pourkazemi.mahdi.mymaktab_hw15.model.City
import com.pourkazemi.mahdi.mymaktab_hw15.viewmodel.SharedViewModel


class AvailableFragment : Fragment(R.layout.fragment_available) {
    private lateinit var binding:FragmentAvailableBinding
    private val viewModel: SharedViewModel by activityViewModels()

    private var tracker: SelectionTracker<Long>? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAvailableBinding.bind(view)

        fun mCallback( mView:(City)->Unit){
           viewModel.city.observe(viewLifecycleOwner, Observer {
               it.map { mView(it) }

           })
        }
        val adapter = RecycleViewAdapter()


        tracker = SelectionTracker.Builder<Long>(
            "mySelection",
            adapter,
            StableIdKeyProvider(adapter),
            MyItemDetailsLookup(adapter),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        adapter.tracker = tracker
       val layoutManager=
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.availableRecycle.layoutManager=layoutManager
        binding.availableRecycle.adapter=adapter

        viewModel.city.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            }
        })

    }
}