package com.example.oma.ui.main.menu

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import com.example.oma.R

class SearchMenuBuilder constructor(menu : Menu) {

    private lateinit var searchView: SearchView
    private var menuItem: MenuItem = menu.findItem(R.id.searchView)

    fun getSearchView(query: String?): SearchView {
        searchView = menuItem.actionView as SearchView
        handleQuery(query)
        return searchView
    }

    private fun handleQuery(query: String?) {
        query?.let {
            menuItem.expandActionView()
            searchView.setQuery(query, true)
        }
    }

}