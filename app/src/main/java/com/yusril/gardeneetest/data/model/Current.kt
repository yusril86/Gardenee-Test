package com.yusril.gardeneetest.data.model

import com.google.gson.annotations.SerializedName

data class Current(

    @SerializedName("temp_c")
    val temp_c: Double? = null,

    @SerializedName("temp_f")
    val temp_f: Double? = null,
)
