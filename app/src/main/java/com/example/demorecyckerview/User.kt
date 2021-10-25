package com.example.demorecyckerview

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val imageUrl: String? = null
) {
    constructor(userResponse: UserResponse) : this(
        userResponse.email,
        userResponse.name.first,
        userResponse.name.last,
        userResponse.picture.medium
    )
}

//Función que añade los valores del Json a nuestro objeto User
fun UserResponse.toUser(): User {
    return User(
        this.email,
        this.name.first,
        this.name.last,
        this.picture.medium
    )
}

//Crea una lista de userResponse y los pasa a User
fun List<UserResponse>.toUser(): List<User> {
    return this.map { it.toUser() }
}