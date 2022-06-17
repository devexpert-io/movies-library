package com.devexperto.damproject.screens.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devexperto.damproject.R
import com.devexperto.damproject.databinding.ViewLoginTimeBinding
import com.devexperto.damproject.db.LoginTime
import java.util.*

class LoginTimeListAdapter2 :
    RecyclerView.Adapter<LoginTimeListAdapter2.ViewHolder>() {

    var items = emptyList<LoginTime>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_login_time, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ViewLoginTimeBinding.bind(view)

        fun bind(item: LoginTime) = with(binding) {
            loginTimeId.text = item.id.toString()
            loginTimeEmail.text = item.user
            loginTimeDate.text = Date(item.date).toString()
        }
    }
}