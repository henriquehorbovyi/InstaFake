package io.henrikhorbovyi.instafake.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import io.henrikhorbovyi.instafake.databinding.ActivityFeedBinding
import io.henrikhorbovyi.instafake.ui.SignInActivity
import io.henrikhorbovyi.instafake.ui.custom.stories.Story
import io.henrikhorbovyi.instafake.util.launchActivity

class FeedActivity : AppCompatActivity() {

    private val binding: ActivityFeedBinding by lazy{
        ActivityFeedBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val stories = listOf(
            Story("TESTE1"),
            Story("TESTE2"),
            Story("TESTE3"),
            Story("TESTE4"),
            Story("TESTE5"),
            Story("TESTE6"),
            Story("TESTE7")
        )

        binding.feedStoriesView.loadStories(stories)

//        binding.signOutText.setOnClickListener {
//            FirebaseAuth.getInstance().signOut()
//            launchActivity(SignInActivity::class, true)
//        }
    }
}