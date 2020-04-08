package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.udacity.shoestore.BR
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    private var _name: String,
    private var _size: Double,
    private var _company: String,
    private var _description: String,
    private val _images: List<String> = mutableListOf()
) : Parcelable, BaseObservable() {
    var name: String
        @Bindable get() = _name
        set(value) {
            if (_name != value) {
                _name = value
                notifyPropertyChanged(BR.name)
            }
        }

    var size: Double
        @Bindable get() = _size
        set(value) {
            if (_size != value) {
                _size = value
                notifyPropertyChanged(BR.size)
            }
        }

    var company: String
        @Bindable get() = _company
        set(value) {
            if (_company != value) {
                _company = value
                notifyPropertyChanged(BR.company)
            }
        }

    var description: String
        @Bindable get() = _description
        set(value) {
            if (_description != value) {
                _description = value
                notifyPropertyChanged(BR.description)
            }
        }
}