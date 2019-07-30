package com.example.myapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Kundan on 30-07-2019.
 */
@Entity
data class Merchant(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val mobileNumber: Int)