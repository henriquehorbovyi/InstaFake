package io.henrikhorbovyi.instafake.entity

import java.util.*

data class Post(
    val userName: String,
    val profilePicture: String = "",
    val location: String = "Miami", //optional
    val picture: String = "",
    val description: String = "", //optional
    val timestamp: Long = Calendar.getInstance().time.time,
)