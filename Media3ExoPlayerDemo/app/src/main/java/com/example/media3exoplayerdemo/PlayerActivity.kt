package com.example.media3exoplayerdemo

import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.OptIn
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import androidx.media3.ui.PlayerView
import com.bumptech.glide.Glide
import com.google.common.util.concurrent.ListenableFuture
import com.google.common.util.concurrent.MoreExecutors

class PlayerActivity : AppCompatActivity() {
    private lateinit var controllerFuture: ListenableFuture<MediaController>
    private val controller: MediaController?
        get() = if (controllerFuture.isDone) controllerFuture.get() else null
    private lateinit var playerView: PlayerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        playerView = findViewById(R.id.player_view)
    }

    override fun onStart() {
        super.onStart()
        initializeController()
    }

    private fun initializeController() {
        controllerFuture =
            MediaController.Builder(
                this,
                SessionToken(this, ComponentName(this, PlayBackService::class.java))
            )
                .buildAsync()
        controllerFuture.addListener({ setController() }, MoreExecutors.directExecutor())
    }

    @OptIn(UnstableApi::class)
    private fun setController() {
        val controller = this.controller ?: return
        playerView.player = controller

        updateMediaMetadataUI(controller.mediaMetadata)
        controller.addListener(
            object : Player.Listener {
                override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
                    updateMediaMetadataUI(mediaItem?.mediaMetadata ?: MediaMetadata.EMPTY)
                }

                override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {
//                    updateShuffleSwitchUI(shuffleModeEnabled)
                }

                override fun onRepeatModeChanged(repeatMode: Int) {
//                    updateRepeatSwitchUI(repeatMode)
                }
            }
        )
    }

    private fun updateMediaMetadataUI(mediaMetadata: MediaMetadata) {

//        findViewById<TextView>(R.id.titleTextView).text = mediaMetadata.displayTitle
//        val imageView = findViewById<ImageView>(R.id.imageViewTrack)
//        Glide.with(this).load(mediaMetadata.artworkUri).into(imageView)

    }

    @OptIn(UnstableApi::class)
    override fun onResume() {
        super.onResume()
        playerView.onResume()
    }

    @OptIn(UnstableApi::class)
    override fun onPause() {
        super.onPause()
        playerView.onPause()
    }

    @OptIn(UnstableApi::class)
    override fun onStop() {
        super.onStop()
        playerView.player = null
        releaseController()
    }

    private fun releaseController() {
        MediaController.releaseFuture(controllerFuture)
    }
}