package `in`.religareweather.com.ui


import `in`.religareweather.com.R
import `in`.religareweather.com.ui.loadScreen.LoaderFragment
import android.os.Bundle

import android.widget.Toolbar
import dagger.android.support.DaggerAppCompatActivity



class LoadScreen : DaggerAppCompatActivity() {

    private val TAG = LoadScreen::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.load_home)
        supportActionBar!!.hide()

        supportFragmentManager.beginTransaction().replace(R.id.container,LoaderFragment()).commit()
    }


}
