package com.example.myapplication.data

import androidx.lifecycle.LiveData
import com.example.myapplication.AppExecutors


/**
 * Created by Kundan on 30-07-2019.
 */
class Repository(private val merchantDatabase: MerchantDatabase) {

    val merchants : LiveData<List<Merchant>> = merchantDatabase.MerchantDAO().getAllMerchants()

    fun saveMerchant(merchant: Merchant) {
        AppExecutors.instance!!.diskIO().execute(Runnable {
            merchantDatabase.MerchantDAO().insertMerchant(merchant)
        })
    }
}