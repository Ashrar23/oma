package com.example.oma.ui.main

import com.example.oma.ui.main.domain.repositories.ArticlesRepository
import com.example.oma.ui.main.repo.ArticlesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @Binds
    abstract fun provideArticlesRepository(articlesRepositoryImpl: ArticlesRepositoryImpl): ArticlesRepository

}