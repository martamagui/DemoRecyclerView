package com.example.demorecyckerview

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val imageUrl: String? = null
) {
    fun checkValidUser(): Boolean = true
}