package com.example.examenalberto.Movi

import com.google.gson.annotations.SerializedName

import kotlin.collections.ArrayList

data class MoviResponse(
    @SerializedName("Dates") var dates: Dates,
    @SerializedName("page") var pages: Int,
    @SerializedName("results") var results: List <Result_>,
    @SerializedName("total_pages") var total_pages: Int,
    @SerializedName("total_results") var total_results: Int
)
