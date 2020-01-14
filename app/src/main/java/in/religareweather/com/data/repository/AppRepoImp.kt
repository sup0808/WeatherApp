package `in`.religareweather.com.data.repository

import `in`.religareweather.com.core.Config
import `in`.religareweather.com.data.model.CurrentWeatherResult
import `in`.religareweather.com.data.model.ForecastWheatherResult
import `in`.religareweather.com.data.network.ApiDisposable
import `in`.religareweather.com.data.network.ApiError
import `in`.religareweather.com.data.network.ApiService
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class AppRepoImp(
    val apiService: ApiService

) : AppRepository {

    private val TAG = AppRepoImp::class.java.simpleName

    override fun GetCurrentWeather(
        country: String,
        success: (CurrentWeatherResult) -> Unit,
        failure: (ApiError) -> Unit,
        treminate: () -> Unit
    ): Disposable {

        return apiService.getCurrentWeahter(country,Config.AUTH_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate(treminate)
            .subscribeWith(ApiDisposable(
                success = {
                    success(it)
                },
                failure = failure
            )

            )
    }

    override fun GetForecastWeather(
        country: String,
        success: (ForecastWheatherResult) -> Unit,
        failure: (ApiError) -> Unit,
        treminate: () -> Unit
    ): Disposable {

        return apiService.getForecastWeahter(country,Config.AUTH_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate(treminate)
            .subscribeWith(ApiDisposable(
                success = {
                    success(it)
                },
                failure = failure
            )

            )
    }


}