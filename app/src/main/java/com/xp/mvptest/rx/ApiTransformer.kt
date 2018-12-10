package com.xp.mvptest.rx


import com.xp.mvptest.base.BaseEntity

import org.reactivestreams.Publisher

import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * @author: xupeng
 * @date: 2018/4/23
 * @description: 用于Data返回数据为空的情况
 */

class ApiTransformer<T> : FlowableTransformer<T, T> {

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream.onBackpressureBuffer()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                // 通用错误处理，判断code
                .map { t ->
                    if ((t as BaseEntity<*>).code != "000") {
                        throw ApiException((t as BaseEntity<*>).code!!,
                                (t as BaseEntity<*>).msg!!)
                    }
                    t
                }
    }

    companion object {
        fun <T> create(): ApiTransformer<T> {
            return ApiTransformer()
        }
    }
}
