package com.e.myapplication.ui.employees

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
        adapter = EmployeeAdapter(EmployeeClickListener { id ->
            view.findNavController().navigate(EmployeeFragmentDirections.actionEmployeeFragmentToDetailEmployeeFragment(id))
        })

        val recyclerView  =  view.findViewById<RecyclerView>(R.id.employeeRV)
        recyclerView.adapter = adapter

        viewModel.response.observe(this.viewLifecycleOwner, Observer {users ->
            adapter.data = users
        })
    }

}