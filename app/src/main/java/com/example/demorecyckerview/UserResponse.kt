package com.example.demorecyckerview

data class UserResponse(
    val name: FullNameResponse,
    val email: String,
    val picture: PictureResponse

) {
}

data class FullNameResponse(
    val title: String,
    val first: String,
    val last: String
)

data class PictureResponse(
    val large: String,
    val medium: String,
    val thumbnail: String
)