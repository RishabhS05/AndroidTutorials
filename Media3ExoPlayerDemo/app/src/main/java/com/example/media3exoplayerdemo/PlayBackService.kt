package com.example.media3exoplayerdemo

import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.app.TaskStackBuilder
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.media3.common.AudioAttributes
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.LibraryResult
import androidx.media3.session.MediaLibraryService
import androidx.media3.session.MediaSession
import androidx.media3.session.SessionResult
import com.google.common.collect.ImmutableList
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture

class PlayBackService : MediaLibraryService() {
    lateinit var mediaLibrarySession: MediaLibrarySession
    lateinit var player: ExoPlayer
    private val librarySessionCallback = CustomMediaLibrarySessionCallback()
    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaLibrarySession? {
        return mediaLibrarySession
    }

    companion object {
        private const val SEARCH_QUERY_PREFIX_COMPAT = "androidx://media3-session/playFromSearch"
        private const val SEARCH_QUERY_PREFIX = "androidx://media3-session/setMediaUri"
    }

    override fun onCreate() {
        super.onCreate()
        initialzation()
    }

    private fun initialzation() {
        player = ExoPlayer.Builder(this).apply {
            setAudioAttributes(AudioAttributes.DEFAULT, true)
        }.build()
//        get music data
        MediaItemTree.initialize(assets)
        val parentIntent = Intent(this, MainActivity::class.java)


        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntent(parentIntent)
            val immutableFlag = if (Build.VERSION.SDK_INT >= 23) PendingIntent.FLAG_IMMUTABLE else 0
            getPendingIntent(101, immutableFlag or FLAG_UPDATE_CURRENT)
        }
        mediaLibrarySession = MediaLibrarySession.Builder(this, player, librarySessionCallback)
            .setMediaItemFiller(CustomMediaItemFiller())
            .setSessionActivity(pendingIntent)
            .build()
    }

    private class CustomMediaItemFiller : MediaSession.MediaItemFiller {
        override fun fillInLocalConfiguration(
            session: MediaSession,
            controller: MediaSession.ControllerInfo,
            mediaItem: MediaItem
        ): MediaItem {
            return MediaItemTree.getItem(mediaItem.mediaId) ?: mediaItem
        }
    }

    private inner class CustomMediaLibrarySessionCallback : MediaLibrarySession.MediaLibrarySessionCallback {
        override fun onGetLibraryRoot(session: MediaLibrarySession, browser: MediaSession.ControllerInfo, params: LibraryParams?): ListenableFuture<LibraryResult<MediaItem>> {
            return Futures.immediateFuture(LibraryResult.ofItem(MediaItemTree.getRootItem(), params))
        }

        override fun onGetItem(
            session: MediaLibrarySession,
            browser: MediaSession.ControllerInfo,
            mediaId: String
        ): ListenableFuture<LibraryResult<MediaItem>> {
            val item =
                MediaItemTree.getItem(mediaId)
                    ?: return Futures.immediateFuture(
                        LibraryResult.ofError(LibraryResult.RESULT_ERROR_BAD_VALUE)
                    )
            return Futures.immediateFuture(LibraryResult.ofItem(item, /* params= */ null))
        }


        override fun onGetChildren(
            session: MediaLibrarySession,
            browser: MediaSession.ControllerInfo,
            parentId: String,
            page: Int,
            pageSize: Int,
            params: LibraryParams?
        ): ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> {
            val children = MediaItemTree.getSongList()
                ?: return Futures.immediateFuture(
                    LibraryResult.ofError(LibraryResult.RESULT_ERROR_BAD_VALUE)
                )

            return Futures.immediateFuture(LibraryResult.ofItemList(children, params))
        }


//        override fun onSetMediaUri(
//            session: MediaSession,
//            controller: MediaSession.ControllerInfo,
//            uri: Uri,
//            extras: Bundle
//        ): Int {
//
//            if (uri.toString().startsWith(SEARCH_QUERY_PREFIX) ||
//                uri.toString().startsWith(SEARCH_QUERY_PREFIX_COMPAT)
//            ) {
//                var searchQuery =
//                    uri.getQueryParameter("query") ?: return SessionResult.RESULT_ERROR_NOT_SUPPORTED
////                setMediaItemFromSearchQuery(searchQuery)
//
//                return SessionResult.RESULT_SUCCESS
//            } else {
//                return SessionResult.RESULT_ERROR_NOT_SUPPORTED
//            }
//        }

//        private fun setMediaItemFromSearchQuery(query: String) {
//            // Only accept query with pattern "play [Title]" or "[Title]"
//            // Where [Title]: must be exactly matched
//            // If no media with exact name found, play a random media instead
//            val mediaTitle =
//                if (query.startsWith("play ", ignoreCase = true)) {
//                    query.drop(5)
//                } else {
//                    query
//                }
//
//            val item = MediaItemTree.getItemFromTitle(mediaTitle) ?: MediaItemTree.getRandomItem()
//            player.setMediaItem(item)
//            player.prepare()
//        }
    }

    override fun onDestroy() {
        player.release()
        mediaLibrarySession.release()
        super.onDestroy()
    }

}