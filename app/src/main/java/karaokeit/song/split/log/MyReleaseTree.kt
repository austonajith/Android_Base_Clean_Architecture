package karaokeit.song.split.log

import android.util.Log
import timber.log.Timber

class MyReleaseTree: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {

        when(priority){
            Log.VERBOSE -> return
            Log.ERROR -> return //Add crashlytics log here
            Log.DEBUG -> return
        }
    }

}