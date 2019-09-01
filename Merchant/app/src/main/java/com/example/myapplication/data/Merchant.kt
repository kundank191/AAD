package com.example.myapplication.data

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Kundan on 30-07-2019.
 */
@Entity
data class Merchant(
    @NonNull var name: String = "",
    @Nullable var mobileNumber: Int = 0,
    @Nullable var phonePeImg: String? = null,
    @Nullable var paytmImg: String? = null,
    @Nullable var amazonImg: String? = null) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
