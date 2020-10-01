package com.e.myapplication.ui.employees

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.e.myapplication.R
import kotlinx.android.synthetic.main.employee_fragment.*

class EmployeeFragment : Fragment() {

    private lateinit var viewModel: EmployeeViewModel
    private lateinit var adapter: EmployeeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        return inflater.inflate(R.layout.employee_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(isNetworkAvailable(this.context)){
            employeeRV.visibility = View.VISIBLE
            errorMessage.visibility = View.INVISIBLE
            adapter = EmployeeAdapter(EmployeeClickListener { user ->
                view.findNavController().navigate(EmployeeFragmentDirections.actionEmployeeFragmentToDetailEmployeeFragment(user))
            })

            val recyclerView  =  view.findViewById<RecyclerView>(R.id.employeeRV)
            recyclerView.adapter = adapter

            viewModel.response.observe(this.viewLifecycleOwner, Observer {users ->
                adapter.data = users
            })
        } else{
            employeeRV.visibility = View.INVISIBLE
            errorMessage.visibility = View.VISIBLE
        }

    }


    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                return true
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }

}