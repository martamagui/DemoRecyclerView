package com.example.demorecyckerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddUser: Button = findViewById(R.id.btn_AddUser)
        val rvUser: RecyclerView = findViewById(R.id.rv_user)
        /*--
        val userOncClickListener = object : UserOncClickListener {
            override fun onClick(user: String) {
                Log.d("MainActivity", "User clicked from MainActivity: $user")
            }
        }*/
        //----Si declarásemos varios eventos cómo parámetos, sólo podría ir fuera el último.
        // val adapter = UserAdapter(retrieveUsers(),{lo que sea}, {lo que sea}) { user -> Log.d("MainActivivty", "Userclicked on: $user") }
        val app = (application as App)
        val users = app.users

        adapter =
            UserAdapter(users) { user ->
                val intent = Intent(this, UserDetailActivity::class.java)
                intent.putExtra("userId", user.id)
                startActivity(intent)
            }
        rvUser.adapter = adapter
        //val layoutManager = LinearLayoutManager(this)
        val layoutManager = GridLayoutManager(this, 2)
        rvUser.layoutManager = layoutManager


        btnAddUser.setOnClickListener {
            val nextScreenIntent: Intent = Intent(this, AddUserActivity::class.java)
            startActivity(nextScreenIntent)
            /*adapter.addUser(
                User(
                    UUID.randomUUID().toString(),
                    "User from Main Activity ${UUID.randomUUID().toString()}",
                    "Image ${UUID.randomUUID().toString()}"
                )
            )*/
        }
    }

    private fun retrieveUsers(): MutableList<User> {
        return List(5) { index ->
            User(
                UUID.randomUUID().toString(),
                "FName $index",
                "LName $index",
                "Image $index"
            )
        }.toMutableList()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}