package com.example.demorecyckerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
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
        val adapter = UserAdapter(retrieveUsers()) { user -> Log.d("MainActivivty", "Userclicked on: $user") }
        rvUser.adapter = adapter
        //val layoutManager = LinearLayoutManager(this)
        val layoutManager = GridLayoutManager(this,3)
        rvUser.layoutManager = layoutManager


        btnAddUser.setOnClickListener{
            //adapter.addUser(UUID.randomUUID().toString())
        }
    }

    private fun retrieveUsers(): MutableList<User> {
        return List(5) { index -> User(index,"dfgdfg","","") }.toMutableList()
    }
}