package com.e.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.myapplication.dataclasses.User
import com.e.myapplication.network.MyAppNetworkApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
