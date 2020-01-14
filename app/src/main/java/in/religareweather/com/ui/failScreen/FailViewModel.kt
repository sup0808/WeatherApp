package `in`.religareweather.com.ui.failScreen

import `in`.religareweather.com.data.repository.AppRepository
import `in`.religareweather.com.ui.loadScreen.LoadViewModel
import mvvm.sample.foods.ui.base.BaseViewModel
import javax.inject.Inject

class FailViewModel  @Inject constructor(appRepository: AppRepository) : BaseViewModel() {
    private val TAG = FailViewModel::class.java.simpleName
}