package com.example.oma.data.remote

import com.example.oma.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
        val newRequestUrl = request.url().newBuilder()
        newRequestUrl.addQueryParameter(ApiConstants.API_KEY,BuildConfig.API_KEY)
        newRequest.url(newRequestUrl.build())
        return chain.proceed(newRequest.build())
    }
}