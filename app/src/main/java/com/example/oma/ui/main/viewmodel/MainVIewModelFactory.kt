package com.example.oma.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.oma.ui.main.domain.GetArticlesUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainVIewModelFactory @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(compositeDisposable, getArticlesUseCase) as T

    }

}