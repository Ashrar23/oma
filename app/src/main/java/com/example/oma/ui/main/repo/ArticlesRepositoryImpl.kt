package com.example.oma.ui.main.repo

import com.example.oma.data.models.Article
import com.example.oma.data.remote.ApiInterface
import com.example.oma.ui.main.domain.repositories.ArticlesRepository
import io.reactivex.Flowable
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface) :
    ArticlesRepository {

    override fun getArticles(type: String): Flowable<List<Article>> =
        apiInterface.getPoplarArticles(type).map { it.results }
}