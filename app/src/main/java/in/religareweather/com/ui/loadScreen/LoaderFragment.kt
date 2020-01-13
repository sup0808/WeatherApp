package `in`.religareweather.com.ui.loadScreen

import `in`.religareweather.com.databinding.LoadLayoutBinding
import `in`.religareweather.com.databinding.LoadLayoutBinding.inflate
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.load_layout.*
import javax.inject.Inject

class LoaderFragment : DaggerFragment(){

    private val TAG : String = LoaderFragment::class.java.simpleName

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel : LoadViewModel  by lazy {  ViewModelProviders.of(this,viewModelFactory)[LoadViewModel::class.java]}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : LoadLayoutBinding = inflate(inflater,  container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startLoading()
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
