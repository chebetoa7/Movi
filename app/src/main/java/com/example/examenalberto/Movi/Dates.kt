package com.example.examenalberto.Movi

import com.google.gson.annotations.SerializedName

data class Dates (
    @SerializedName("maximum") var maximo: String,
    @SerializedName("minimum") var minimo: List<String>

     )