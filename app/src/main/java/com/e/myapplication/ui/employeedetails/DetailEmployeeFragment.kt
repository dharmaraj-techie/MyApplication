package com.e.myapplication.ui.employeedetails

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.e.myapplication.R
import kotlinx.android.synthetic.main.detail_employee_fragment.*

class DetailEmployeeFragment : Fragment() {

    private lateinit var viewModel: DetailEmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_employee_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = DetailEmployeeFragmentArgs.fromBundle(requireArguments())
        test.text=  args.user.company.catchPhrase
        viewModel = ViewModelProviders.of(this).get(DetailEmployeeViewModel::class.java)
    }

}