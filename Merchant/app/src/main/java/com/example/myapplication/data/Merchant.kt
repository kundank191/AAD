package com.example.myapplication.data

import android.graphics.drawable.Drawable
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Kundan on 30-07-2019.
 */
@Entity
data class Merchant(
    @NonNull var name: String = "",
    @Nullable var mobileNumber: Int = 0,
    @Nullable @ColumnInfo(typeAffinity = ColumnInfo.BLOB) var phonePeImg: Drawable? = null,
    @Nullable @ColumnInfo(typeAffinity = ColumnInfo.BLOB) var paytmImg: Drawable? = null,
    @Nullable @ColumnInfo(typeAffinity = ColumnInfo.BLOB) var amazonImg: Drawable? = null) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
