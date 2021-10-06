package com.example.hyper_onetask_romanywageed.ui.adapter

import android.animation.ObjectAnimator
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hyper_onetask_romanywageed.R
import com.example.hyper_onetask_romanywageed.data.model.AnimationVideos
import kotlinx.android.synthetic.main.video_row.view.*

class VideosAdapter(
    private val animationVideos: ArrayList<AnimationVideos>)
    :RecyclerView.Adapter<VideosAdapter.MyVideoViewHolder>()
{
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVideoViewHolder {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        val view:View = layoutInflater.inflate(R.layout.video_row, parent, false)
        return MyVideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyVideoViewHolder, position: Int) {

        if (!animationVideos[position].name!!.contains("PDF")) {
            holder.video.loadUrl(animationVideos[position].URL!!)
            holder.videoName.text = animationVideos[position].name
            holder.videoType.text = animationVideos[position].type!!
        }else
        {
            holder.video.visibility = View.VISIBLE
            holder.videoName.text = animationVideos[position].name
            holder.videoType.text = animationVideos[position].type!!
            holder.emptyVideo.setImageResource(R.drawable.pdf)
            holder.emptyVideo.visibility = View.VISIBLE
        }

        holder.arrowDownload.setOnClickListener {
            holder.progressDownload.visibility = View.VISIBLE
            holder.progressDownload.max = 10
            val currentProgress = 10
            ObjectAnimator.ofInt(holder.progressDownload, "Progress", currentProgress)
                .setDuration(5000)
                .start()
            holder.arrowDownload.setImageResource(R.drawable.ic_downloaded)
        }

    }

    override fun getItemCount(): Int {
        return animationVideos.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class MyVideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val video = itemView.video_row!!
        val videoName = itemView.name_row!!
        val videoType = itemView.type_row!!
        val arrowDownload = itemView.download_arrow_row!!
        val emptyVideo = itemView.imagePlaceHolder_row!!
        val progressDownload = itemView.progressBar_download_row!!
    }


}