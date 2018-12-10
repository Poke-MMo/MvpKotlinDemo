package com.xp.mvptest.rx

import com.xp.mvptest.CustomerList
import com.xp.mvptest.CustomerListRequest
import com.xp.mvptest.base.BaseEntity

import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiService {

    /**
     * 客户列表
     */
    @Headers("Content-Type: application/json")
    @POST("customer/query")
    fun getCustomerList(@Body request: CustomerListRequest): Flowable<BaseEntity<CustomerList>>


}
