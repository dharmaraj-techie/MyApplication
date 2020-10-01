package com.e.myapplication.ui.employeedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.myapplication.dataclasses.User

class DetailEmployeeViewModel( user: User) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    init {
        _user.value = user
    }

}