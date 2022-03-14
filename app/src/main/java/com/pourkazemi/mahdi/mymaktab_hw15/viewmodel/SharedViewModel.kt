package com.pourkazemi.mahdi.mymaktab_hw15.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pourkazemi.mahdi.mymaktab_hw15.model.City

class SharedViewModel : ViewModel() {

    private val _city = MutableLiveData<List<City>>()
    val city: LiveData<List<City>> = _city

    fun changeStateCity(mCity: City) {
        val mm = _city.value?.get(mCity.id.toInt())
        mm?.let {
            Log.d("click", "shooooood")
            it.selected = !mCity.selected
        }
    }

    init {
        _city.value = listOf(
            City(0L, "tehran", false),
            City(1L, "isfahan", false), City
                (2L, "shiraz", false), City(3L, "tehran", false),
            City(4L, "isfahan", false), City
                (5L, "shiraz", false)
        )
    }
}