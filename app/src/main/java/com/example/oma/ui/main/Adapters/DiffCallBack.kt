package com.example.oma.ui.main.Adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.oma.data.models.Article
import javax.inject.Inject

class DiffCallBack @Inject constructor() : DiffUtil.ItemCallback<Article>(){
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

}