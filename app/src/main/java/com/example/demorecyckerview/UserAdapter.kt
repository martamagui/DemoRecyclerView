package com.example.demorecyckerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(
    private val users: MutableList<User>,

    //Listener de click en cada item de user
    val oncClickListener: (String) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = users[position]
        holder.tvUserName.text = user.firstName
        holder.tvLasNAme.text = user.lastName
        /*val onClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                //oncClickListener(user)
            }
        }*/
        holder.tvUserName.text = user.firstName
        //holder.itemView.setOnClickListener(onClickListener)


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
        val tvLasNAme: TextView = view.findViewById(R.id.tv_lastname)
        val tvAvatar: ImageView = view.findViewById(R.id.tv_avatar)
    }

}

interface UserOncClickListener {
    fun onClick(user: User)
}