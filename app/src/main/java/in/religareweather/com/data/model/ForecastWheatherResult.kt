package `in`.religareweather.com.data.model

import com.google.gson.annotations.SerializedName

data class ForecastWheatherResult (
    @SerializedName("data")
    var cod : String?= null,
    var message : Int=0,
    var cnt : Int= 0,
    var list : MutableList<DataList>,
    var city : City

)


data class City(
    var id :Int ?= 0,
    var name :String ?= null,
    var country: String ?= null,
    var population :Int =0,
    var timezone : Int =0,
    var sunrise :Int ?= 0,
    var sunset :Int ?= 0,
    var coord : CoordFore

)

data class CoordFore(
    var lat :Double ?= 0.0,
    var lon :Double ?= 0.0
)

data class DataList(
    var dt : Double,
    var dt_txt : String ?=null,
    var coord :CloudsFore,
    var wind :WindFore,
    var weather :MutableList<weatherFore>,
    var main :MainFore ,
    var sys : SysFore

)

data class MainFore(
    var temp :Double = 0.0,
    var pressure :Int = 0,
    var humidity :Int = 0,
    var temp_min :Double = 0.0,
    var temp_max :Double = 0.0

)

data class weatherFore(
    var id :Int ?= 0,
    var main :String ?= null,
    var description :String ?= null,
    var icon :String ?= null

)

data class CloudsFore(
    var all :Int ?= 0)

data class SysFore(

    var pod :String ?= null


)

data class WindFore(
    var speed :Double ?= 0.0,
    var deg :Int ?= 0

)