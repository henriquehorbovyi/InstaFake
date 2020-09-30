package io.henrikhorbovyi.instafake.ui.custom.stories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import io.henrikhorbovyi.instafake.R
import io.henrikhorbovyi.instafake.entity.Story

class StoriesAdapter : ListAdapter<Story, StoriesAdapter.StoriesViewHolder>(StoriesDiff){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val storyView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return StoriesViewHolder(storyView)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class StoriesViewHolder(
        private val storyView: View
    ) : RecyclerView.ViewHolder(storyView){

        fun bind(story: Story){
            val picture = storyView.findViewById<ImageView>(R.id.itemStoryUserPicture)
            val name = storyView.findViewById<TextView>(R.id.itemStoryUserName)

            picture.load(story.picture){
                transformations(CircleCropTransformation())
            }
            name.text = story.userName
        }
    }

    object StoriesDiff : DiffUtil.ItemCallback<Story>(){
        override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem.userName == newItem.userName
        }

        override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem == newItem
        }

    }
}