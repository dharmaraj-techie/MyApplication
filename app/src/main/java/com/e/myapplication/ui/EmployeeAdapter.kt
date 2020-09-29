package com.e.myapplication.ui

import com.e.myapplication.R
import com.e.myapplication.dataclasses.User


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EmployeeAdapter : RecyclerView.Adapter<ViewHolder>() {
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
        val view = layoutInflater.inflate(R.layout.employee_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data = data[position])
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.nameTV)
    private val email: TextView = itemView.findViewById(R.id.emailIdTV)

    fun bind(data: User) {
        name.text = data.name
        email.text = data.email
    }
}