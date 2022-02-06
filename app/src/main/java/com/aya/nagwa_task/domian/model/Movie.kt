package com.aya.nagwa_task.domian.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie (

        @SerializedName("id")
        @Expose
        val id : Int? = 0 ,

        @SerializedName("name")
        @Expose
        val name :String = "",

        @SerializedName("type")
        @Expose
        val type : String = "",

        @SerializedName("url")
        @Expose
        val url :String = ""

)



