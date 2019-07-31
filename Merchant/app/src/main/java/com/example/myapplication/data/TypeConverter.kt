package com.example.myapplication.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream




/**
 * Created by Kundan on 31-07-2019.
 */
class TypeConverter {
    @TypeConverter
    fun fromDrawable(drawable: Drawable?): ByteArray? {
        return if (drawable == null) {
            null
        } else {
            val bitmap = (drawable as BitmapDrawable).bitmap
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.toByteArray()
        }
    }

    @TypeConverter
    fun byteToDrawable(byteArray: ByteArray?): Drawable? {
        return if (byteArray == null) {
            null
        } else {
            BitmapDrawable(null,BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size))
        }
    }
}