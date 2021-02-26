package com.example.oma.di.modules

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oma.application.BaseApplication
import com.example.oma.data.remote.rxjava.AppSchedulerProvider
import com.example.oma.data.remote.rxjava.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModules {


    @Provides
    @Singleton
    fun provideContext(application: BaseApplication): Context {
        return application
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @Provides
    @Singleton
    fun provideSchedulerProvider(schedulerProvider: AppSchedulerProvider): SchedulerProvider {
        return schedulerProvider
    }

}