package com.example.oma.di.component

import com.example.oma.application.BaseApplication
import com.example.oma.di.modules.ActivityModules
import com.example.oma.di.modules.ApplicationModules
import com.example.oma.di.modules.NetworkModules
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.AndroidInjector.Builder
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModules::class,
        ActivityModules::class,
        NetworkModules::class
    ]
)
interface ApplicationComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication>()

}