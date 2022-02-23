package com.example.hilttutorials

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
/**
 * Hilt does not support retained fragments.
 * */
@HiltAndroidApp
class HiltApplication : Application() {
}