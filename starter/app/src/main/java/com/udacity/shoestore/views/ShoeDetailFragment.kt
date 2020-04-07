package com.udacity.shoestore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        arguments?.let { binding.shoe = ShoeDetailFragmentArgs.fromBundle(it).shoe }

        binding.btnCancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeList)
        }

        binding.btnSave.setOnClickListener {
            // Save the shoe item
            with(binding) {
                if (editShoeName.text.isNotEmpty() &&
                        editShoeSize.text.isNotEmpty() &&
                        editShoeCompany.text.isNotEmpty() &&
                        editDescription.text.isNotEmpty()) {

                    viewModel.save(editShoeName.text.toString(),
                        editShoeSize.text.toString().toDouble(),
                        editShoeCompany.text.toString(),
                        editDescription.text.toString())

                    findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeList)

                } else Toast.makeText(requireContext(), "Empty values", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }
}