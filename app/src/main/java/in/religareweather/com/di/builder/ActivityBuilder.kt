package `in`.religareweather.com.di.builder

import `in`.religareweather.com.MainActivity
import `in`.religareweather.com.ui.loadScreen.LoaderActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindLoadActivity(): LoaderActivity
}