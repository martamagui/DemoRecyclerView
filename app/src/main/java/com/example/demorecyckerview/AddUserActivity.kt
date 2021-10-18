package com.example.demorecyckerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val app = (application as App)
        val users = app.users


        val tilFirstName: TextInputEditText = findViewById(R.id.tied_first_name)
        val tilLastName: TextInputEditText = findViewById(R.id.tied_last_name)
        val btnAdd: Button =  findViewById(R.id.btn_add_user)



        btnAdd.setOnClickListener{
            val firstName: String = tilFirstName.text.toString()
            val lastName: String = tilLastName.text.toString()
            users.add(User(UUID.randomUUID().toString(),firstName,lastName,""))

            //cambio de pantalla
            val nextScreenIntent: Intent = Intent(this, MainActivity::class.java)
            startActivity(nextScreenIntent)

        }

    }
}

