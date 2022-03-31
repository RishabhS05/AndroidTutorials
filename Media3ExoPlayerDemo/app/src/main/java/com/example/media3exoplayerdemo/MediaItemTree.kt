package com.example.media3exoplayerdemo

import android.content.res.AssetManager
import android.net.Uri
import androidx.annotation.OptIn
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.util.UnstableApi
import androidx.media3.common.util.Util

import org.json.JSONObject

object MediaItemTree {
    private var isInitialized = false
    private const val ROOT_ID = "media"
    lateinit var mediaRoot: MediaItemNode

    @OptIn(UnstableApi::class)
    private fun loadJsonFromAssets(assets: AssetManager): String {
        val buffer = assets.open("catalog.json").use { Util.toByteArray(it) }
        return String(buffer, Charsets.UTF_8)
    }

    class MediaItemNode(val item: MediaItem, val children: MutableList<MediaItem>)


    fun initialize(assets: AssetManager) {
        if (isInitialized) return
        val jsonObject = JSONObject(loadJsonFromAssets(assets))
        val mediaList = jsonObject.getJSONArray(ROOT_ID)
        val songList = arrayListOf<MediaItem>()
        for (i in 0 until mediaList.length()) {
            songList.add(parseMediaItem(mediaList.getJSONObject(i)))
        }
        mediaRoot = MediaItemNode(buildMediaItem(title = "Root Folder", mediaId = ROOT_ID, isPlayable = false, folderType = MediaMetadata.FOLDER_TYPE_MIXED), songList)

    }

    fun parseMediaItem(mediaObject: JSONObject): MediaItem {
        val id = mediaObject.getString("id")
        val album = mediaObject.getString("album")
        val title = mediaObject.getString("title")
        val artist = mediaObject.getString("artist")
//        val sourceUri = Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
        val sourceUri = Uri.parse(mediaObject.getString("source"))
        val imageUri = Uri.parse(mediaObject.getString("image"))
        val genre = mediaObject.getString("genre")
        return buildMediaItem(
            title = title,
            mediaId = id,
            album = album,
            artist = artist,
            genre = genre,
            sourceUri = sourceUri,
            imageUri = imageUri,
        )
    }

    private fun buildMediaItem(
        title: String,
        mediaId: String,
        album: String? = null,
        artist: String? = null,
        genre: String? = null,
        sourceUri: Uri? = null,
        isPlayable: Boolean? = true,
        imageUri: Uri? = null,
        @MediaMetadata.FolderType folderType: Int = MediaMetadata.FOLDER_TYPE_NONE
    ): MediaItem {
        val metadata =
            MediaMetadata.Builder()
                .setAlbumTitle(album)
                .setTitle(title)
                .setArtist(artist)
                .setGenre(genre)
                .setIsPlayable(isPlayable)
                .setArtworkUri(imageUri)
                .setFolderType(folderType)
                .build()
        return MediaItem.Builder()
            .setMediaId(mediaId)
            .setMediaMetadata(metadata)
            .setUri(sourceUri)
            .build()
    }

    fun getSongList() = mediaRoot.children
    fun getItemFromTitle(title: String): MediaItem? {
        return mediaRoot.children.first {
            it.mediaMetadata.displayTitle == title
        }
    }

    fun getRandomItem(): MediaItem {
        return mediaRoot.children.random()
    }

    fun getItem(id: String): MediaItem? {
        return mediaRoot.children.first {
            it.mediaId == id
        }
    }

    fun getRootItem(): MediaItem {
        return mediaRoot.item
    }

}