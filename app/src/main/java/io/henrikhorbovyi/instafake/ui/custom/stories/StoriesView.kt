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

    fun loadStories(stories: List<Story>){
        storiesAdapter.submitList(stories)
    }

}