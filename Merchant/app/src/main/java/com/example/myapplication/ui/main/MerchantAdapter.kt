package com.example.myapplication.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.Merchant
import kotlinx.android.synthetic.main.list_merchant_item.view.*


/**
 * Created by Kundan on 01-08-2019.
 */
class MerchantAdapter(private val merchantList: List<Merchant>): RecyclerView.Adapter<MerchantAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_merchant_item, parent, false))
    }

    override fun getItemCount(): Int {
        return merchantList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMerchant(merchantList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindMerchant(merchant: Merchant) {
            itemView.tv_name.text = merchant.name
            itemView.tv_mobile_number.text = merchant.mobileNumber.toString()
        }

    }
}