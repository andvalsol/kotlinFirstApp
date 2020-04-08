package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe


/**
 * A simple [Fragment] subclass.
 */
class ShoeList : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        viewModel.shoeLiveData.observe(viewLifecycleOwner, Observer {
            it.forEachIndexed { index, shoe ->
                val textView = TextView(requireContext())
                textView.text = "Name: ${shoe.name}, Size: ${shoe.size}, Company: ${shoe.company}, Description: ${shoe.description}"
                textView.id = index
                textView.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                binding.shoeListLayout.addView(textView)
            }
        })

        binding.viewModel = viewModel

        return binding.root
    }
}
