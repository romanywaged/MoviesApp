package com.example.hyper_onetask_romanywageed.data.repository

import com.example.hyper_onetask_romanywageed.data.api.ApiService
import javax.inject.Inject

class VideoShowRepository
@Inject
constructor(private val apiService: ApiService)
{
    suspend fun getAllVideos() = apiService.getVideos()
}