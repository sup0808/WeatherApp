package `in`.religareweather.com.ui.failScreen

import `in`.indiaonline.latest.ui.Base.BaseActivity
import `in`.religareweather.com.BR
import `in`.religareweather.com.R
import `in`.religareweather.com.databinding.FailLayoutBinding
import `in`.religareweather.com.databinding.LoadLayoutBinding
import `in`.religareweather.com.ui.loadScreen.LoadViewModel
import `in`.religareweather.com.ui.loadScreen.LoaderActivity
import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import javax.inject.Inject

class FailActivity : BaseActivity<FailLayoutBinding,FailViewModel>(){

    private val TAG = FailActivity::class.java.simpleName


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit  var failViewModel: FailViewModel
    lateinit var loadLayoutBinding: FailLayoutBinding

    var context: Context?=null


    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fail_layout
    }

    override fun getViewModel(): FailViewModel {
        failViewModel = ViewModelProviders.of(this,viewModelFactory)[FailViewModel::class.java]
        return failViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        supportActionBar!!.hide()

        loadLayoutBinding = getViewDataBinding()

    }

}