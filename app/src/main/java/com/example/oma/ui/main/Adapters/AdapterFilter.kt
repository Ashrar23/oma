package com.example.oma.ui.main.Adapters

import android.widget.Filter
import com.example.oma.data.models.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdapterFilter @Inject constructor() : Filter() {

    private val originalList: ArrayList<Article> = arrayListOf()
    private val copyOriginalList: ArrayList<Article> = arrayListOf()

    var submitList: ((filter: List<Article>) -> Unit)? = null

    fun withList(data: List<Article>) {
        originalList.clear()
        originalList.addAll(data)
        copyOriginalList.clear()
        copyOriginalList.addAll(data)
    }


    override fun performFiltering(p0: CharSequence?): FilterResults {
        val result = FilterResults()
        if (p0.isNullOrEmpty()) {
            resetOriginalData(result)
        } else {
            searchInTheListsAndFilter(p0, result)
        }
        return result
    }

    private fun searchInTheListsAndFilter(
        p0: CharSequence,
        result: FilterResults
    ) {
        originalList.clear()
        originalList.addAll(copyOriginalList)
        val filtered = originalList.filter { it.title.contains(p0.toString(), true) }
        result.count = filtered.size
        result.values = filtered
    }

    private fun resetOriginalData(result: FilterResults) {
        result.count = copyOriginalList.size
        result.values = copyOriginalList
    }

    override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
        submitList?.let { it(p1?.values as List<Article>) }
    }
}