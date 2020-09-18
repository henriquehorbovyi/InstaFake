package io.henrikhorbovyi.instafake.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.firebase.auth.FirebaseAuth
import io.henrikhorbovyi.instafake.FeedActivity
import io.henrikhorbovyi.instafake.databinding.ActivitySignInBinding
import io.henrikhorbovyi.instafake.util.hideKeyBoard
import io.henrikhorbovyi.instafake.util.launchActivity
import io.henrikhorbovyi.instafake.util.snackbar

class SignInActivity : AppCompatActivity() {

    private var isSignInButtonEnabled: Boolean = false
    private val binding: ActivitySignInBinding by lazy {
        ActivitySignInBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null)
            launchActivity(FeedActivity::class, true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signInInputUsername.doOnTextChanged { text, _, _, _ ->
            binding.signInButton.isEnabled =
            checkIsNullOrBlank(text.toString(), binding.signInInputPassword.text.toString())
        }

        binding.signInInputPassword.doOnTextChanged { text, _, _, _ ->
            binding.signInButton.isEnabled =
            checkIsNullOrBlank(text.toString(), binding.signInInputUsername.text.toString())
        }

        binding.signInButton.setOnClickListener { btnView ->
            btnView.hideKeyBoard()
            val username = binding.signInInputUsername.text.toString()
            val password = binding.signInInputPassword.text.toString()

            val authTask = FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
            authTask.addOnSuccessListener {
                launchActivity(FeedActivity::class, finishActivity = true)
            }

            authTask.addOnFailureListener {
                btnView.snackbar(binding.signInButton, "Vacilão, usuário ou senha incorretos!")
            }

            /*val auth = Firebase.auth(username, password)
            if (auth != Exception) {

                startActivity()
            }*/
        }
    }

    private fun checkIsNullOrBlank(username: String, password: String): Boolean {
            return !username.isNullOrBlank() && !password.isNullOrBlank()
    }
}