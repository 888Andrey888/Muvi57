package com.example.muvi57.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MuviApi {
    @GET(".")
    fun getMuvi(
        @Query("t") name: String,
        @Query("apikey") key: String = "7285bd11"
    ): Call<MuviModel>
}