package com.xp.mvptest

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.xp.mvptest.base.BaseActivity
import org.jetbrains.anko.find
import java.util.*

class CustomerActivity : BaseActivity<CustomerPresenterImpl>(), CustomerContract.CustomerView {

    private lateinit var mAdapter: CustomerAdapter
    private var mData = ArrayList<CustomerList.ListBean>()
    var type = "0"

    private lateinit var customerBean: CustomerListRequest.CustomerBean
    private lateinit var actionBean: CustomerListRequest.ActionBean

    override fun getLayoutId(): Int {
        return R.layout.activity_customer
    }

    override fun createPresenter(): CustomerPresenterImpl {
        return CustomerPresenterImpl(this)
    }

    override fun init() {
        customerBean = CustomerListRequest.CustomerBean()
        actionBean = CustomerListRequest.ActionBean()
        loadData()
        setAdapter()
    }

    private fun loadData() {
        mPresenter.refresh(customerBean, actionBean, type)
    }

    private fun setAdapter() {
        val rvCustomer: RecyclerView = find(R.id.rv_customer)
        val manager = LinearLayoutManager(this)
        rvCustomer.layoutManager = manager
        mAdapter = CustomerAdapter(mData)
        rvCustomer.adapter = mAdapter
    }

    /**
     * 刷新数据
     *
     * @param dataList
     */
    @TargetApi(Build.VERSION_CODES.N)
    override fun refreshData(dataList: CustomerList) {
            mData.addAll(dataList.list!!)
            mAdapter.notifyDataSetChanged()

    }

    override fun onError(errorCode: String, errorMsg: String) {

    }

}
