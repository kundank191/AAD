package com.example.myapplication.ui.add

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.Repository
import com.example.myapplication.data.getDatabase


/**
 * Created by Kundan on 31-07-2019.
 */
class AddMerchantViewModelFactory(
    application: Application
) : ViewModelProvider.Factory {

    private val repository = Repository(getDatabase(application))
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddMerchantViewModel::class.java)) {
            return AddMerchantViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}