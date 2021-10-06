package com.example.hyper_onetask_romanywageed.data.model

import com.google.gson.annotations.SerializedName

data class AnimationVideos(

    @SerializedName("id")
    val iD:Int ?= null,

    @SerializedName("type")
    val type:String ?= null,

    @SerializedName("url")
    val URL:String ?= null,

    @SerializedName("name")
    val name:String ?= null
)
