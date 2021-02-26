package com.example.oma.ui.main.domain

import com.example.oma.data.models.Article
import com.example.oma.data.remote.rxjava.SchedulerProvider
import com.example.oma.ui.main.domain.repositories.ArticlesRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(private val articlesRepository: ArticlesRepository, private val schedulerProvider: SchedulerProvider) {

    fun getArticles(): Flowable<List<Article>> {
        return articlesRepository
            .getArticles("world")
            .compose(schedulerProvider.ioToMainFlowableScheduler())
    }
}