package com.yusril.gardeneetest.data.model


import android.graphics.ColorSpace
import com.google.gson.annotations.SerializedName

data class ResponseWeather(

    @SerializedName("location")
    val location: Location,

    @SerializedName("current")
    val current: Current,

    @SerializedName("wind_mph")
    val wind_mph: Int? = null,

    @SerializedName("wind_kph")
    val wind_kph: Int? = null,

    @SerializedName("wind_degree")
    val wind_degree: Int? = null,

    )
