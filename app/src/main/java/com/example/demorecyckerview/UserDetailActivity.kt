package com.example.demorecyckerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class UserDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity_detail)
        val userId = intent.extras?.getString("userId")
        if (userId == null) {
            finish()
        }
        var user: User? = null
        (application as App).users.forEach { forUser ->
            if (forUser.id == userId) {
                user = forUser
                return
            }
        }
        if (userId == null) {
            finish()
        }
        val tvDetailFirstName: TextView = findViewById(R.id.tv_detail_first_name)
        val tvDetailLastName: TextView = findViewById(R.id.tv_detail_last_name)
        val ivDetailActivity: ImageView = findViewById(R.id.iv_detail_img)

        tvDetailFirstName.text= user?.firstName
        tvDetailLastName.text= user?.lastName



    }
}