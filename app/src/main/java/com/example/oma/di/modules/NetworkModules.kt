package com.example.oma.di.modules

import com.example.oma.BuildConfig
import com.example.oma.data.remote.ApiInterface
import com.example.oma.data.remote.HeaderInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModules {

    @Provides
    @Singleton
    fun provideOkHttp(headerInterceptor: HeaderInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(headerInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttp: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(okHttp)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideAPInterface(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

}