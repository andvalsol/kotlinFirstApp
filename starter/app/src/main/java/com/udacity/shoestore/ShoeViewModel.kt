package com.udacity.shoestore

import android.view.View
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    val shoeLiveData: LiveData<List<Shoe>>
        get() = shoeMutableLiveData
    private val shoeMutableLiveData = MutableLiveData<List<Shoe>>()

    private val shoeList = ArrayList<Shoe>()

    fun showWelcomeScreen(view: View) {
        view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

    fun showInstructionsScreen(view: View) {
        view.findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
    }

    fun showShoeList(view: View) {
        view.findNavController().navigate(R.id.action_instructionsFragment_to_shoeList)
    }

    fun save(
        editShoeName: EditText,
        editShoeSize: EditText,
        editShoeCompany: EditText,
        editDescription: EditText
    ) {
        // Save the shoe item
        if (editShoeName.text.isNotEmpty() &&
            editShoeSize.text.isNotEmpty() &&
            editShoeCompany.text.isNotEmpty() &&
            editDescription.text.isNotEmpty()
        ) {
            shoeList.add(
                Shoe(
                    editShoeName.text.toString(),
                    editShoeSize.text.toString().toDouble(),
                    editShoeCompany.text.toString(),
                    editDescription.text.toString()
                )
            )

            shoeMutableLiveData.value = shoeList

            editShoeName.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeList)
        }
    }

    fun cancel(view: View) {
        view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeList)
    }
}