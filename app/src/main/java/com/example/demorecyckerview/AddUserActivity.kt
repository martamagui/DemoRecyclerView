package com.example.demorecyckerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*

class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val app = (application as App)
        val users = app.users


        val etFirstName: EditText = findViewById(R.id.et_first_name)
        val etLastName: EditText = findViewById(R.id.et_last_name)
        val btnAdd: Button =  findViewById(R.id.btn_add_user)



        btnAdd.setOnClickListener{
            val firstName: String = etFirstName.text.toString()
            val lastName: String = etLastName.text.toString()
            users.add(User(UUID.randomUUID().toString(),firstName,lastName,""))

            //cambio de pantalla
            val nextScreenIntent: Intent = Intent(this, MainActivity::class.java)
            startActivity(nextScreenIntent)

        }

    }
}

