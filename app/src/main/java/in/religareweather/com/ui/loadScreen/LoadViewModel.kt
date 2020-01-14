package `in`.religareweather.com.ui.loadScreen


import `in`.religareweather.com.data.model.CurrentWeatherResult
import `in`.religareweather.com.data.network.ApiError
import `in`.religareweather.com.data.repository.AppRepository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mvvm.sample.foods.ui.base.BaseViewModel
import javax.inject.Inject

class LoadViewModel @Inject constructor(appRepositoryobj: AppRepository) : BaseViewModel() {
    private val TAG = LoadViewModel::class.java.simpleName
    private val country ="India";

    public val currentWeather: MutableLiveData<CurrentWeatherResult> by lazy {MutableLiveData<CurrentWeatherResult>()   }
    val error : MutableLiveData<ApiError> by lazy {  MutableLiveData<ApiError>() }
    var appRepository: AppRepository?=null

    init{
        this.appRepository =  appRepositoryobj
    }

    fun getCurrentWeather() : LiveData<CurrentWeatherResult>?{
        LoadCurrentWeather()
        return currentWeather;
    }

    private fun LoadCurrentWeather(){ //load Async task
        appRepository!!.GetCurrentWeather(country,{
            Log.e(TAG, "LoadCurrentWeather.success() called with: ${currentWeather.value}")
            currentWeather.postValue(it)
        },{
            Log.e(TAG, "LoadCurrentWeather.error() called with: $it")
            error.value = it
        },{

        }

        ).also { compositeDisposable!!.add(it) }
    }





}