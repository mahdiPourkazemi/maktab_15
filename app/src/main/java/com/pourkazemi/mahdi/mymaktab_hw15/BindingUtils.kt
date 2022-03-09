package com.pourkazemi.mahdi.mymaktab_hw15

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import com.pourkazemi.mahdi.mymaktab_hw15.model.City

@BindingAdapter("cityName")
fun MaterialTextView.cityNameText(input : City){
    text = input.name
}
@SuppressLint("ResourceAsColor")
@BindingAdapter("citySelected")
fun MaterialTextView.citySelected(input: City){
    if (input.selected) setBackgroundColor(R.color.purple_500)
    else setBackgroundColor(R.color.white)
}