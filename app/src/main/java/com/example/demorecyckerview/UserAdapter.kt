package com.example.demorecyckerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(
    private val users: MutableList<User>,
    val oncClickListener: (String)->Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = users[position]
        val onClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                //oncClickListener(user)
            }
        }
        holder.tvUserName.text = user.name
        holder.itemView.setOnClickListener(onClickListener)


        //holder.itemView.setOnClickListener{
        //    onClickListener.onClick(username)
        //}
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun addUser(user: User) {
        users.add(user)
        notifyItemInserted(users.size)
    }

    fun deleteUser(user: User) {
        users.remove(user)
        notifyItemRemoved(users.size)
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvUserName: TextView = view.findViewById(R.id.tv_username)
    }

}

interface UserOncClickListener {
    fun onClick(user: User)
}