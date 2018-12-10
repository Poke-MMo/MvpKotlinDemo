package com.xp.mvptest


import com.xp.mvptest.base.BaseView

interface CustomerContract {

    interface CustomerPresenter {

        fun refresh(customerBean: CustomerListRequest.CustomerBean,
                    actionBean: CustomerListRequest.ActionBean,
                    type: String)

    }

    interface CustomerView : BaseView {

        fun refreshData(dataList: CustomerList)

        fun onError(errorCode: String, errorMsg: String)

    }
}
