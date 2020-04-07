package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    val shoeLiveData: LiveData<List<Shoe>>
        get() = shoeMutableLiveData
    private val shoeMutableLiveData = MutableLiveData<List<Shoe>>()

    private val shoeList = ArrayList<Shoe>()

    fun save(name: String, size: Double, company: String, description: String) {
        shoeList.add(Shoe(name, size, company, description))

        shoeMutableLiveData.value = shoeList
    }
}