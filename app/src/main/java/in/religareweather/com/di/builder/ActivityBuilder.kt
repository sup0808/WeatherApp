package `in`.religareweather.com.di.builder


import `in`.religareweather.com.ui.LoadScreen
import `in`.religareweather.com.ui.failScreen.FailActivity


import `in`.religareweather.com.ui.loadScreen.LoaderActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvvm.sample.foods.di.builder.LoadScreenFragmentProviders


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindLoadActivity(): LoaderActivity


    @ContributesAndroidInjector
    abstract fun bindFailureActivity(): FailActivity


    @ContributesAndroidInjector(modules = [LoadScreenFragmentProviders::class])
    abstract fun bindLoadScreen(): LoadScreen
}