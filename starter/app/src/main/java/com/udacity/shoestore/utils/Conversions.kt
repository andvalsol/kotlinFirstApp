package com.udacity.shoestore.utils

import android.widget.EditText
import androidx.databinding.InverseMethod
import java.lang.NumberFormatException


object Conversions {
    @JvmStatic
    @InverseMethod("toDouble")
    fun toString(
        value: Double
    ): String {
        return value.toString()
    }

    @JvmStatic
    fun toDouble(
        value: String
    ) = try {
        value.toDouble()
    } catch (_: NumberFormatException) {
        -1.0
    }
}
