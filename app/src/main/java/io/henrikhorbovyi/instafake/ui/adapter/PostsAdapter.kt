package io.henrikhorbovyi.instafake.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.google.firebase.auth.FirebaseAuth
import io.henrikhorbovyi.instafake.Firebase.Firestore
import io.henrikhorbovyi.instafake.R
import io.henrikhorbovyi.instafake.entity.Post


class PostsAdapter : ListAdapter<Post, PostsAdapter.PostViewHolder>(PostsDiff){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class PostViewHolder(
        private val postView: View
    ) : RecyclerView.ViewHolder(postView) {

        private var loggedUserPic: String = ""

        init {

            val id: String by lazy { FirebaseAuth.getInstance().currentUser?.uid ?: "" }

            Firestore.getUserById(id){
                loggedUserPic = it.picture ?: ""
                println("AAAAAAAAAAAA $loggedUserPic")
            }
        }

        fun bind(post: Post) {

            val actionLike = postView.findViewById<ImageView>(R.id.postActionLike)
            val actionComment = postView.findViewById<ImageView>(R.id.postActionComment)
            val actionSend = postView.findViewById<ImageView>(R.id.postActionSend)
            val actionSave = postView.findViewById<ImageView>(R.id.postActionSave)
            val actionOptions = postView.findViewById<TextView>(R.id.postActionOptions)

            val userPicture = postView.findViewById<ImageView>(R.id.postUserPicture)
            val userName = postView.findViewById<TextView>(R.id.postUserName)
            val location = postView.findViewById<TextView>(R.id.postLocation)
            val picture = postView.findViewById<ImageView>(R.id.postPicture)

            val likedByLayout = postView.findViewById<View>(R.id.postLikedBy)
            val lastLikedPicture = postView.findViewById<ImageView>(R.id.postLastUserPicture)
            val lastLikedName = postView.findViewById<TextView>(R.id.postLastUserName)

            val descriptionLayout = postView.findViewById<View>(R.id.postDescriptionLayout)
            val description = postView.findViewById<TextView>(R.id.postDescription)

            val loggedUserPicture = postView.findViewById<ImageView>(R.id.postLoggedUserPicture)
            val seeMoreComments = postView.findViewById<TextView>(R.id.postSeeComments)

            //val actionProfilePicture = postView.findViewById<Item>(R.id.actionProfile)

            userName.text = post.userName

            location.apply {
                isVisible = post.location.isNotBlank()
                text = post.location
            }

            userPicture.load(post.profilePicture){
                transformations(CircleCropTransformation())
            }
            picture.load(post.picture)

            descriptionLayout.isVisible = post.description.isNotBlank()
            description.text = post.description

            loggedUserPicture.load(loggedUserPic) {
                transformations(CircleCropTransformation())
            }

//            actionProfilePicture.load(loggerUserPic) {
//                transformations(CircleCropTransformation())
//            }
        }
    }
}

private object PostsDiff: DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}

