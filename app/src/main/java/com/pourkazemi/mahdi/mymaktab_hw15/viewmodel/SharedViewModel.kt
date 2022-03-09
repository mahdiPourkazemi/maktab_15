package com.pourkazemi.mahdi.mymaktab_hw15.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pourkazemi.mahdi.mymaktab_hw15.model.City

class SharedViewModel: ViewModel() {

    private val _city = MutableLiveData<City>()
    val city: LiveData<City> = _city

    init {
        _city.value= (City(55L,"idds",false))
    }
}