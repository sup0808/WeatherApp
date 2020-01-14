package `in`.religareweather.com.data.repository

import `in`.religareweather.com.data.model.CurrentWeatherResult
import `in`.religareweather.com.data.model.ForecastWheatherResult
import `in`.religareweather.com.data.network.ApiError
import io.reactivex.disposables.Disposable


interface AppRepository {

    fun GetCurrentWeather(
        country:String,
        success:(CurrentWeatherResult)->Unit,
        failure: (ApiError)->Unit ={},
        treminate :() ->Unit ={}

    ) :Disposable

    fun GetForecastWeather(
        country:String,
        success:(ForecastWheatherResult)->Unit,
        failure: (ApiError)->Unit ={},
        treminate :() ->Unit ={}

    ) :Disposable


}