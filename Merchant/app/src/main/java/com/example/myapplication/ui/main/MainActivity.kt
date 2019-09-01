package com.example.myapplication.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.ui.add.AddMerchantActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.myapplication.R.layout.activity_main)
        // initialize view model
        val viewModelFactory = MainViewModelFactory(application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)


        viewModel.merchants.observe(this, Observer { merchantList ->
            application.toast(merchantList.size.toString())

//            val imgFile = File(merchantList[2].phonePeImg ?: "hello")
//            if (imgFile.exists()) {
//                val myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath())
//                dummy_image_view.setImageBitmap(myBitmap)
//
//            }

            val adapter = MerchantAdapter(merchantList)
            rv_merchants.adapter = adapter
        })
    }

    fun showPhonepeMerchants() {
        applicationContext.toast(com.example.myapplication.R.string.phone_pe)
    }
    fun showPaytmMerchants() {
        applicationContext.toast(com.example.myapplication.R.string.paytm)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.example.myapplication.R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            com.example.myapplication.R.id.action_add_button -> {
                startActivity(Intent(this, AddMerchantActivity::class.java))
            }
            com.example.myapplication.R.id.action_phone_pe -> {
                showPhonepeMerchants()
            }
            com.example.myapplication.R.id.action_paytm -> {
                showPaytmMerchants()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
