package com.e.myapplication.ui.employeedetails

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.e.myapplication.R
import com.e.myapplication.databinding.DetailEmployeeFragmentBinding
import kotlinx.android.synthetic.main.detail_employee_fragment.*

class DetailEmployeeFragment : Fragment() {

    private lateinit var viewModel: DetailEmployeeViewModel
    private lateinit var binding: DetailEmployeeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val layoutInflater =  LayoutInflater.from(this.context)
        binding = DetailEmployeeFragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = DetailEmployeeFragmentArgs.fromBundle(requireArguments())
        val user =   args.user
        val viewModelFactory = DetailFragmentViewModelFactory(user)
        viewModel = ViewModelProvider(this,viewModelFactory).get(DetailEmployeeViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}