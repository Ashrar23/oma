package com.example.oma.data.models

import com.google.gson.annotations.SerializedName

class Envelope<T>(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: T,
    @SerializedName("status")
    val status: String?
)