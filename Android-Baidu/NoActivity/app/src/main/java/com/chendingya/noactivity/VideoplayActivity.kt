package com.chendingya.noactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.chendingya.noactivity.R.layout.activity_videoplay;

class VideoplayActivity : AppCompatActivity() {


    private var video: VideoView? = null
    private var mMediaController: MediaController? = null
    var sig = 0
    private var bundle: Bundle? = null
    private var video_title: TextView? = null
    private var video_username: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoplay)

        //接收数据
        bundle = this.intent.extras
        video_title = findViewById(R.id.video_title)
        video_title?.setText(bundle!!.getString("video_title"))
        video_username = findViewById(R.id.video_subtitle);
        video_username?.setText(bundle!!.getString("username"))
        val uri = bundle!!.getString("src")
        video = findViewById<VideoView>(R.id.video_player)
        mMediaController = MediaController(this)
        video?.setVideoURI(Uri.parse(uri))
        video?.setVideoPath(uri)
        mMediaController!!.setMediaPlayer(video)
        video?.setMediaController(mMediaController)
        video?.start()
        sig = 1

    }


}

