package io.henrikhorbovyi.instafake.entity

import com.google.firebase.firestore.DocumentSnapshot

data class User(
    val id: String? = "",
    val userName: String? = "",
    val fullName: String? = "",
    val email: String? = "",
    val phone: String? = "",
    val picture: String? = ""
)

fun DocumentSnapshot?.toUser(): User? {
    return this?.run {
        User(
            id = getString("id"),
            userName = getString("username"),
            fullName = getString("fullname"),
            email = getString("email"),
            phone = getString("phone"),
            picture = getString("picture")
        )
    }
}