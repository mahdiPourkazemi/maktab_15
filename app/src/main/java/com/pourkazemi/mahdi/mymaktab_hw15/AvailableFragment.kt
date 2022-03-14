package com.pourkazemi.mahdi.mymaktab_hw15

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pourkazemi.mahdi.mymaktab_hw15.adapter.RecycleViewAdapter
import com.pourkazemi.mahdi.mymaktab_hw15.databinding.FragmentAvailableBinding
import com.pourkazemi.mahdi.mymaktab_hw15.model.City
import com.pourkazemi.mahdi.mymaktab_hw15.viewmodel.SharedViewModel


class AvailableFragment : Fragment(R.layout.fragment_available) {
    private lateinit var binding:FragmentAvailableBinding
    private val viewModel: SharedViewModel by activityViewModels()

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAvailableBinding.bind(view)

        fun mCallback( mView:(City)->Unit){
           viewModel.city.observe(viewLifecycleOwner, Observer {
               it.map { mView(it) }

           })
        }
        var adapter = RecycleViewAdapter({
                viewModel.changeStateCity(it)
                Log.d("test","this is your position ${it.id}")

        },{view1->
            mCallback {
                if (!it.selected) view1.setBackgroundColor(R.color.teal_200)
                else view1.setBackgroundColor(R.color.white)
            }

        })
        val layoutManager =
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