package io.henrikhorbovyi.instafake.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import io.henrikhorbovyi.instafake.MainActivity
import io.henrikhorbovyi.instafake.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private val binding: ActivitySignInBinding by lazy {
        ActivitySignInBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signInUsername.doOnTextChanged { text, _, _, _ ->
            binding.signinButton.isEnabled =
                checkIsBlank(text.toString(), binding.signInPassword.text.toString())
        }

        binding.signInPassword.doOnTextChanged { text, _, _, _ ->
            binding.signinButton.isEnabled =
                checkIsBlank(text.toString(), binding.signInUsername.text.toString())
        }

        binding.signinButton.setOnClickListener { btn ->
            btn.hideKeyboard()
            val username = binding.signInUsername.text.toString()
            val password = binding.signInPassword.text.toString()

            val authTask = FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
            authTask.addOnSuccessListener {
                openActivity(MainActivity::class.java)
            }
            authTask.addOnFailureListener {
                btn.snackbar("Vacilão, tá errado!")
            }

            /*  val auth = Firebase.auth(username, password)
              if(auth != Exception) {
                  startActivity()
              }*/

//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }
    }

    private fun checkIsBlank(firstField: String, secondField: String): Boolean {
        return firstField.isNotBlank() && secondField.isNotBlank()
    }

    private fun openActivity(activity: Class<*>) {
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}

fun View.snackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE)
        .setAction("Fechar") {}
        .show()
}

fun View.hideKeyboard() {
    val imm: InputMethodManager =
        this.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}


