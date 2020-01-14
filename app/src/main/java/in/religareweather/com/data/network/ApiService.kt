package `in`.religareweather.com.data.network

import `in`.religareweather.com.core.Config
import `in`.religareweather.com.data.model.CurrentWeatherResult
import `in`.religareweather.com.data.model.ForecastWheatherResult
import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather?appid="+Config.AUTH_KEY)
    fun getCurrentWeahter(@Query("q") Country : String): Observable<CurrentWeatherResult>

    @GET("forecast?appid="+Config.AUTH_KEY)
    fun getForecastWeahter(@Query("q") Country : String): Observable<ForecastWheatherResult>

}