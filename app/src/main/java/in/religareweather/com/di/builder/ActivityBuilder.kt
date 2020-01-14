package `in`.religareweather.com.di.builder


import `in`.religareweather.com.ui.LoadScreen


import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvvm.sample.foods.di.builder.LoadScreenFragmentProviders


@Module
abstract class ActivityBuilder {



    @ContributesAndroidInjector(modules = [LoadScreenFragmentProviders::class])
    abstract fun bindLoadScreen(): LoadScreen
}