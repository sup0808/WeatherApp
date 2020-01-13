package `in`.religareweather.com.di.builder


import `in`.religareweather.com.di.qualifier.ViewModelKey
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mvvm.sample.foods.ui.LoadViewModel


@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(LoadViewModel::class)
    abstract fun bindLoadViewModel(homeViewModel: LoadViewModel): ViewModel



}