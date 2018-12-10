package com.xp.mvptest


import com.xp.mvptest.base.BasePresenter
import com.xp.mvptest.rx.ApiService
import com.xp.mvptest.rx.ApiSubscriber
import com.xp.mvptest.rx.DefaultTransformer
import com.xp.mvptest.rx.RetrofitUtils

class CustomerPresenterImpl(view: CustomerContract.CustomerView) : BasePresenter<CustomerContract.CustomerView>(view), CustomerContract.CustomerPresenter {

    override fun refresh(customerBean: CustomerListRequest.CustomerBean,
                         actionBean: CustomerListRequest.ActionBean,
                         type: String) {
        val request = CustomerListRequest()
        request.customer = customerBean
        request.action = actionBean
        request.pageNum = "1"
        request.pageSize = "20"
        request.type = type
        RetrofitUtils(RetrofitUtils.BASE_URL)
                .createService(ApiService::class.java)
                .getCustomerList(request)
                .compose(view.bindToLife())
                .compose(DefaultTransformer.transform())
                .subscribeWith(object : ApiSubscriber<CustomerList>() {

                    override fun onNext(homeEntity: CustomerList) {
                        view.refreshData(homeEntity)
                    }

                    override fun onError(errorCode: String, errorMsg: String) {
                        view.onError(errorCode, errorMsg)
                    }

                })
    }

}
