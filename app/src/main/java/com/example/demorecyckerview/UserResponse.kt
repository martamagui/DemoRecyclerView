package com.example.demorecyckerview

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("results") val users: List<UserResponse>
)

data class UserResponse(
    val name: FullNameResponse,
    val email: String,
    val picture: PictureResponse
) {
}

data class FullNameResponse(
    @SerializedName("title") val title: String,
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String
)

data class PictureResponse(
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("thumbnail") val thumbnail: String
)