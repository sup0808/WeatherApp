package mvvm.sample.foods.di.builder

import `in`.religareweather.com.ui.failScreen.FailFragment
import `in`.religareweather.com.ui.loadScreen.LoaderFragment
import `in`.religareweather.com.ui.weatherScreen.WeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class LoadScreenFragmentProviders{
    @ContributesAndroidInjector
    abstract fun provideLoadFragment(): LoaderFragment

    @ContributesAndroidInjector
    abstract fun provideFailFragment(): FailFragment


    @ContributesAndroidInjector
    abstract fun provideSuccessFragment(): WeatherFragment

}