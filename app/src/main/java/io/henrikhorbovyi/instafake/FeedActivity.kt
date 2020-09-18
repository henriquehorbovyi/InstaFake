package io.henrikhorbovyi.instafake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import io.henrikhorbovyi.instafake.databinding.ActivityFeedBinding
import io.henrikhorbovyi.instafake.databinding.ActivitySignInBinding
import io.henrikhorbovyi.instafake.ui.SignInActivity
import io.henrikhorbovyi.instafake.util.launchActivity

class FeedActivity : AppCompatActivity() {

    private val binding: ActivityFeedBinding by lazy {
        ActivityFeedBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signOutText.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            launchActivity(SignInActivity::class, true)
        }
    }
}