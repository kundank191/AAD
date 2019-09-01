package com.example.myapplication.ui.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.data.Merchant
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_add_merchant.*
import org.jetbrains.anko.toast

class AddMerchantActivity : AppCompatActivity() {

    private val REQUEST_CODE_PHONE_PE_QR = 102
    private val REQUEST_CODE_PAYTM_QR = 103
    private lateinit var viewModel: AddMerchantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_merchant)
        title = getString(R.string.title_add_merchant)

        val viewModelFactory = AddMerchantViewModelFactory(application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AddMerchantViewModel::class.java)

        bn_save.setOnClickListener {
            if (correctDetails()) {
                saveMerchant()
            }
        }

        ib_phone_pe_qr.setOnClickListener {
            ImagePicker.with(this)
                .start(REQUEST_CODE_PHONE_PE_QR)
        }

        ib_paytm_qr.setOnClickListener {
            ImagePicker.with(this)
                .compress(1024)
                .start(REQUEST_CODE_PAYTM_QR)
        }
    }

    private fun saveMerchant() {
        val merchant = Merchant()
        merchant.name = ti_merchant_name.editText!!.text.toString()
        try {
            merchant.mobileNumber = ti_merchant_mobile_number.editText!!.text.toString().toInt()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            merchant.phonePeImg = viewModel.phonePeImagePath
        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            merchant.paytmImg = viewModel.paytmImagePath
        } catch (e: Exception) {
            e.printStackTrace()
        }
        viewModel.saveMerchant(merchant)
        application.toast(getString(R.string.merchant_saved))
        finish()
    }

    private fun correctDetails() : Boolean {
        if (TextUtils.isEmpty(ti_merchant_name.editText!!.text)) {
            ti_merchant_name.error = getString(R.string.merchant_name_error)
            return false
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {

            when (requestCode) {
                REQUEST_CODE_PHONE_PE_QR -> {
                    val fileUri = data?.data
                    iv_phone_pe_qr.setImageURI(fileUri)

                    //You can also get File Path from intent
                    val filePath: String? = ImagePicker.getFilePath(data)

                    viewModel.phonePeImagePath = filePath

                    application.toast(getString(R.string.phone_pe_qr_received))

                }
                REQUEST_CODE_PAYTM_QR -> {
                    val fileUri = data?.data
                    iv_paytm_qr.setImageURI(fileUri)

                    //You can also get File Path from intent
                    val filePath: String? = ImagePicker.getFilePath(data)

                    viewModel.paytmImagePath = filePath

                    application.toast(getString(R.string.paytm_qr_received))
                }
            }

        } else {
            application.toast(getString(R.string.no_image_picked))
        }
    }
}
