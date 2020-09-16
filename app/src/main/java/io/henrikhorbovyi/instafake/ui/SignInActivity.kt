package io.henrikhorbovyi.instafake.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import io.henrikhorbovyi.instafake.R
import io.henrikhorbovyi.instafake.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private var isSignInButtonEnabled: Boolean = false
    private val binding: ActivitySignInBinding by lazy {
        ActivitySignInBinding.inflate(layoutInflater)
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

    }

    fun checkIsNullOrBlank(username: String, password: String): Boolean {
            return !username.isNullOrBlank() && !password.isNullOrBlank()
    }
}