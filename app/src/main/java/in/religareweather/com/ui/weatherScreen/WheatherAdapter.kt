package `in`.religareweather.com.ui.weatherScreen

import `in`.religareweather.com.BR
import `in`.religareweather.com.R
import `in`.religareweather.com.data.model.DataList
import `in`.religareweather.com.data.model.forecastdata

import `in`.religareweather.com.util.CustomTextRegular
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

import java.lang.Exception


class WheatherAdapter(internal var context: Context, rlist: MutableList<forecastdata>?) :
    RecyclerView.Adapter<WheatherAdapter.Rholder>() {
    private val rlist: MutableList<forecastdata>?
    init {
        this.rlist = rlist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rholder {
        val itemview = LayoutInflater.from(context).inflate(R.layout.forecast_temp_adapter, parent, false)
        return Rholder(itemview)
    }

    override fun onBindViewHolder(holder: Rholder, position: Int) {
        try {
            val data = rlist?.get(position)
            var mintemp = "" + data?.min_temp + context.resources.getString(R.string.Celsius)
            var maxtemp = "" + data?.max_temp + context.resources.getString(R.string.Celsius)
            holder.day_txt.text = data?.day

            holder.forecast_temp_txt.text = maxtemp + "/ " + mintemp
        }
        catch (e: Exception){
            e.printStackTrace()
        }

    }

    fun add(list: MutableList<forecastdata>) {
        rlist!!.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        rlist!!.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return rlist!!.size
    }

    inner class Rholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal  var day_txt: CustomTextRegular
        internal var forecast_temp_txt: CustomTextRegular


        init {
            day_txt = itemView.findViewById(R.id.day_txt)
            forecast_temp_txt = itemView.findViewById(R.id.forecast_temp_txt)

        }
    }
}