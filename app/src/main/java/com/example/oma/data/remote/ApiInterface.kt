package com.example.oma.data.remote

import com.example.oma.data.models.Article
import com.example.oma.data.models.Envelope
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET(ApiConstants.API_MOST_POP)
    fun getPoplarArticles(@Path("type") type: String): Flowable<Envelope<List<Article>>>

}