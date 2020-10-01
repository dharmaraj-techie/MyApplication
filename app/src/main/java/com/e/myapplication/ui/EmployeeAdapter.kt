package com.e.myapplication.ui

import com.e.myapplication.R
import com.e.myapplication.dataclasses.User
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.myapplication.CellClickListener
import com.e.myapplication.databinding.EmployeeListItemBinding


class EmployeeAdapter() :
    RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    var data = listOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = EmployeeListItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data = data[position])
    }

     class ViewHolder(private val binding: EmployeeListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: User) {
            binding.nameTV.text = data.name
            binding.emailIdTV.text = data.email
        }
    }
}


class EmployeeClickListener(val clickListener: (id: Long) -> Unit) {
    fun onClick(user: User) = clickListener(user.id)
}