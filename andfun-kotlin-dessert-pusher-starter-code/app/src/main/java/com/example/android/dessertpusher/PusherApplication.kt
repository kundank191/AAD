package com.example.android.dessertpusher

import android.app.Application
import timber.log.Timber


/**
 * Created by Kundan on 17-05-2019.
 */

class PusherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}