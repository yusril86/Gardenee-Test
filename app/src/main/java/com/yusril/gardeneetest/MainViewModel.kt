package com.yusril.gardeneetest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusril.gardeneetest.data.api.ApiConfig
import com.yusril.gardeneetest.data.model.ResponseWeather
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainViewModel : ViewModel() {
    private val mCurrent = MutableLiveData<ResponseWeather?>()
    private val mErrorMessage = MutableLiveData<String>()
//    private val apiKey = "ff9f895b2e884d6680530135202710"

    fun fetchCurrent(apiKey: String, query: String) {
        viewModelScope.launch {
            try {
                val response = ApiConfig.API_SERVICE.getCurrent(apiKey, query)

                if (response.isSuccessful) {
                    mCurrent.postValue(response.body())
                } else {
                    val errorMessage =
                        try {
                            val responseError = JSONObject(response.errorBody()!!.string())
                            val objResponseError = responseError.getJSONObject("error")
                                objResponseError.getString("message")


                        } catch (e: Exception) {
                            e.message ?: ""
                        }
                    mErrorMessage.value = errorMessage.toString()
                }
            } catch (e: Exception) {
                mCurrent.postValue(null)
            }
        }
    }

    fun getCurrent(): LiveData<ResponseWeather?> {
        return mCurrent
    }

    fun onError(): LiveData<String> {
        return mErrorMessage
    }


}