package `in`.religareweather.com.ui.weatherScreen

import `in`.indiaonline.latest.ui.Base.BaseActivity
import `in`.religareweather.com.BR
import `in`.religareweather.com.R
import `in`.religareweather.com.databinding.SuccessLayoutBinding
import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import javax.inject.Inject

class WeatherActivity : BaseActivity<SuccessLayoutBinding,WeatherViewModel>(){

    private val TAG = WeatherActivity::class.java.simpleName

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit  var weatherViewModel: WeatherViewModel
    lateinit var successLayoutBinding: SuccessLayoutBinding

    var context: Context?=null

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.success_layout
    }

    override fun getViewModel(): WeatherViewModel {
        weatherViewModel = ViewModelProviders.of(this,viewModelFactory)[WeatherViewModel::class.java]
        return weatherViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        supportActionBar!!.hide()

        successLayoutBinding = getViewDataBinding()

    }


}