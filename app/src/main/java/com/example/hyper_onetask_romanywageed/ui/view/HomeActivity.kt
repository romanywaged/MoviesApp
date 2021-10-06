package com.example.hyper_onetask_romanywageed.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hyper_onetask_romanywageed.utlis.CommonMethod
import com.example.hyper_onetask_romanywageed.R
import com.example.hyper_onetask_romanywageed.data.model.AnimationVideos
import com.example.hyper_onetask_romanywageed.ui.adapter.VideosAdapter
import com.example.hyper_onetask_romanywageed.ui.viewmodel.VideosViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlin.collections.ArrayList


@AndroidEntryPoint
class HomeActivity : AppCompatActivity()
{

    private val mainViewModel: VideosViewModel by viewModels()
    private lateinit var adapter: VideosAdapter
    private lateinit var mLayoutManager: LinearLayoutManager
    private  var animationVideos = ArrayList<AnimationVideos>()
    private var  tempVideos = ArrayList<AnimationVideos>()
    private val commonMethod = CommonMethod()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (commonMethod.checkNetworkConnection(this))
        {
            setupViewModel()

        }else
        {
            emptyList.visibility = View.VISIBLE
            progressPar.visibility = View.GONE
        }
    }

    private fun setupViewModel() {
        mainViewModel.responseVideosShow.observe(this, { listVideos->
            animationVideos = listVideos as ArrayList<AnimationVideos>
            tempVideos = animationVideos
            setUpRecycle(tempVideos)
        })
    }

    private fun setUpRecycle(temp:ArrayList<AnimationVideos>)
    {
        progressPar.visibility = View.GONE
        mLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        video_rv.layoutManager = mLayoutManager
        adapter = VideosAdapter(temp)
        video_rv.adapter = adapter
    }

}