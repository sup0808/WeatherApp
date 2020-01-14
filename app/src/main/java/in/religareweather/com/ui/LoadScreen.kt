package `in`.religareweather.com.ui


import `in`.indiaonline.latest.ui.Base.BaseActivity
import `in`.religareweather.com.BR
import `in`.religareweather.com.R
import `in`.religareweather.com.databinding.LoadHomeBinding
import `in`.religareweather.com.databinding.LoadLayoutBinding
import `in`.religareweather.com.ui.failScreen.FailActivity
import `in`.religareweather.com.ui.failScreen.FailFragment
import `in`.religareweather.com.ui.loadScreen.LoadViewModel
import `in`.religareweather.com.ui.loadScreen.LoaderActivity
import `in`.religareweather.com.ui.loadScreen.LoaderFragment
import `in`.religareweather.com.ui.weatherScreen.WeatherActivity
import `in`.religareweather.com.ui.weatherScreen.WeatherFragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler

import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class LoadScreen : BaseActivity<LoadHomeBinding,LoadViewModel>() {

    private val TAG = LoaderActivity::class.java.simpleName


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit  var loadViewModel: LoadViewModel
    lateinit var loadLayoutBinding: LoadLayoutBinding

    var context: Context?=null


    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.load_layout
    }

    override fun getViewModel(): LoadViewModel {
        loadViewModel = ViewModelProviders.of(this,viewModelFactory)[LoadViewModel::class.java]
        return loadViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.load_home)
        supportActionBar!!.hide()

        supportFragmentManager.beginTransaction().replace(R.id.container,LoaderFragment()).commit()



    }



}
