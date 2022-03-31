package com.example.media3exoplayerdemo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.media3.common.MediaItem
import androidx.media3.session.LibraryResult
import androidx.media3.session.MediaBrowser
import androidx.media3.session.SessionToken
import com.google.common.util.concurrent.ListenableFuture
import com.google.common.util.concurrent.MoreExecutors


class MainActivity : AppCompatActivity() {

    private lateinit var browserFuture: ListenableFuture<MediaBrowser>
    private val browser: MediaBrowser?
        get() = if (browserFuture.isDone) browserFuture.get() else null
    private lateinit var mediaListAdapter: FolderMediaItemArrayAdapter
    private lateinit var mediaListView: ListView
    private var subItemMediaList: MutableList<MediaItem> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaListView = findViewById(R.id.media_list_view)
        mediaListAdapter = FolderMediaItemArrayAdapter(this, R.layout.folder_items, subItemMediaList)
        mediaListView.adapter = mediaListAdapter
        mediaListView.setOnItemClickListener { _, _, position, _ ->
            run {
                val selectedMediaItem = mediaListAdapter.getItem(position)!!
                if (selectedMediaItem.mediaMetadata.isPlayable == true) {
                    val browser = this.browser ?: return@run
                    browser.setMediaItems(subItemMediaList)
                    browser.shuffleModeEnabled = false
                    browser.prepare()
                    browser.seekToDefaultPosition(/* windowIndex= */ position)
                    browser.play()
                    val intent = Intent(this, PlayerActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }

    fun initialize(mediaItem: MediaItem) {
        val browser = this.browser ?: return
        val childrenFuture =
            browser.getChildren(
                mediaItem.mediaId,
                /* page= */ 0,
                /* pageSize= */ Int.MAX_VALUE,
                /* params= */ null
            )
        subItemMediaList.clear()

        childrenFuture.addListener(
            {
                val result = childrenFuture.get()!!
                val children = result.value!!
                subItemMediaList.addAll(children)
                mediaListAdapter.notifyDataSetChanged()
            },
            MoreExecutors.directExecutor()
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun releaseBrowser() {
        MediaBrowser.releaseFuture(browserFuture)
    }

    override fun onStart() {
        super.onStart()
        initializeBrowser()
    }

    private fun initializeBrowser() {
        browserFuture =
            MediaBrowser.Builder(
                this,
                SessionToken(this, ComponentName(this, PlayBackService::class.java))
            )
                .buildAsync()
        browserFuture.addListener({ pushRoot() }, MoreExecutors.directExecutor())
    }

    private fun pushRoot() {
        val browser = this.browser ?: return
        val rootFuture = browser.getLibraryRoot(/* params= */ null)
        rootFuture.addListener(
            {
                val result: LibraryResult<MediaItem> = rootFuture.get()!!
                val root: MediaItem = result.value!!
                initialize(root)
            },
            MoreExecutors.directExecutor()
        )
    }

    override fun onStop() {
        releaseBrowser()
        super.onStop()
    }

    private class FolderMediaItemArrayAdapter(
        context: Context,
        viewID: Int,
        mediaItemList: List<MediaItem>
    ) : ArrayAdapter<MediaItem>(context, viewID, mediaItemList) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val mediaItem = getItem(position)!!
            val returnConvertView =
                convertView ?: LayoutInflater.from(context).inflate(R.layout.folder_items, parent, false)
            returnConvertView.findViewById<TextView>(R.id.media_item).text = mediaItem.mediaMetadata.title
            return returnConvertView
        }
    }
}