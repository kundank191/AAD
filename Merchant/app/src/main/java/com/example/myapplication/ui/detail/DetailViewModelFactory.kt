package com.example.myapplication.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.Repository
import com.example.myapplication.data.getDatabase


/**
 * Created by Kundan on 30-07-2019.
 */
class DetailViewModelFactory(application: Application) : ViewModelProvider.Factory {

    private val repository = Repository(getDatabase(application))
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}