package com.yusril.gardeneetest.data.api

import com.yusril.gardeneetest.data.model.ResponseWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {


    @GET("v1/current.json")
    suspend fun getCurrent(
        @Query("key") apiKey :String,
        @Query("q") q :String,
    ) : Response<ResponseWeather>

}