package com.example.myapplication.data

import androidx.lifecycle.LiveData


/**
 * Created by Kundan on 30-07-2019.
 */
class repository(private val merchantDatabase: MerchantDatabase) {

    val merchants : LiveData<List<Merchant>> = merchantDatabase.MerchantDAO().getAllMerchants()

    fun insertMerchant(merchant: Merchant) {
        merchantDatabase.MerchantDAO().insertMerchant(merchant)
    }
}