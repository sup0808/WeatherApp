package `in`.religareweather.com.ui


import `in`.indiaonline.latest.ui.Base.BaseActivity
import `in`.religareweather.com.BR
import `in`.religareweather.com.R
import `in`.religareweather.com.databinding.LoadHomeBinding
import `in`.religareweather.com.databinding.LoadLayoutBinding
import `in`.religareweather.com.ui.failScreen.FailFragment
import `in`.religareweather.com.ui.loadScreen.LoadViewModel
import `in`.religareweather.com.ui.loadScreen.LoaderFragment
import `in`.religareweather.com.ui.weatherScreen.WeatherFragment
import android.content.Context
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject


class LoadScreen : BaseActivity<LoadHomeBinding,LoadViewModel>() {

    private val TAG = LoadScreen::class.java.simpleName


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

    override fun onBackPressed() {

        val f: Fragment? = supportFragmentManager.findFragmentByTag("Weather")
        val f2: Fragment? = supportFragmentManager.findFragmentByTag("Fail")
        if (f is WeatherFragment) { //the fragment on which you want to handle your back press
            Log.i("BACK PRESSED", "BACK PRESSED")
        }
       else  if (f2 is FailFragment) { //the fragment on which you want to handle your back press
            Log.i("BACK PRESSED", "BACK PRESSED")
        }else {
            super.onBackPressed()
        }
    }



}
