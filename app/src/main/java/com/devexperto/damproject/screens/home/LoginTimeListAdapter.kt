package com.devexperto.damproject.screens.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devexperto.damproject.R
import com.devexperto.damproject.databinding.ViewLoginTimeBinding
import com.devexperto.damproject.db.LoginTime
import java.util.*

class LoginTimeListAdapter :
    ListAdapter<LoginTime, LoginTimeListAdapter.ViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_login_time, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
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

private object DiffUtilCallback : DiffUtil.ItemCallback<LoginTime>() {
    override fun areItemsTheSame(oldItem: LoginTime, newItem: LoginTime): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LoginTime, newItem: LoginTime): Boolean {
        return oldItem == newItem
    }

}