package com.example.demorecyckerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class UserDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity_detail)
        val userId = intent.extras?.getString("userId")
        if (userId == null) {
            Log.d("Detail", "user id es null")
            finish()
        }

        //---- OPCIONES PARA RECOGER EL USUARIO que coincide con el id que tiene el extra
        val user: User? = (application as App).users.firstOrNull { forUser -> forUser.id == userId }
        //--- OPCION 2 --- val user: User? = (application as App).users.filter{forUser -> forUser.id==userId}
        /*--- OPCION 3 --- var user: User? = null
        (application as App).users.forEach { forUser ->
            if (forUser.id == userId) {
                user = forUser
                //hay que devolver obligatoriamente
                return@forEach
            }
        }*/

        if (userId == null) {
            finish()
        }
        val tvDetailFirstName: TextView = findViewById(R.id.tv_detail_first_name)
        val tvDetailLastName: TextView = findViewById(R.id.tv_detail_last_name)
        val ivDetailActivity: ImageView = findViewById(R.id.iv_detail_img)

        tvDetailFirstName.text = user?.firstName
        tvDetailLastName.text = user?.lastName

        Glide.with(this).load(user?.imageUrl).into(ivDetailActivity)


    }
}