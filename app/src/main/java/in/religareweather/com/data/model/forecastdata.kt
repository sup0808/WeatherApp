package `in`.religareweather.com.data.model

import com.google.gson.annotations.SerializedName

data class forecastdata(
    @SerializedName("data")
    var min_temp : Double,
    var max_temp : Double,
    var day :String ?=null,
    var date : String ?= null
)