package com.example.demorecyckerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddUser: Button = findViewById(R.id.btn_AddUser)
        val rvUsers: RecyclerView = findViewById(R.id.rv_users)

        val app = application as App
        var users = app.users


        val gson: Gson = Gson()
        val results = gson.fromJson(FakeData.usersJson, ResultResponse::class.java)

        users.addAll(results.users.toUser())

        /*
        results.users.forEach { userResponse ->
            users.add(userResponse.toUser())
        }
        */

        adapter = UserAdapter(users) { user ->
            val intent = Intent(this, UserDetailActivity::class.java)
            intent.putExtra("userId", user.id)
            startActivity(intent)
        }
        rvUsers.adapter = adapter
        //Listado
        //val layoutManager = LinearLayoutManager(this)
        //Mosaico
        val layoutManager = GridLayoutManager(this,2)
        rvUsers.layoutManager = layoutManager


        btnAddUser.setOnClickListener {
            val intent = Intent(this, AddUserActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}