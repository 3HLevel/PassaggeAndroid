package com.example.passagge.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.passagge.R
import com.example.passagge.data.api.PostRepository
import com.example.passagge.data.local.post.room.dao.PostEntity
import kotlinx.coroutines.*
import javax.inject.Inject

class FeedAdapter constructor(
    postList: List<PostEntity>,
    context: Context,
    repository: PostRepository
): RecyclerView.Adapter<FeedAdapter.FeedViewHolder>(), ItemTouchHelperAdapter {
    private var postList: MutableList<PostEntity>
    private val context: Context
    private val repository: PostRepository

    init {
        this.postList = postList.toMutableList()
        this.context = context
        this.repository = repository
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.item_post, parent, false)
        return FeedViewHolder(view, postList)

    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val post: PostEntity = postList[position]

        holder.description.text = post.description
        holder.nickname.text = post.nickname
        holder.time.text = post.time

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

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        TODO("Not yet implemented")
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onItemDismiss(position: Int) {
        GlobalScope.launch {
            repository.deletePost(postList[position])
            postList.removeAt(position)
        }
    }

}
