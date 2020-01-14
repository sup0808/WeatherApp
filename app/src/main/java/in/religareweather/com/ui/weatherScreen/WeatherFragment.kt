package `in`.religareweather.com.ui.weatherScreen

import `in`.religareweather.com.R
import `in`.religareweather.com.data.model.CurrentWeatherResult
import `in`.religareweather.com.data.model.ForecastWheatherResult
import `in`.religareweather.com.data.model.forecastdata
import `in`.religareweather.com.databinding.SuccessLayoutBinding
import `in`.religareweather.com.ui.loadScreen.LoadViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.success_layout.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.HashMap


class WeatherFragment : DaggerFragment(){


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val adapter : WheatherAdapter by lazy { WheatherAdapter(activity!!,arrayListOf()) }

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

                loadCurrentData(it)

            })
            error.observe(this@WeatherFragment, Observer {
               Toast.makeText(context,"${it?.message}", android.widget.Toast.LENGTH_LONG).show()
            })
        }

        with(loadViewModel){
            forecastWeather.observe(this@WeatherFragment, Observer {

                var data = it;
                handleForeCastData(it)

            })
            error.observe(this@WeatherFragment, Observer {
                Toast.makeText(context,"${it?.message}", android.widget.Toast.LENGTH_LONG).show()
            })
        }




    }

    fun loadCurrentData(data: CurrentWeatherResult){
        current_temp_txt.text =""+ Math.round(data.main.temp) + resources.getString(R.string.Celsius)
        max_min_temp_txt.text =
            ""+ Math.round(data.main.temp_max )+
                    resources.getString(R.string.Celsius)  +"/"+ Math.round(data.main.temp_min) +
                    resources.getString(R.string.Celsius)

        current_temp_location_txt.text = data.name
    }

    private fun initView(data: ArrayList<forecastdata>?) {
        forecast_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        forecast_recycler.adapter = adapter

        if (data!!.isNotEmpty()) {
            adapter.clear()
            adapter.add(data)

        }else{
            Toast.makeText(context, context?.getString(R.string.empty_list), android.widget.Toast.LENGTH_LONG).show()
        }
    }


    fun handleForeCastData(data: ForecastWheatherResult){
        try {
            var forecastData = data.list

            val filterData = HashMap<String, forecastdata>()
            for (listadata in forecastData) {
                var date = listadata.dt_txt
                var key = date!!.substring(0, date.indexOf(' '))

                if (!filterData.contains(key)) {
                    filterData.put(
                        key, forecastdata(
                            listadata.main.temp_min,
                            listadata.main.temp_max, getDayName(key), key
                        )
                    )
                }

            }

            val valueList = ArrayList(filterData.values)
            initView(valueList)
        }
        catch (e:Exception){
            e.printStackTrace()
        }

    }

    fun getDayName( date: String): String{
        val format1 = SimpleDateFormat("yyyy-MM-dd")
        val dt1: Date = format1.parse(date)

        val c: Calendar = Calendar.getInstance()
        c.setTime(dt1)

        val dayOfWeek: Int = c.get(Calendar.DAY_OF_WEEK)

        var days = arrayOf( "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" )

        var day = days[dayOfWeek-1];
        Log.e("day Name:: ",day)
        return  day
    }

}