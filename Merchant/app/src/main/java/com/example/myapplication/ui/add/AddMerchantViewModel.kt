package com.example.myapplication.ui.add

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Merchant
import com.example.myapplication.data.Repository


/**
 * Created by Kundan on 31-07-2019.
 */
class AddMerchantViewModel(val repository: Repository) : ViewModel() {

    fun saveMerchant(merchant: Merchant) {
        repository.saveMerchant(merchant)
    }

}