package com.e.myapplication.ui

import android.util.JsonReader
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.myapplication.dataclasses.User
import com.e.myapplication.network.MyAppNetworkApi
import com.e.myapplication.parse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.StringReader

class EmployeeViewModel : ViewModel() {

    private val _response = MutableLiveData<List<User>>()
    val response: LiveData<List<User>>
        get() = _response

    init {
        getPlaceHolderData()
    }

    private fun getPlaceHolderData() {
        MyAppNetworkApi.retrofitService.getValues().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>
            ) {
                val s = response.body()
                _response.value = parse(JsonReader(StringReader(s)))
            }

            override fun onFailure(call: Call<String>, t: Throwable) {

            }

        })
    }
}