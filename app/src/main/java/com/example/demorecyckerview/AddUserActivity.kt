package com.example.demorecyckerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class AddUserActivity : AppCompatActivity() {
    private lateinit var tilFirstName: TextInputEditText
    private lateinit var tilLastName: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        tilFirstName = findViewById(R.id.tied_first_name)
        tilLastName = findViewById(R.id.tied_last_name)
        val btnAdd: Button = findViewById(R.id.btn_add_user)
        val btnAddExit : Button = findViewById(R.id.btn_add_and_exit)
        val btnExit: Button = findViewById(R.id.btn_exit)


        btnAdd.setOnClickListener {
            if (addUser()) {
                tilFirstName.text=null
                tilLastName.text=null
                //Obligar a que el cursor vuelva al campo superior
                tilFirstName.requestFocus()
            }
        }
        btnAddExit.setOnClickListener{
            if (addUser()) {
                finish()
            }
        }
        btnExit.setOnClickListener{
            finish()
        }

    }
    private fun addUser():Boolean{
        val firstName: String = tilFirstName.text.toString()
        val lastName: String = tilLastName.text.toString()
        if (firstName.length > 3 && lastName.length > 3) {
            (application as App).users.add(
                User(
                    UUID.randomUUID().toString(),
                    firstName,
                    lastName,
                    ""
                )
            )
            return true
        } else {
            Toast.makeText(this, "Datos requeridos", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}

