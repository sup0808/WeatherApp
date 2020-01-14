package `in`.religareweather.com.data.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResult(
    @SerializedName("data")
    var coord :Coord,
    var wind :Wind,
    var weather :MutableList<weather>,
    var main :Main ,
    var clouds :Clouds,
    var sys : Sys,
    var base : String,
    var visibility : Int,
    var dt : Int,
    var id :Int,
    var name : String,
    var cod : Int


)

data class Coord(
    var lon :Double ?= 0.0,
    var lat :Double ?= 0.0

)

data class Wind(
    var speed :Double ?= 0.0,
    var deg :Int ?= 0

)

data class weather(
    var id :Int ?= 0,
    var main :String ?= null,
    var description :String ?= null,
    var icon :String ?= null

)

data class Main(
    var temp :Double ?= 0.0,
    var pressure :Int ?= 0,
    var humidity :Int ?= 0,
    var temp_min :Double ?= 0.0,
    var temp_max :Double ?= 0.0

)

data class Clouds(
    var all :Int ?= 0)

data class Sys(
    var type :Int ?= 0,
    var id :Int ?= 0,
    var message :Double ?= 0.0,
    var country :String ?= null,
    var sunrise :Int ?= 0,
    var sunset :Int ?= 0

)
