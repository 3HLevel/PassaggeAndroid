package com.example.passagge.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.passagge.R
import com.example.passagge.data.api.retrofit.rawg.models.RawgGamesModel
import com.example.passagge.data.api.retrofit.rawg.models.ResultModel
import com.squareup.picasso.Picasso

class SearchAdapter(
    context: Context
): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    private val context: Context
    private var category: List<ResultModel> = ArrayList()

    init {
        this.context = context
    }

    class SearchViewHolder(
        view: View,
    ): RecyclerView.ViewHolder(view) {
        var imageView: ImageView
        var categoryName: TextView

        init {
            imageView = view.findViewById(R.id.category_item__image)
            categoryName = view.findViewById(R.id.category_item__text)
        }
    }

    fun updateData(newCategoryList: List<ResultModel>) {
        this.category = newCategoryList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.item_search_category, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return category.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val category: ResultModel = category[position]

        holder.categoryName.text = category.name
        Picasso.get().load(category.background_image).into(holder.imageView)
    }
}