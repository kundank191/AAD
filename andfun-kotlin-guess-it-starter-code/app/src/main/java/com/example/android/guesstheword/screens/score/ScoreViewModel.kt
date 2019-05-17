package com.example.android.guesstheword.screens.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber


/**
 * Created by Kundan on 18-05-2019.
 */
class ScoreViewModel(finalScore : Int) : ViewModel() {

    private var _finalScore = MutableLiveData<String>()
    val finalScore : LiveData<String>
        get() = _finalScore

    init {
        _finalScore.value = finalScore.toString()
        Timber.d("Final score : ")
    }
}