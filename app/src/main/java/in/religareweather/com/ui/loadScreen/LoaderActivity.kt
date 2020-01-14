package `in`.religareweather.com.ui.loadScreen

import `in`.indiaonline.latest.ui.Base.BaseActivity
import `in`.religareweather.com.BR
import `in`.religareweather.com.R
import `in`.religareweather.com.databinding.LoadLayoutBinding
import `in`.religareweather.com.ui.weatherScreen.WeatherActivity
import `in`.religareweather.com.ui.failScreen.FailActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.load_layout.*
import javax.inject.Inject

class LoaderActivity :BaseActivity<LoadLayoutBinding,LoadViewModel>(){

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
        AndroidInjection.inject(this)
        supportActionBar!!.hide()

        context =this

        loadLayoutBinding = getViewDataBinding()

        startLoading()
        val handler = Handler()
        handler.postDelayed({
            loadViewModel.getCurrentWeather()
        }, 2000)

        with(loadViewModel){
            currentWeather.observe(this@LoaderActivity, Observer {

                val intent = Intent(context, WeatherActivity::class.java)
                startActivity(intent)

            })
            error.observe(this@LoaderActivity, Observer {
                val intent = Intent(context,FailActivity::class.java)
                 startActivity(intent)
            })
        }

    }



    fun startLoading(){

        val anim = RotateAnimation(
            0.0f,
            360.0f,
            Animation.RELATIVE_TO_SELF,
            .5f,
            Animation.RELATIVE_TO_SELF,
            .5f
        )
        anim.interpolator = LinearInterpolator()
        anim.repeatCount = Animation.INFINITE
        anim.duration = 1500
        loader.setAnimation(anim)
        loader.startAnimation(anim)


    }
}