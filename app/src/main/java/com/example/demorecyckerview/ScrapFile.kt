package com.example.demorecyckerview

import android.provider.ContactsContract

class Square(private val side: Int, private var area: Int, private var blue: Boolean = area > 5) {

}

class SquareOld {
    private val side: Int

    constructor(side: Int, area: Int, blue: Boolean) {
        this.side = side
    }
}

//------------- Data clases
data class User(
    val id: Int,
    val name: String,
    val password: String? = "foco",
    val imageUrl: String? = null
)

object FFF {
    fun scrap() {
        val sq = Square(1, 2, true)

        User(id = 1, name = "name", password = "1234", "imageUrl")
    }
}