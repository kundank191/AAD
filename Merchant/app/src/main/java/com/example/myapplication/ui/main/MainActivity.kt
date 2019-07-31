package com.example.myapplication.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.ui.add.AddMerchantActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showPhonepeMerchants() {
        applicationContext.toast(R.string.phone_pe)
    }
    fun showPaytmMerchants() {
        applicationContext.toast(R.string.paytm)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add_button -> {
                startActivity(Intent(this, AddMerchantActivity::class.java))
            }
            R.id.action_phone_pe -> {
                showPhonepeMerchants()
            }
            R.id.action_paytm -> {
                showPaytmMerchants()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
