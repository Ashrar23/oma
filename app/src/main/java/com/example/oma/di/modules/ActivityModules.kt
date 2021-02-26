package com.example.oma.di.modules

import com.example.oma.ui.main.MainModule
import com.example.oma.ui.main.MainActivity
import dagger.Module

import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModules {
     @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity
}