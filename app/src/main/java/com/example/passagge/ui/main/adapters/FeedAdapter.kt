package com.example.passagge.ui.main.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.passagge.R
import com.example.passagge.data.repository.PostRepository
import com.example.passagge.data.local.post.room.dao.PostEntity
import kotlinx.coroutines.*

class FeedAdapter constructor(
    context: Context,
    repository: PostRepository
): RecyclerView.Adapter<FeedAdapter.FeedViewHolder>(), ItemTouchHelperAdapter {
    private var postList: List<PostEntity> = ArrayList()
    private val context: Context
    private val repository: PostRepository

    class FeedViewHolder(
        view: View,
        postList: List<PostEntity>
    ): RecyclerView.ViewHolder(view) {
        var imageView: ImageView
        var description: TextView
        var nickname: TextView
        var time: TextView
        init {
            imageView = view.findViewById(R.id.item_post__main_image)
            description = view.findViewById(R.id.item_post__description)
            nickname = view.findViewById(R.id.item_post__nickname)
            time = view.findViewById(R.id.item_post__time)
            /*view.setOnClickListener {
                val post: PostEntity = postList[layoutPosition]
                val bundle = Bundle()
                bundle.putSerializable("data", post)
                view.findNavController().navigate(R.id.productInfoFragment, bundle)
            }
            */
        }
    }

    init {
        this.context = context
        this.repository = repository
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.item_post, parent, false)
        return FeedViewHolder(view, postList)

    }

    fun updateData(newPostList: List<PostEntity>) {
        this.postList = newPostList
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val post: PostEntity = postList[position]

        holder.description.text = post.description
        holder.nickname.text = post.nickname
        holder.time.text = post.time
//        holder.imageView.setImageURI(post.imageUrl?.toUri())
        val drw = Drawable.createFromPath(post.imageUrl)
        holder.imageView.setImageDrawable(drw)

        /*try {
            val ims = context.assets.open(post.imageUrl.toString())
            val drw = Drawable.createFromStream(ims, null)
            holder.imageView.setImageDrawable(drw)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        */
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        TODO("Not yet implemented")
    }

    override fun onItemDismiss(position: Int) {
        CoroutineScope(Dispatchers.Main + SupervisorJob()).launch {
            repository.deletePost(postList[position])
            updateData(repository.getPostList())
        }
    }

}
