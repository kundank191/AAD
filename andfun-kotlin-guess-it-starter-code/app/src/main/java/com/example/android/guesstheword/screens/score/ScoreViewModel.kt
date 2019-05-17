package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import timber.log.Timber


/**
 * Created by Kundan on 18-05-2019.
 */
class ScoreViewModel(finalScore : Int) : ViewModel() {

    var finalScore : Int = 0

    init {
        this.finalScore = finalScore
        Timber.d("Final score : ")
    }
}