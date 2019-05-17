package com.example.android.guesstheword.screens.game

import androidx.lifecycle.ViewModel
import timber.log.Timber


/**
 * Created by Kundan on 17-05-2019.
 */
class GameViewModel : ViewModel() {

    init {
        Timber.d("View Model Created")
    }
    override fun onCleared() {
        super.onCleared()
        Timber.d("Cleared")
    }
}