package com.pourkazemi.mahdi.mymaktab_hw15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import com.pourkazemi.mahdi.mymaktab_hw15.viewmodel.SharedViewModel
import com.pourkazemi.mahdi.mymaktab_hw15.databinding.FragmentAvailableBinding

class AvailableFragment : Fragment(R.layout.fragment_available) {
    lateinit var bind:FragmentAvailableBinding
    private val fViewModer: SharedViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentAvailableBinding.bind(view)
    }
}