package com.example.oma.ui.main.domain.repositories

import com.example.oma.data.models.Article
import io.reactivex.Flowable

interface ArticlesRepository {

    fun getArticles(type: String): Flowable<List<Article>>

}