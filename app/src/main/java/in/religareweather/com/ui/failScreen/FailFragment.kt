package `in`.religareweather.com.ui.failScreen

import `in`.religareweather.com.R
import `in`.religareweather.com.databinding.FailLayoutBinding
import `in`.religareweather.com.databinding.FailLayoutBinding.inflate
import `in`.religareweather.com.ui.LoadScreen
import `in`.religareweather.com.ui.loadScreen.LoadViewModel
import `in`.religareweather.com.ui.loadScreen.LoaderFragment
import `in`.religareweather.com.ui.weatherScreen.WeatherFragment
import android.content.Intent
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
import javax.inject.Inject

class FailFragment : DaggerFragment(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val loadViewModel : LoadViewModel by lazy {  ViewModelProviders.of(this,viewModelFactory)[LoadViewModel::class.java]}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var failLayoutBinding:FailLayoutBinding= inflate(inflater,  container, false)
        failLayoutBinding.setLifecycleOwner(this)
        return failLayoutBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        retry_btn.setOnClickListener(View.OnClickListener {
            activity!!.finish()
            val intent = Intent(context, LoadScreen::class.java)
            startActivity(intent)
        })



    }
}