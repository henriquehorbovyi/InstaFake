package io.henrikhorbovyi.instafake.entity

import java.util.*

data class Post(
    val id: String = "",
    val userName: String,
    val profilePicture: String = "",
    val location: String = "", //optional
    val picture: String = "",
    val description: String = "", //optional
    val timestamp: Long = Calendar.getInstance().time.time,
)