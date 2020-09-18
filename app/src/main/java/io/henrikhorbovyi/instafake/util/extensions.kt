package io.henrikhorbovyi.instafake.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import kotlin.reflect.KClass

fun View.hideKeyBoard() {
    try {
        val keyboard: InputMethodManager =
            this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.hideSoftInputFromWindow(this.windowToken, 0)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun View.snackbar(view: View, message: String){
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}

fun Activity.launchActivity(activity: KClass<*>, finishActivity: Boolean = true){
    val intent = Intent(this, activity.java)
    startActivity(intent)
    if (finishActivity)
        finish()
}