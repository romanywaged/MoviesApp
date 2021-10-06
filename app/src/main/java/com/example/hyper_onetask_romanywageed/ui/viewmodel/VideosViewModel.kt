package com.example.hyper_onetask_romanywageed.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hyper_onetask_romanywageed.data.model.AnimationVideos
import com.example.hyper_onetask_romanywageed.data.repository.VideoShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VideosViewModel
@Inject
constructor(private val repository: VideoShowRepository) :ViewModel()
{
    private val videosResponse = MutableLiveData<List<AnimationVideos>>()

    val responseVideosShow : LiveData<List<AnimationVideos>> get() = videosResponse


    init {
        getAllVideos()
    }

    private fun getAllVideos() = viewModelScope.launch {
        repository.getAllVideos().let { response ->

            if (response.isSuccessful) {
                videosResponse.postValue(response.body())
            }else
            {
                Log.d("romany_app", " Error: ${response.code()}")

            }

        }

    }

}