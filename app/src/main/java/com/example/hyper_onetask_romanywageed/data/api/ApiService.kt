package com.example.hyper_onetask_romanywageed.data.api

import com.example.hyper_onetask_romanywageed.utlis.GET_VIDEOS_API
import com.example.hyper_onetask_romanywageed.data.model.AnimationVideos
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET(GET_VIDEOS_API)
    suspend fun getVideos() : Response<ArrayList<AnimationVideos>>
}