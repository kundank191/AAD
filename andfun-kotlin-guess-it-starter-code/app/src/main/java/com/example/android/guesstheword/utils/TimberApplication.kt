package com.example.android.guesstheword.utils

import android.app.Application
import timber.log.Timber


/**
 * Created by Kundan on 17-05-2019.
 * Will be used for timber logging
 */
public class TimberApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}