package com.e.myapplication.ui

import com.e.myapplication.dataclasses.User
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.myapplication.databinding.EmployeeListItemBinding


class EmployeeAdapter(val clickListener: EmployeeClickListener) :
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
        holder.bind(data = data[position], clickListener)
    }

     class ViewHolder(private val binding: EmployeeListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: User, clickListener: EmployeeClickListener) {
            binding.user = data
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }
}


class EmployeeClickListener(val clickListener: (id: Long) -> Unit) {
    fun onClick(user: User) = clickListener(user.id)
}