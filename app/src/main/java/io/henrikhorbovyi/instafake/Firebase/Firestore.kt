package io.henrikhorbovyi.instafake.Firebase

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import io.henrikhorbovyi.instafake.entity.User
import io.henrikhorbovyi.instafake.entity.toUser

object Firestore {

    private val userCollection: CollectionReference =
        FirebaseFirestore.getInstance().collection("users")

    fun getUserById(id: String, callback: (User) -> Unit) {
        userCollection
            .whereEqualTo("id", id)
            .limit(1)
            .addSnapshotListener { value, error ->
                val doc: DocumentSnapshot? = value?.documents?.firstOrNull()
                doc.toUser()?.let {
                    callback(it)
                }
            }

    }
}

fun main() {
    Firestore.getUserById("12122") {

    }
}