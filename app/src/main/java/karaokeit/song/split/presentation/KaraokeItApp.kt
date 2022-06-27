package karaokeit.song.split.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import karaokeit.song.split.BuildConfig
import karaokeit.song.split.log.MyReleaseTree
import timber.log.Timber


@HiltAndroidApp
class KaraokeItApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        val tree = if (BuildConfig.DEBUG) Timber.DebugTree() else MyReleaseTree()
        Timber.plant(tree)
    }
}