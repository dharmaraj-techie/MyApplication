package com.e.myapplication.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.e.myapplication.CellClickListener
import com.e.myapplication.R
import kotlinx.android.synthetic.main.employee_fragment.*
import kotlinx.android.synthetic.main.employee_list_item.*
import java.lang.StringBuilder

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
            Toast.makeText(context,"$id",Toast.LENGTH_LONG).show()
        })

        val recyclerView  =  view.findViewById<RecyclerView>(R.id.employeeRV)
        recyclerView.adapter = adapter

        viewModel.response.observe(this.viewLifecycleOwner, Observer {users ->

            adapter.data = users

        })
    }

}