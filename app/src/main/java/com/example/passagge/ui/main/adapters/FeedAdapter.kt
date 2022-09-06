package com.example.passagge.ui.main.adapters

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.passagge.R

class FeedAdapter(): RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    class FeedViewHolder(
        view: View
    ): RecyclerView.ViewHolder(view) {
//        var imageView: ImageView
//        var textView: TextView
//        init {
//            imageView = view.findViewById(R.id.item_product_list__image)
//            textView = view.findViewById(R.id.product_info__name)
//            view.setOnClickListener {
//                val product: ProductListEntity = productList[layoutPosition]
//                val bundle = Bundle()
//                bundle.putSerializable("data", product)
//                view.findNavController().navigate(R.id.productInfoFragment, bundle)
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}