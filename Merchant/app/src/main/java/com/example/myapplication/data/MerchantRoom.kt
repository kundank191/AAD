package com.example.myapplication.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*


/**
 * Created by Kundan on 30-07-2019.
 */
@Dao
interface MerchantDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMerchant(merchant: Merchant)

    @Query("SELECT * FROM Merchant")
    fun getAllMerchants() : LiveData<List<Merchant>>

    @Query("SELECT * FROM Merchant WHERE id = :id")
    fun getMerchant(id: Int) : LiveData<Merchant>
}

@Database(entities = [Merchant::class], version = 1)
abstract class MerchantDatabase : RoomDatabase() {

    abstract fun MerchantDAO() : MerchantDAO
}

private lateinit var INSTANCE : MerchantDatabase
private const val NAME = "merchants"

fun getDatabase(context : Context) : MerchantDatabase {
    synchronized(MerchantDatabase::class.java) {
        if(!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,MerchantDatabase::class.java, NAME).build()
        }
    }
    return INSTANCE
}