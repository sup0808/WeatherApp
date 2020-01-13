package `in`.religareweather.com.data.network

import io.reactivex.Observable

import retrofit2.http.GET

interface ApiService {

    @GET("api/")
    fun getHome(
    ): Observable<FoodDto>


}