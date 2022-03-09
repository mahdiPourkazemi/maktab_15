package com.pourkazemi.mahdi.mymaktab_hw15

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.pourkazemi.mahdi.mymaktab_hw15.databinding.FragmentSelectedBinding

class SelectedFragment:Fragment(R.layout.fragment_selected) {
    lateinit var bind:FragmentSelectedBinding
    private val fViewModel:SharedViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentSelectedBinding.bind(view)
        bind.selectRecycle
    }
}