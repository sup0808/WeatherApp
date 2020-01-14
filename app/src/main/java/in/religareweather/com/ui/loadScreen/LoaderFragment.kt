package `in`.religareweather.com.ui.loadScreen

import `in`.religareweather.com.R
import `in`.religareweather.com.databinding.LoadLayoutBinding
import `in`.religareweather.com.databinding.LoadLayoutBinding.inflate
import `in`.religareweather.com.ui.failScreen.FailFragment
import `in`.religareweather.com.ui.weatherScreen.WeatherFragment
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.load_layout.*
import javax.inject.Inject


class LoaderFragment : DaggerFragment(){

    private val TAG : String = LoaderFragment::class.java.simpleName


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val loadViewModel : LoadViewModel  by lazy {  ViewModelProviders.of(activity!!,viewModelFactory)[LoadViewModel::class.java]}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : LoadLayoutBinding = inflate(inflater,  container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startLoading()



        val handler = Handler()
        handler.postDelayed({
            loadViewModel.getCurrentWeather()
        }, 2000)

        with(loadViewModel) {
            currentWeather.observe(this@LoaderFragment, Observer {

                activity!!.supportFragmentManager.beginTransaction().replace(R.id.container,WeatherFragment()).addToBackStack(null).commit()


            })
            error.observe(this@LoaderFragment, Observer {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.container,FailFragment()).addToBackStack(null).commit()


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
