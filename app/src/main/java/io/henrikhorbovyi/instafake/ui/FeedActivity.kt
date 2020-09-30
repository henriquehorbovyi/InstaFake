package io.henrikhorbovyi.instafake.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import io.henrikhorbovyi.instafake.databinding.ActivityFeedBinding
import io.henrikhorbovyi.instafake.entity.Mocks
import io.henrikhorbovyi.instafake.entity.Story
import io.henrikhorbovyi.instafake.ui.adapter.PostsAdapter

class FeedActivity : AppCompatActivity() {

    private val binding: ActivityFeedBinding by lazy{
        ActivityFeedBinding.inflate(layoutInflater)
    }

    private val postsAdapter: PostsAdapter by lazy { PostsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.feedPosts.adapter = postsAdapter
        postsAdapter.submitList(Mocks.posts)

        binding.feedStoriesView.loadStories(Mocks.stories)
    }
}