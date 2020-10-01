package com.e.myapplication.ui.employeedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e.myapplication.dataclasses.User

class DetailFragmentViewModelFactory(private var user: User) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailEmployeeViewModel::class.java)) {
            return DetailEmployeeViewModel(user) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}