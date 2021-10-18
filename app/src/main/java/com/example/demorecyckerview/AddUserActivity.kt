package com.example.demorecyckerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class AddUserActivity : AppCompatActivity() {
    private lateinit var tilFirstName: TextInputEditText
    private lateinit var tilLastName: TextInputEditText
    private lateinit var rbImage1: RadioButton
    private lateinit var rbImage2: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        tilFirstName = findViewById(R.id.tied_first_name)
        tilLastName = findViewById(R.id.tied_last_name)
        val btnAdd: Button = findViewById(R.id.btn_add_user)
        val btnAddExit: Button = findViewById(R.id.btn_add_and_exit)
        val btnExit: Button = findViewById(R.id.btn_exit)

        val rbGroup: RadioGroup = findViewById(R.id.rg_group)
        rbImage1 = findViewById(R.id.rb_img1)
        rbImage2 = findViewById(R.id.rb_img2)

        val ivImage1: ImageView = findViewById(R.id.iv_1)
        val ivImage2: ImageView = findViewById(R.id.iv_2)

        Glide.with(this)
            .load("https://i.ytimg.com/vi/1Ne1hqOXKKI/maxresdefault.jpg")
            .into(ivImage1)
        Glide.with(this)
            .load("https://cdn.theatlantic.com/thumbor/OgQgHFiqAd92pArI1zjmcUHjoSc=/144x0:2411x1700/1200x900/media/img/mt/2017/06/shutterstock_319985324/original.jpg")
            .into(ivImage2)



        btnAdd.setOnClickListener {
            if (addUser()) {
                tilFirstName.text = null
                tilLastName.text = null
                //Obligar a que el cursor vuelva al campo superior
                tilFirstName.requestFocus()
            }
        }
        btnAddExit.setOnClickListener {
            if (addUser()) {
                finish()
            }
        }
        btnExit.setOnClickListener {
            finish()
        }

    }

    private fun addUser(): Boolean {
        val firstName: String = tilFirstName.text.toString()
        val lastName: String = tilLastName.text.toString()
        var imageUrl : String? = null

        if(rbImage1.isChecked){
            imageUrl= "https://i.ytimg.com/vi/1Ne1hqOXKKI/maxresdefault.jpg"
        }else{
            imageUrl= "https://cdn.theatlantic.com/thumbor/OgQgHFiqAd92pArI1zjmcUHjoSc=/144x0:2411x1700/1200x900/media/img/mt/2017/06/shutterstock_319985324/original.jpg"
        }
        if (firstName.length > 3 && lastName.length > 3) {
            (application as App).users.add(
                User(
                    UUID.randomUUID().toString(),
                    firstName,
                    lastName,
                    imageUrl
                )
            )
            return true
        } else {
            Toast.makeText(this, "Datos requeridos", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}

