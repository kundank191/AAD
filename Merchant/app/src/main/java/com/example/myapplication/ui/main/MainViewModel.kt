package com.example.myapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Merchant
import com.example.myapplication.data.Repository


/**
 * Created by Kundan on 30-07-2019.
 */
class MainViewModel(repository: Repository) : ViewModel() {

    var merchants: LiveData<List<Merchant>> = repository.merchants

}