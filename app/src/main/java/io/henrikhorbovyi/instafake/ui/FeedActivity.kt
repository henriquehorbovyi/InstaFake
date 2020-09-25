package io.henrikhorbovyi.instafake.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.henrikhorbovyi.instafake.databinding.ActivityFeedBinding
import io.henrikhorbovyi.instafake.entity.Story

class FeedActivity : AppCompatActivity() {

    private val binding: ActivityFeedBinding by lazy{
        ActivityFeedBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val stories = listOf(
            Story("lukspedrosa"),
            Story("testerr"),
            Story("jorginho12"),
            Story("maicocoo"),
            Story("joceline"),
            Story("johnfrav"),
            Story("dhuauhsd")
        )

        binding.feedStoriesView.loadStories(stories)

//        binding.signOutText.setOnClickListener {
//            FirebaseAuth.getInstance().signOut()
//            launchActivity(SignInActivity::class, true)
//        }
    }
}