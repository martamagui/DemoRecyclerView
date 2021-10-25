package com.example.demorecyckerview

import android.widget.ImageView
import androidx.constraintlayout.helper.widget.MotionPlaceholder
import com.bumptech.glide.Glide

fun ImageView.imageFromUrl(imageUrl: String, placeholderId: Int= R.drawable.gato) {
    Glide.with(this)
        .load(imageUrl)
        .placeholder(placeholderId)
        .into(this)
}