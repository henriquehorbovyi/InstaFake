package io.henrikhorbovyi.instafake.ui.custom.stories

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import io.henrikhorbovyi.instafake.R
import io.henrikhorbovyi.instafake.entity.Story

class StoriesView @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    private val defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var storiesRecyclerView: RecyclerView? = null
    private val storiesAdapter: StoriesAdapter by lazy {
        StoriesAdapter()
    }

    init {
        val view = View.inflate(context, R.layout.custom_view_stories, this)
        storiesRecyclerView = view.findViewById<RecyclerView>(R.id.customStoriesView)
        storiesRecyclerView?.adapter = storiesAdapter
    }

    fun loadStories(stories: List<Story>) {
        stories.toMutableList().apply {
            add(0, Story(userName = "Seu story", "https://scontent-gru2-2.cdninstagram.com/v/t51.2885-19/s150x150/108313686_941178686294343_7279831360754606688_n.jpg?_nc_ht=scontent-gru2-2.cdninstagram.com&_nc_ohc=eRLZ_-nlwi0AX9fSxFM&oh=d368987121b6e6daec6c5d81e261de20&oe=5F9F584A"))
            storiesAdapter.submitList(this)
        }
    }
}