package com.e.myapplication.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.myapplication.dataclasses.User
import com.e.myapplication.network.MyAppNetworkApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getPlaceHolderData()
    }

    private fun getPlaceHolderData() {
        MyAppNetworkApi.retrofitService.getValues().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>
            ) {
                _response.value = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = t.message
            }

        })
    }
}