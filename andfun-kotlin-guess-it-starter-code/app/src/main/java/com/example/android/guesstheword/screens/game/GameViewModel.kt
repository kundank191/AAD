package com.example.android.guesstheword.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber


/**
 * Created by Kundan on 17-05-2019.
 */
class GameViewModel : ViewModel() {

    // The current word
    private var _word = MutableLiveData<String>()
    val word : LiveData<String>
        get() = _word
    // The current score
    private var _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() = _score
    // game finished state
    private var _gameFinished = MutableLiveData<Boolean>()
    val gameFinished : LiveData<Boolean>
        get() = _gameFinished

    // The list of words - the front of the list is the next word to guess
    lateinit var wordList: MutableList<String>

    init {
        resetList()
        nextWord()
        _score.value = 0
        _gameFinished.value = false
        Timber.d("View Model Created")
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            _gameFinished.value = true
        } else {
            _word.value = wordList.removeAt(0)
        }
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        _score.value = score.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = score.value?.plus(1)
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("Cleared")
    }

    fun onGameFinished() {
        _gameFinished.value = false
    }
}