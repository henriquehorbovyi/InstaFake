package io.henrikhorbovyi.instafake.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.firebase.auth.FirebaseAuth
import io.henrikhorbovyi.instafake.FeedActivity
import io.henrikhorbovyi.instafake.databinding.ActivitySignInBinding
import io.henrikhorbovyi.instafake.util.hideKeyboard
import io.henrikhorbovyi.instafake.util.launchActivity
import io.henrikhorbovyi.instafake.util.snackbar

class SignInActivity : AppCompatActivity() {

    private val binding: ActivitySignInBinding by lazy {
        ActivitySignInBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null)
            launchActivity(FeedActivity::class, finishActivity = true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signInUserName.doOnTextChanged { text, _, _, _ ->
            binding.signInButton.isEnabled =
                checkIsBlank(text.toString(), binding.signInPassword.text.toString())
        }

        binding.signInPassword.doOnTextChanged { text, _, _, _ ->
            binding.signInButton.isEnabled =
                checkIsBlank(text.toString(), binding.signInUserName.text.toString())
        }

        binding.signInButton.setOnClickListener { btnView ->
            btnView.hideKeyboard()
            val username = binding.signInUserName.text.toString()
            val password = binding.signInPassword.text.toString()

            val authTask = FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
            authTask.addOnSuccessListener {
                launchActivity(FeedActivity::class, finishActivity = true)
            }
            authTask.addOnFailureListener {
                btnView.snackbar("Vacilão, tá errado!")
            }

        }
    }

    private fun checkIsBlank(firstField: String, secondField: String): Boolean {
        return firstField.isNotBlank() && secondField.isNotBlank()
    }
}