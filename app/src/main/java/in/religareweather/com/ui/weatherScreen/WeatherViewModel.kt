package `in`.religareweather.com.ui.weatherScreen

import `in`.religareweather.com.data.repository.AppRepository
import `in`.religareweather.com.ui.failScreen.FailViewModel
import mvvm.sample.foods.ui.base.BaseViewModel
import javax.inject.Inject

class WeatherViewModel  @Inject constructor(appRepository: AppRepository) : BaseViewModel() {
    private val TAG = FailViewModel::class.java.simpleName
}