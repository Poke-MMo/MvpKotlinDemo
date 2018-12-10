package com.xp.mvptest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomerAdapter(private val list: List<CustomerList.ListBean>) : RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_customer_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerAdapter.ViewHolder, position: Int) {
        holder.mText.text = list[position].brand
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mText: TextView

        init {
            mText = itemView.findViewById(R.id.tv_band_name)
        }
    }


    /*@Override
    protected void convert(BaseViewHolder helper, CustomerList.ListBean item) {
        helper.setText(R.id.tv_band_name, item.getFullBrand())
                .setText(R.id.tv_company_name, item.getCustomerCompany())
                .setText(R.id.tv_follow_status, item.getFollowStatus())
                .setText(R.id.tv_type, item.getLevel())
                .addOnClickListener(R.id.img_call)
                .setGone(R.id.img_call, StringUtils.isEmpty(item.getPhone()) ? false : true)
                .setVisible(R.id.tv_time, StringUtils.isEmpty(item.getTime()) ? false : true)
                .setText(R.id.tv_time, "实际跟进时间：" + item.getTime())
                .setVisible(R.id.img_ocean, StringUtils.isEmpty(item.getReason()) ? false : true)
                .setGone(R.id.img_red_line, item.getIsRed() == 1 ? true : false);
    }*/
}
