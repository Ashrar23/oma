package com.example.oma.ui.main.Adapters.Holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.oma.R
import com.example.oma.data.models.Article
import kotlinx.android.synthetic.main.item_news.view.*

class MainViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
    fun bindData(
        item: Article?,
        onItemClick: ((view: View, position: Int, article: Article) -> Unit)?
    ) {
        item?.let {
            initText(it)
            //loadImage(it)
            handleClick(onItemClick, it)
        }
    }

    private fun initText(it: Article) {
        itemView.textTitle.setText(it.title)
        itemView.textSubTitle.setText(it.abstract)
    }

   /* private fun loadImage(it: Article) {
        Glide.with(itemView.context)
        .load(it.media.get(0).url)
        .placeholder(R.drawable.user)
        .into(itemView.imageThumb)
    }*/

    private fun handleClick(
        onItemClick: ((view: View, position: Int, article: Article) -> Unit)?,
        it: Article
    ) {
        itemView.setOnClickListener { view ->
            onItemClick?.let { it1 ->
                it1(
                    itemView,
                    adapterPosition,
                    it
                )
            }
        }
    }
}