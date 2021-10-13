package com.example.demorecyckerview

data class User(
    val id: Int,
    val name: String,
    val password: String? = "foco",
    val imageUrl: String? = null
) {
    fun checkValidUser(): Boolean = true
}