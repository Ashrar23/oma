package com.example.oma.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.oma.data.models.Article
import com.example.oma.ui.main.domain.GetArticlesUseCase
import com.example.oma.data.models.Result
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val getArticlesUseCase: GetArticlesUseCase
): ViewModel() {

    private var articlesLiveData: MutableLiveData<Result>? = null
    private var query: String? = null

    private var filterValue = "1"

    fun getArticles(): LiveData<Result> {
        if (articlesLiveData != null) {
            return articlesLiveData as LiveData<Result>
        }
        return MutableLiveData<Result>().apply {
            getArticleFromApi(filterValue)
            articlesLiveData = this
        }
    }


    private fun MutableLiveData<Result>.getArticleFromApi(timeLong: String): MutableLiveData<Result> {
        postValue(Result.Loading)
        compositeDisposable.add(getArticlesUseCase.getArticles().subscribe({
            postValue(
                Result.Success(it)
            )
        }, { postValue(Result.Error(it)) }))
        return this
    }

    fun getQuery(): String? = query

    fun refresh(number: String, forceRefresh: Boolean = false) {
        if (!forceRefresh) if (filterValue == number) return
        filterValue = number
        articlesLiveData?.postValue(Result.Success(arrayListOf<Article>()))
        articlesLiveData?.getArticleFromApi(number)
    }

    fun onRefresh() {
        refresh(filterValue, true)
    }
}