package com.example.hyper_onetask_romanywageed.utlis

import android.content.Context
import android.net.ConnectivityManager

class CommonMethod {
    fun checkNetworkConnection(context: Context): Boolean
    {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}