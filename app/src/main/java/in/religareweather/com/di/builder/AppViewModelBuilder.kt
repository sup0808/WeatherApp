package `in`.religareweather.com.di.builder


import `in`.religareweather.com.di.qualifier.ViewModelKey
import `in`.religareweather.com.ui.weatherScreen.WeatherViewModel
import `in`.religareweather.com.ui.failScreen.FailViewModel


import `in`.religareweather.com.ui.loadScreen.LoadViewModel
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap



@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(LoadViewModel::class)
    abstract fun bindLoadViewModel(loadViewModel: LoadViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FailViewModel::class)
    abstract fun bindFailreViewModel(failreViewModel: FailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    abstract fun bindWeatherViewModel(weatherViewModel: WeatherViewModel): ViewModel



}