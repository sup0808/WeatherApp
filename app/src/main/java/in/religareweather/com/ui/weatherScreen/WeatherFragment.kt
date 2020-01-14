package `in`.religareweather.com.ui.weatherScreen

import `in`.religareweather.com.R
import `in`.religareweather.com.databinding.FailLayoutBinding
import `in`.religareweather.com.databinding.SuccessLayoutBinding
import `in`.religareweather.com.ui.loadScreen.LoadViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fail_layout.*
import kotlinx.android.synthetic.main.success_layout.*
import javax.inject.Inject

class WeatherFragment : DaggerFragment(){


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val loadViewModel : LoadViewModel by lazy {  ViewModelProviders.of(activity!!,viewModelFactory)[LoadViewModel::class.java]}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var failLayoutBinding: SuccessLayoutBinding =
            SuccessLayoutBinding.inflate(inflater, container, false)
        failLayoutBinding.setLifecycleOwner(this)
        return failLayoutBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(loadViewModel){
            currentWeather.observe(this@WeatherFragment, Observer {

                var data = it;

                current_temp_txt.text =""+ Math.round(data.main.temp) + resources.getString(R.string.Celsius)
                max_min_temp_txt.text =
                    ""+ Math.round(data.main.temp_max )+
                            resources.getString(R.string.Celsius)  +"/"+ Math.round(data.main.temp_min) +
                            resources.getString(R.string.Celsius)

                current_temp_location_txt.text = data.name



            })
            error.observe(this@WeatherFragment, Observer {
               Toast.makeText(context,"${it?.message}", android.widget.Toast.LENGTH_LONG).show()
            })
        }


    }


}