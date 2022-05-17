package com.example.examenalberto.Movi

import com.google.gson.annotations.SerializedName

data class Result_(
    @SerializedName("adult") var adult: String,
    @SerializedName("backdrop_path") var backdrop_path: String,
    @SerializedName("genre_ids") var genre_ids: ArrayList<Int>,
    @SerializedName("id") var id: Int,
    @SerializedName("original_language") var original_language: String,
    @SerializedName("original_title") var original_title: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("popularity") var popularity: Double,
    @SerializedName("poster_path") var poster_path: String,
    @SerializedName("release_date") var release_date: String,
    @SerializedName("video") var video: Boolean,
    @SerializedName("vote_average") var vote_average: Double,
    @SerializedName("vote_count") var vote_count: Int

)