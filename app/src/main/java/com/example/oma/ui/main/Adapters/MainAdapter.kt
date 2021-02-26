package com.example.oma.ui.main.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.ListAdapter
import com.example.oma.R
import com.example.oma.data.models.Article
import com.example.oma.ui.main.Adapters.Holder.MainViewHolder
import javax.inject.Inject


class MainAdapter @Inject constructor(
    diffCallback: DiffCallBack,
    private val adapterFilter: AdapterFilter
) : ListAdapter<Article, MainViewHolder>(diffCallback), Filterable {

    override fun getFilter(): Filter = adapterFilter

    var onItemClick: ((view: View, position: Int, article: Article) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_news,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(getItem(holder.adapterPosition), onItemClick)
        adapterFilter.submitList = { submitList(it) }
    }

}