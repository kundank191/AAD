package com.example.myapplication

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by Kundan.
 * Global executor pools for the whole application.
 * Code from codeLab : https://github.com/googlecodelabs/android-build-an-app-architecture-components/blob/arch-training-steps/app/src/main/java/com/example/android/sunshine/AppExecutors.java
 */
class AppExecutors private constructor(
    private val diskIO: Executor,
    private val mainThread: Executor
) {

    fun diskIO(): Executor {
        return diskIO
    }

    fun mainThread(): Executor {
        return mainThread
    }


    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }

    companion object {

        // For Singleton instantiation
        private val LOCK = Any()
        private var sInstance: AppExecutors? = null

        val instance: AppExecutors?
            get() {
                if (sInstance == null) {
                    synchronized(LOCK) {
                        sInstance = AppExecutors(
                            Executors.newSingleThreadExecutor(),
                            MainThreadExecutor()
                        )
                    }
                }
                return sInstance
            }
    }
}