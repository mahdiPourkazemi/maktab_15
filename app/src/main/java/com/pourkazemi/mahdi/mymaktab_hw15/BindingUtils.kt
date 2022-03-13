package com.pourkazemi.mahdi.mymaktab_hw15

import android.annotation.SuppressLint
import android.provider.CalendarContract
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.pourkazemi.mahdi.mymaktab_hw15.model.City

@SuppressLint("ResourceAsColor")
@BindingAdapter("citySelection")
fun TextView.isSelected(city: City){
    if (!city.selected){

        setBackgroundColor(R.color.white)
    }else {

        setBackgroundColor(R.color.purple_200)
    }
}