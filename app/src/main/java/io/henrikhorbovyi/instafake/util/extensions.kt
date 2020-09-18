package io.henrikhorbovyi.instafake.util

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import kotlin.reflect.KClass


fun View.hideKeyboard() {
    val imm: InputMethodManager =
        context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.snackbar(message: String, actionText: String = "Ok") {
    Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE)
        .setAction(actionText) {}
        .show()
}

fun Activity.launchActivity(activity: KClass<*>, finishActivity: Boolean = false) {
    val intent = Intent(this, activity.java)
    startActivity(intent)
    if (finishActivity)
        finish()
}